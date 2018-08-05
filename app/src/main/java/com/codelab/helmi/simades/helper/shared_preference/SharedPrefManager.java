package com.codelab.helmi.simades.helper.shared_preference;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_SISAN_APP = "spSimadesApp";
    public static final String SP_USERNAME = "spUsername";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    public static final String SP_NAMA_USER = "spNamaUser";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_SISAN_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
        spEditor.apply();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSpUsername() {
        return sp.getString(SP_USERNAME, "");
    }

    public String getSpNamaUser() { return sp.getString(SP_NAMA_USER, ""); }

    public boolean getSPSudahLogin() {
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
