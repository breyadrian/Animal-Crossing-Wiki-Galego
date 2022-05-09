package com.example.acwiki.client.DTOs;
import org.json.JSONException;
import org.json.JSONObject;

public class availabilityDTO {

   private String month_northern;
   private String month_southern;
   private String time;
   private boolean isAllDay;
   private boolean isAllYear;
   private String location;
   private String rarity;
   private JSONObject month_array_northern;
   private JSONObject month_array_southern;
   private JSONObject time_array;

    public availabilityDTO(JSONObject jsonObject) throws JSONException {
        this.month_northern = jsonObject.getString("month-northern");
        this.month_southern= jsonObject.getString("month-southern");
        this.time = jsonObject.getString("time");
        this.isAllDay = jsonObject.getBoolean("isAllDay");
        this.isAllYear = jsonObject.getBoolean("isAllYear");
        this.location = jsonObject.getString("location");
        this.rarity = jsonObject.getString("rarity");
        this.month_array_northern = jsonObject.getJSONObject("month-array-northern");
        this.month_array_southern = jsonObject.getJSONObject("month-array-southern");
        this.time_array =jsonObject.getJSONObject(" time-array");
    }

    public String getMonth_northern() {
        return month_northern;
    }

    public String getTime() {
        return time;
    }

    public boolean isAllDay() {
        return isAllDay;
    }

    public boolean isAllYear() {
        return isAllYear;
    }

    public String getLocation() {
        return location;
    }

    public String getRarity() {
        return rarity;
    }

    public JSONObject getMonth_array_northern() {
        return month_array_northern;
    }

    public JSONObject getMonth_array_southern() {
        return month_array_southern;
    }

    public JSONObject getTime_array() {
        return time_array;
    }
}
