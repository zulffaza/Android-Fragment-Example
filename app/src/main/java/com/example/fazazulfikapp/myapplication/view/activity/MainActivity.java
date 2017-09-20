package com.example.fazazulfikapp.myapplication.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fazazulfikapp.myapplication.R;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveActivity(View view) {
        Intent intent = new Intent(this, ShapeActivity.class);
        intent.putExtra("shapeName", ((Button) view).getText().toString());

        startActivity(intent);
    }
}
