package com.example.fazazulfikapp.myapplication.model;

/**
 * Created by Faza Zulfika P P on 9/19/2017.
 */

public class Circle extends Shape {

    private double r;

    public Circle() {}

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double keliling() {
        return 2 * Math.PI * r;
    }

    @Override
    public double luas() {
        return Math.PI * Math.pow(r, 2);
    }
}
