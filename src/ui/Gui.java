package ui;

import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    public static int WIDTH = 800;
    public static int HEIGHT = 800;

    public static Gui gui;

    public JFrame jframe;
    public Renderer renderer;
    public Timer timer;

    public Gui() {
        createFrame();
        timer = new Timer(20, this);
        renderer = new Renderer();

        jframe.add(renderer);
    }

    public void createFrame() {
        jframe = new JFrame();

        jframe.setResizable(false);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);


    }

    public void repaint(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }
}
