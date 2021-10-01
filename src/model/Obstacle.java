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

    public void addObstacle(boolean add) {
        int width = 10;
        int height = 20;
        int WIDTH = 800;
        int HEIGHT = 800;

        if (add) {
            obstacles.add(new Rectangle(WIDTH + obstacles.size() * 300 + rand.nextInt(1000), HEIGHT - height - 150, width, height));
        } else {
            obstacles.add(new Rectangle(obstacles.get(obstacles.size() - 1).x + 600, HEIGHT - height - 150, width, height));
        }
    }
}
