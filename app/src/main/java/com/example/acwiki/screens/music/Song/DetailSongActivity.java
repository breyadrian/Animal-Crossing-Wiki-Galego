package com.example.acwiki.screens.music.Song;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.screens.music.MusicData;
import com.example.acwiki.screens.music.SongData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DetailSongActivity extends AppCompatActivity {
    private SongData data;
    Button play;
    SeekBar seekBar;
    private Handler myHandler = new Handler();
    private double inicioCancion=0;
    private double finalCancion=0;
    private TextView txt1;
    AdminSQLiteOpenHelper conn;
    private TextView txt2;
    Runnable runnable;
    byte[] cancion;
    ImageView portada;
    MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_song);
        this.portada= findViewById(R.id.portadaDisco);
        data = getIntent().getParcelableExtra("data");
        Bitmap bm= BitmapFactory.decodeByteArray(data.getImage_uri(), 0 ,data.getImage_uri().length);
        portada.setImageBitmap(bm);
        txt1= findViewById(R.id.tiempoInicio);
        txt2= findViewById(R.id.tiempoFinal);
        seekBar= findViewById(R.id.seekBar);

        play = (Button) findViewById(R.id.play);

        try {
            conn=new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);
            SQLiteDatabase db=conn.getReadableDatabase();


            Cursor cursor = db.rawQuery("SELECT music_uri FROM Canciones where id='"+data.getId()+"'",null);

            if(cursor.moveToFirst()){
                do{
                    cancion =cursor.getBlob(0);
                }while(cursor.moveToNext());
            }



            File tempMp3 = File.createTempFile("kurchina", "mp3", getCacheDir());
            tempMp3.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(cancion);
            fos.close();
            FileInputStream fis = new FileInputStream(tempMp3);


            mediaPlayer.setDataSource(fis.getFD());

            mediaPlayer.prepare();

            inicioCancion=mediaPlayer.getCurrentPosition();
            finalCancion=mediaPlayer.getDuration();


            txt1.setText(String.format("%d:%d", TimeUnit.MICROSECONDS.toMinutes((long) inicioCancion),
                    TimeUnit.MICROSECONDS.toMinutes((long) inicioCancion) -
                            TimeUnit.MICROSECONDS.toMinutes(TimeUnit.MICROSECONDS.toMinutes((long)
                                    inicioCancion)))
            );
            txt2.setText(String.format("%d:%d", TimeUnit.MICROSECONDS.toMinutes((long) finalCancion),
                    TimeUnit.MICROSECONDS.toMinutes((long) finalCancion) -
                            TimeUnit.MICROSECONDS.toMinutes(TimeUnit.MICROSECONDS.toMinutes((long)
                                    finalCancion)))
            );


            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    seekBar.setMax((int)finalCancion);
                    playCycle();
                    mediaPlayer.start();
                }
            });


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                    if(input){
                        mediaPlayer.seekTo(progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


            seekBar.setProgress((int)inicioCancion);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playPause(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();

            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        }else{
            mediaPlayer.start();
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }

    }

    public void playCycle(){
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying()){
            runnable= new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            myHandler.postDelayed(runnable,100);
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
        myHandler.removeCallbacks(runnable);
    }
}