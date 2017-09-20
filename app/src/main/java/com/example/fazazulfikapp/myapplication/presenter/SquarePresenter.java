package com.example.fazazulfikapp.myapplication.presenter;

import com.example.fazazulfikapp.myapplication.model.Square;
import com.example.fazazulfikapp.myapplication.view.fragment.SquareFragment;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class SquarePresenter {

    private Square square = new Square();
    private SquareFragment squareFragment;

    public SquarePresenter(SquareFragment squareFragment) {
        this.squareFragment = squareFragment;
    }

    public void calculateKeliling(double p, double l) {
        square.setP(p);
        square.setL(l);
        squareFragment.showResult(square.keliling());
    }

    public void calculateLuas(double p, double l) {
        square.setP(p);
        square.setL(l);
        squareFragment.showResult(square.luas());
    }
}
