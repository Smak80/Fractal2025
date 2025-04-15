package ru.smak.math.fractals;

import ru.smak.math.Complex;

public class Mandelbrot {

    private int maxIter = 200;
    private final double R2 = 4.0;

    public boolean isInSet(Complex c){
        int i = 0;
        Complex z = new Complex();
        while (i++ <= maxIter && z.abs2() < R2){
            z.timesAssign(z);
            z.plusAssign(c);
        }
        return i > maxIter;
    }
}
