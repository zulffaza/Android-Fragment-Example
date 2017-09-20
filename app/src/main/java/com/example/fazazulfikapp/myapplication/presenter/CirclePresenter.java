package com.example.fazazulfikapp.myapplication.presenter;

import com.example.fazazulfikapp.myapplication.model.Circle;
import com.example.fazazulfikapp.myapplication.view.fragment.CircleFragment;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class CirclePresenter {

    private Circle circle = new Circle();
    private CircleFragment circleFragment;

    public CirclePresenter(CircleFragment circleFragment) {
        this.circleFragment = circleFragment;
    }

    public void calculateKeliling(double r) {
        circle.setR(r);
        circleFragment.showResult(circle.keliling());
    }

    public void calculateLuas(double r) {
        circle.setR(r);
        circleFragment.showResult(circle.luas());
    }
}
