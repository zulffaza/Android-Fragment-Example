package com.example.fazazulfikapp.myapplication.presenter;

import com.example.fazazulfikapp.myapplication.model.Trapezoidal;
import com.example.fazazulfikapp.myapplication.view.fragment.TrapezoidalFragment;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class TrapezoidalPresenter {

    private Trapezoidal trapezoidal = new Trapezoidal();
    private TrapezoidalFragment trapezoidalFragment;

    public TrapezoidalPresenter(TrapezoidalFragment trapezoidalFragment) {
        this.trapezoidalFragment = trapezoidalFragment;
    }

    public void calculateKeliling(double a, double b, double t) {
        trapezoidal.setA(a);
        trapezoidal.setB(b);
        trapezoidal.setT(t);
        trapezoidalFragment.showResult(trapezoidal.keliling());
    }

    public void calculateLuas(double a, double b, double t) {
        trapezoidal.setA(a);
        trapezoidal.setB(b);
        trapezoidal.setT(t);
        trapezoidalFragment.showResult(trapezoidal.luas());
    }
}
