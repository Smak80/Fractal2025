package ru.smak.painting;

import ru.smak.graphics.utils.Converter;

import java.awt.*;

public class FractalPainter implements Painter{

    private final Converter conv;

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

    }

}
