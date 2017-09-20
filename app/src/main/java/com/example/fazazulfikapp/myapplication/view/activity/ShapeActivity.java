package com.example.fazazulfikapp.myapplication.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fazazulfikapp.myapplication.R;
import com.example.fazazulfikapp.myapplication.view.fragment.CircleFragment;
import com.example.fazazulfikapp.myapplication.view.fragment.SquareFragment;
import com.example.fazazulfikapp.myapplication.view.fragment.TrapezoidalFragment;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class ShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);

        setFragment();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home :
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setFragment() {
        String id = getIntent().getExtras().getString("shapeName");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (id != null) {
            ActionBar actionBar = getSupportActionBar();

            if (actionBar != null) {
                actionBar.setTitle(id);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            switch (id) {
                case "Lingkaran": // Circle
                    CircleFragment circleFragment = new CircleFragment();
                    fragmentTransaction.replace(R.id.fl_shape, circleFragment).commit();
                    break;
                case "Persegi": // Square
                    SquareFragment squareFragment = new SquareFragment();
                    fragmentTransaction.replace(R.id.fl_shape, squareFragment).commit();
                    break;
                case "Trapesium": // Trapezoidal
                    TrapezoidalFragment trapezoidalFragment = new TrapezoidalFragment();
                    fragmentTransaction.replace(R.id.fl_shape, trapezoidalFragment).commit();
                    break;
                default:
                    errorView("View not found");
            }
        } else
            errorView("View not found");
    }

    private void errorView(String message) {
        setToast(message);
        finish();
    }

    private void setToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
