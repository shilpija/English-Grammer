package com.rdseducation.english.grammer;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedData {

    public SharedPreferences sharedPreferences;
    private Context context;

    public SharedData(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("ShareData", Context.MODE_PRIVATE);
    }

    public void AddData(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void AddData(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean checkData(String key) {
        return sharedPreferences.contains(key);
    }

    public String getValue(String key) {
        String val = sharedPreferences.getString(key, "");
        return val;
    }

    public Boolean getBoolValue(String key) {
        boolean val = sharedPreferences.getBoolean(key, true);
        return val;
    }

    public void removeData(String key) {
        sharedPreferences.edit().remove(key).commit();
    }

    public void clear(){
        sharedPreferences.edit().clear().commit();
    }
}
