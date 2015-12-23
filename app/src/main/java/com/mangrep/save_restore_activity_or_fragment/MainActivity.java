package com.mangrep.save_restore_activity_or_fragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();

    //These variable will destroyed with Activity
    private String someVariable1;
    private String someVariable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        someVariable1 = "var1";
        someVariable2 = "var2";
    }

    /*
     *View will be automatically saved by android. Just save the class variables
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("someVariable1", someVariable1);
        outState.putString("someVariable2", someVariable2);
    }

    /*
     *get saved variables
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "someVariable1 = " + someVariable1 + " someVariable2 = " + someVariable2);
        someVariable1 = savedInstanceState.getString("someVariable1");
        someVariable2 = savedInstanceState.getString("someVariable2");
    }
}
