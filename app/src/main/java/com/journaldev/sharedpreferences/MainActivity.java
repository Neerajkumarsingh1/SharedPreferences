package com.journaldev.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    SharedPreferences sharedpreferences;
    EditText name;
    EditText email;
    EditText pass;
    EditText cpass;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String PASS = "pass";
    public static final String CPASS = "cpass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        pass = (EditText) findViewById(R.id.edPass);
        cpass=(EditText) findViewById(R.id.cpass);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
       /* if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }*/

    }

    public void Save(View view) {

        String n = name.getText().toString();
        String e = email.getText().toString();
        String p = pass.getText().toString();
        String cp = cpass.getText().toString();
/*
        if(n.equals("")|| n.length()==0
                || e.equals("")||e.length()==0
                || p.equals("")||p.length()==0
                ||cp.equals("")||cp.length()==0
                ){

        }*/
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.putString(PASS,p);
        editor.putString(CPASS,cp);
        editor.commit();
    }

    public void clear(View view) {
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        pass = (EditText) findViewById(R.id.edPass);
        cpass =(EditText) findViewById(R.id.cpass);
        name.setText("");
        email.setText("");
        pass.setText("");
        cpass.setText("");

    }

    public void Get(View view) {
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        pass = (EditText) findViewById(R.id.edPass);
        cpass = (EditText) findViewById(R.id.cpass);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains(PASS)) {
            pass.setText(sharedpreferences.getString(PASS, ""));

        }
        if (sharedpreferences.contains(CPASS)) {
            cpass.setText(sharedpreferences.getString(CPASS, ""));

        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




}
