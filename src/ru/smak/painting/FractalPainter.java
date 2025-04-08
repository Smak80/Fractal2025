package ru.smak.painting;

import ru.smak.graphics.utils.Converter;

import java.awt.*;

public class FractalPainter implements Painter, Runnable{

    private final Converter conv;
    private Thread paintThread = null;
    private Graphics g = null;

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
        this.g = g;
        if (paintThread != null && paintThread.isAlive()){
            stop();
            try {
                paintThread.join();
            } catch (InterruptedException _){}
            finally { paintThread = null; }
        }
        paintThread = new Thread(this);
        paintThread.start();
    }

    @Override
    public void run() {
        if (g != null) {
            g.setColor(Color.RED);
            g.fillRect(30, 30, 200, 250);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                g.setColor(Color.YELLOW);
                g.fillRect(30, 30, 200, 250);
            }
            g.setColor(Color.GREEN);
            g.fillRect(30, 30, 200, 250);
        }
    }

    private void stop(){
        if (paintThread != null) paintThread.interrupt();
    }
}
