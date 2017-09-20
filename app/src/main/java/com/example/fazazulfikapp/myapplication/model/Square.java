package com.example.fazazulfikapp.myapplication.model;

/**
 * Created by Faza Zulfika P P on 9/19/2017.
 */

public class Square extends Shape {

    private double p, l;

    public Square() {}

    public Square(double p) {
        this(p, p);
    }

    public Square(double p, double l) {
        this.p = p;
        this.l = l;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    @Override
    public double keliling() {
        return 2 * (p + l);
    }

    @Override
    public double luas() {
        return p * l;
    }
}
