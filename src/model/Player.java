package model;

import java.awt.*;

public class Player {

    public Rectangle player;
    public int speed;
    public int dy;
    public int tick;
    public boolean jumped;
    public int score;

    public Player(int w, int h) {
        player = new Rectangle(w / 2 - 10, h - 150 - 20, 20, 20);
        speed = 10;
        dy = 0;
        score = 0;
    }

    public boolean playerAction(Obstacle obstacle) {

        tick++;

        for (int i = 0; i < obstacle.obstacles.size(); i++) {
            Rectangle ob = obstacle.obstacles.get(i);

            ob.x -= speed;
        }

        if (tick % 2 == 0 && dy < 15) {
            dy += 1;
        }

        for (int i = 0; i < obstacle.obstacles.size(); i++) {
            Rectangle column = obstacle.obstacles.get(i);

            if (column.x + column.width < 0) {
                obstacle.obstacles.remove(column);
                obstacle.addObstacle();

            }
        }


        if (jumped) {
            player.y += dy;
            jumped = false;
        }

        if (player.y < 630) {
            player.y += dy;
        }





        for (Rectangle o : obstacle.obstacles) {
            if (player.x > o.x && player.x < o.x + o.width) {
                score++;
            }

            if (o.intersects(player)) {
                player.x = o.x - player.width;
                return false;
            }
        }
        return true;
    }

    public void jump() {

        if (player.y > 610) {


            if (dy > 0) {

                dy = -8;
            }

            jumped = true;
        }
    }

}
