package ru.smak.fractals.ui;

import ru.smak.graphics.utils.Converter;
import ru.smak.painting.FractalPainter;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static final int MIN_SZ = GroupLayout.PREFERRED_SIZE;
    private static final int MAX_SZ = GroupLayout.DEFAULT_SIZE;

    private PaintPanel mainPanel;

    private final Converter conv = new Converter(-2.0, 1.0, -1.0, 1.0, 0, 0);
    private final FractalPainter fp = new FractalPainter(conv);

    public MainWindow(){
        Dimension minSz = new Dimension(800, 600);
        setMinimumSize(minSz);
        setTitle("Множество Мандельброта");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initializeComponents();

        GroupLayout gl = new GroupLayout(getContentPane());
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addComponent(mainPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                .addGap(8)
        );
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(mainPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                )
                .addGap(8)
        );
        setLayout(gl);

        pack();
    }

    private void initializeComponents() {
        mainPanel = new PaintPanel();
        mainPanel.setBackground(Color.WHITE);

        mainPanel.addPaintAction(_ -> fp.paint(mainPanel.getGraphics()));
    }
}