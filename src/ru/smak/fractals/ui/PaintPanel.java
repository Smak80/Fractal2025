package ru.smak.fractals.ui;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public class PaintPanel extends JPanel {

    private final ArrayList<Consumer<Graphics>> paintActions = new ArrayList<>();

    public void addPaintAction(Consumer<Graphics> action){
        paintActions.add(action);
    }

    public void removePaintAction(Consumer<Graphics> action){
        paintActions.remove(action);
    }

    public void removeAllPaintActions(){
        paintActions.clear();
    }

    @Override
    public void paint(Graphics g){
        if (g == null) return;
        super.paint(g);
        for(var paintAction: paintActions) {
            paintAction.accept(g);
        }
    }

}
