package ru.smak.painting;

import ru.smak.graphics.utils.Converter;
import ru.smak.math.Complex;
import ru.smak.math.fractals.Mandelbrot;

import java.awt.*;

public class FractalPainter implements Painter{

    private final Converter conv;
    private final Mandelbrot m = new Mandelbrot();

    public FractalPainter(Converter conv){
        this.conv = conv;
    }

    @Override
    public void setWidth(int width) {
        conv.setWidth(width);
    }

    @Override
    public int getWidth() {
        return conv.getWidth();
    }

    @Override
    public void setHeight(int height) {
        conv.setHeight(height);
    }

    @Override
    public int getHeight() {
        return conv.getHeight();
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < conv.getWidth(); i++){
            for (int j = 0; j < conv.getHeight(); j++){
                var x = conv.xScr2Crt(i);
                var y = conv.yScr2Crt(j);
                if (m.isInSet(new Complex(x, y))){
                    g.setColor(Color.BLACK);
                    g.fillRect(i, j, 1, 1);
                } else {
                    g.setColor(Color.WHITE);
                }

            }
        }
    }

}
