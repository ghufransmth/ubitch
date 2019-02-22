package com.example.macbookpro.ubeatz.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ghufran on 11/26/2017.
 */

public class SharedPrefManager {

    public static final String SP_MAHASISWA_APP = "spMahasiswaApp";

    public static final String SP_ID = "id";

    public static final String SP_ID_NEWS = "id_news";

    public static final String SP_FULLNAME = "fullname";

    public static final String SP_USERNAME = "username";

    public static final String SP_PASSWORD = "password";

    public static final String SP_EMAIL = "email";

    public static final String SP_LEVEL = "user_level";

    public static final String SP_JABATAN = "kode_jabatan";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    public static final String SP_CHECK = "check";

    public static final String SP_SUCCESS = "status";

    public static final String SP_RESULT = "result";

    public static final String SP_RETURN = "return";

    public static final String SP_COUNTS = "counts";

    public static final String SP_ATTEMPT = "attempt";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_MAHASISWA_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
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

    public String getSpFullname(){
        return sp.getString(SP_FULLNAME, "");
    }

    public String getSpUsername(){
        return sp.getString(SP_USERNAME, "");
    }

    public String getSpPassword(){
        return sp.getString(SP_PASSWORD, "");
    }

    public String getSpEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public String getSpLevel(){
        return sp.getString(SP_LEVEL, "");
    }

    public String getSpJabatan(){
        return sp.getString(SP_JABATAN, "");
    }

    public String getSpId(){
        return sp.getString(SP_ID, "");
    }

    public String getSpIdNews(){
        return sp.getString(SP_ID_NEWS, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public Integer getSPCheck(){
        return sp.getInt(SP_CHECK, -1);
    }
}
