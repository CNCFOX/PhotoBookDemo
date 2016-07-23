package com.cfox.photobookdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openOne(View view) {
        Intent intent = new Intent(this,MultiImageSelectOneActivity.class);
        startActivity(intent);
    }


    public void openTwo(View view) {
        Intent intent = new Intent(this,MultiImageSelectTwoActivity.class);
        startActivity(intent);
    }
}
