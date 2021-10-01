package ui;

import model.Obstacle;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Gui implements ActionListener, KeyListener {

    public static int WIDTH = 800;
    public static int HEIGHT = 800;

    public static Gui gui;

    public JFrame jframe;
    public Renderer renderer;
    public Timer timer;


    public Player player;
    public Obstacle obstacle;

    public int score;
    public boolean gameStatus;

    public Gui() {
        jframe = new JFrame();

        timer = new Timer(20, this);
        renderer = new Renderer();


        jframe.add(renderer);

        jframe.setResizable(false);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle("Game");
        jframe.addKeyListener(this);
        jframe.setVisible(true);

        player = new Player(WIDTH, HEIGHT);
        obstacle = new Obstacle();

        gameStatus = true;


        obstacle.addObstacle();
        obstacle.addObstacle();
        obstacle.addObstacle();
        obstacle.addObstacle();


        timer.start();
    }

    public void repaint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.getHSBColor(0, 75, 65));
        g.fillRect(0,HEIGHT-150, WIDTH, 150);

        g.setColor(Color.green);
        g.fillRect(0,HEIGHT-150, WIDTH, 20);


        g.setColor(Color.red);
        g.fillRect(player.player.x, player.player.y, player.player.width, player.player.height);

        for (Rectangle obstacle: obstacle.obstacles) {
            paintObstacle(g, obstacle);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.PLAIN, 30));
        if (gameStatus) {
            g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
        } else {
            g.drawString("Game Over! Press space to restart.", 100, HEIGHT / 2 - 50);
        }
    }

    public void paintObstacle(Graphics g, Rectangle ob) {
        g.setColor(Color.gray);
        g.fillRect(ob.x,ob.y,ob.width,ob.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStatus) {
            gameStatus = player.playerAction(obstacle);
        }
        score = player.score;
        renderer.repaint();



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!gameStatus) {
                player = new Player(WIDTH, HEIGHT);
                obstacle.obstacles.clear();
                score = 0;

                obstacle.addObstacle();
                obstacle.addObstacle();
                obstacle.addObstacle();
                obstacle.addObstacle();

                gameStatus = true;

            } else {
                player.jump();
            }
        }
    }

    public static void main(String[] arg) {
        gui = new Gui();
    }

}

