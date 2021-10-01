package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Obstacle {

    public ArrayList<Rectangle> obstacles;
    public Random rand;

    public Obstacle() {
        obstacles = new ArrayList<>();
        rand = new Random();
    }

    public void addObstacle() {
        int width = 10;
        int height = 20;
        int WIDTH = 800;
        int HEIGHT = 800;


        obstacles.add(new Rectangle(WIDTH + obstacles.size() * 500 + rand.nextInt(600), HEIGHT - height - 150, width, height));
    }
}
