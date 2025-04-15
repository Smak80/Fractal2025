package ru.smak.fractals.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class PaintPanel extends JPanel {
    class MouseButtonAndMotionListener extends MouseAdapter{

        public Rect rect = new Rect();

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            rect.clear();
            rect.addPoint(e.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            if (rect.isValid()) {
                drawRect(rect);
            }
            rect.addPoint(e.getPoint());
            if (rect.isValid()){
                drawRect(rect);
            }
        }
    }

    private Consumer<Graphics> paintAction = null;
    private boolean scalable = false;
    private MouseButtonAndMotionListener mbl = new MouseButtonAndMotionListener();

    public boolean isScalable() {
        return scalable;
    }

    public void setScalable(boolean scalable) {
        if (scalable != this.scalable) {
            this.scalable = scalable;
            if (scalable) {
                addMouseListener(mbl);
                addMouseMotionListener(mbl);
            } else {
                removeMouseListener(mbl);
                removeMouseMotionListener(mbl);
            }
        }
    }

    public void setPaintAction(Consumer<Graphics> action){
        paintAction = action;
    }

    public void removePaintAction(){
        paintAction = null;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (paintAction != null) paintAction.accept(g);
    }

    private void drawRect(Rect r){
        var g = getGraphics();
        g.setXORMode(Color.WHITE);
        g.setColor(Color.BLACK);
        try {
            g.drawRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
        } catch (InvalidRectException e){}
        finally {
            g.setPaintMode();
        }
    }
}
