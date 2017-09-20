package com.example.fazazulfikapp.myapplication.model;

/**
 * Created by Faza Zulfika P P on 9/19/2017.
 */

public class Trapezoidal extends Shape {

    private double a, b, t;

    public Trapezoidal() {}

    public Trapezoidal(double a, double b, double t) {
        this.a = a;
        this.b = b;
        this.t = t;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    @Override
    public double keliling() {
        return 0;
    }

    @Override
    public double luas() {
        return ((a + b) * t) / 2;
    }
}
