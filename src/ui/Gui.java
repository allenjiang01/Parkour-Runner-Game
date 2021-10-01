package ui;

import model.Obstacle;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Gui implements ActionListener {

    public static int WIDTH = 800;
    public static int HEIGHT = 800;

    public static Gui gui;

    public JFrame jframe;
    public Renderer renderer;
    public Timer timer;

    public ImageIcon characterImage;
    public JLabel character;
    public BufferedImage image;

    public Player player;
    public Obstacle obstacle;

    public Gui() {
        jframe = new JFrame();

        timer = new Timer(20, this);
        renderer = new Renderer();


        jframe.add(renderer);

        jframe.setResizable(false);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle("Game");
        jframe.setVisible(true);

        player = new Player(WIDTH, HEIGHT);
        obstacle = new Obstacle();


        obstacle.addObstacle(true);
        obstacle.addObstacle(true);
        obstacle.addObstacle(true);
        obstacle.addObstacle(true);

//        try{
//            image = ImageIO.read(new File("Cow.png"));
//        } catch(IOException e){
//            System.out.println("Error");
//        }

//        characterImage = new ImageIcon("Cow.png");
//        character = new JLabel(characterImage);
//        character.setVisible(true);
//        jframe.add(character);

        timer.start();
    }

    public void repaint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.orange);
        g.fillRect(0,HEIGHT-150, WIDTH, 150);

        g.setColor(Color.green);
        g.fillRect(0,HEIGHT-150, WIDTH, 20);

        System.out.println("Hello");

        g.setColor(Color.red);
        g.fillRect(player.player.x, player.player.y, player.player.width, player.player.height);

        for (Rectangle obstacle: obstacle.obstacles) {
            paintObstacle(g, obstacle);
        }

       // g.fillRect(image.getMinX(), image.getMinY(), image.getWidth(), image.getHeight());
    }

    public void paintObstacle(Graphics g, Rectangle ob) {
        g.setColor(Color.gray);
        g.fillRect(ob.x,ob.y,ob.width,ob.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("asdasd");
        player.playerAction();
        renderer.repaint();
    }

    public static void main(String[] arg) {
        gui = new Gui();
    }
}
