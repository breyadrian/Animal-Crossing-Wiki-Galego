package com.example.acwiki.screens.villagers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;

public class DetailVillagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_villager);


        String nombre = getIntent().getStringExtra("nombre");
        byte[] image = getIntent().getByteArrayExtra("imagen");
        int id = getIntent().getIntExtra("id", 0);
        String birthday = getIntent().getStringExtra("birthday");
        String birthday_string = getIntent().getStringExtra("birthday_string");
        String personality = getIntent().getStringExtra("personality");
        String gender = getIntent().getStringExtra("gender");
        String species = getIntent().getStringExtra("species");
        String catch_phrase = getIntent().getStringExtra("catch_phrase");


        Bitmap bm = BitmapFactory.decodeByteArray(image, 0, image.length);


        personality = getPersonality(personality);

        gender=getGender(gender);

        TextView genderTxt = findViewById(R.id.villagerGender);
        genderTxt.setText("Xénero: " + gender);

        TextView speciesTxt = findViewById(R.id.villagerSpecies);
        speciesTxt.setText("Especie: " + species);

        TextView catch_phraseTxt = findViewById(R.id.villagerCatch_phrase);
        catch_phraseTxt.setText("Frase de captura: " + primeraMayuscula(catch_phrase));

        TextView villagerName = findViewById(R.id.villagerName);
        villagerName.setText("Nome: " + primeraMayuscula(nombre));

        TextView birthdayTxt = findViewById(R.id.birthday);
        birthdayTxt.setText("Cumpleanos: " + birthday);

        TextView personalityTxt = findViewById(R.id.personality);
        personalityTxt.setText("Personalidade: " + personality);


        ImageView villagerImage = findViewById(R.id.villagerImage);
        villagerImage.setImageBitmap(bm);

        TextView villagerId = findViewById(R.id.villagerId);
        villagerId.setText("Identificador: " + id);


    }

    public String primeraMayuscula(String palabra) {
        String str = palabra;
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());
        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;

        return str;
    }

    public String getGender(String gender){
        switch (gender) {
            case ("Female"):
                gender = "Femenino";
                break;
            case ("Male"):
                gender = "Masculino";
                break;
        }
        return gender;
    }

    public String getPersonality (String personality){

        switch (personality){
            case ("Jock"):
                personality="Atlético";
                break;
            case ("Uchi"):
                personality="Doce";
                break;
            case ("Cranky"):
                personality="Malhumorado";
                break;
            case ("Normal"):
                personality="Normal";
                break;
            case ("Lazy"):
                personality="Preguiceiro";
                break;
            case ("Peppy"):
                personality="Alegre";
                break;
            case ("Smug"):
                personality="Esnob";
                break;
            case ("Snooty"):
                personality="Presumida";
                break;

        }

        return personality;
    }

}