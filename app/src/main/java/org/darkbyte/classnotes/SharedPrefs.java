package org.darkbyte.classnotes;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by root on 1/11/17.
 */

public class SharedPrefs {

    Context context;

    public static final String myprefs = "myprefs";

    public static final String semester="semester";
        public static final String department="department";
        public static final String subject="subject";
        public static final String chapter="chapter";


    public static final String firstopen=null;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    public SharedPrefs(Context context) {
        this.context = context;
        sharedpreferences = context.getSharedPreferences(myprefs, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }



    public void saveprefs(String department,String semester,String subject,String chapter,String value){

        editor.putString(department+semester+subject+chapter,value);
        editor.commit();
    }

    public void clearprefs(String department,String semester,String subject,String chapter) {
        editor.putString(department+semester+subject+chapter, null);

        editor.commit();
    }
    public  String getdownloadstatus(String department,String semester,String subject,String chapter) {
        return sharedpreferences.getString(department+semester+subject+chapter,null);
    }



}
