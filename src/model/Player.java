package model;

import java.awt.*;

import ui.Gui;

public class Player {

    public Rectangle player;
    public Obstacle obstacle;
    public int speed;
    public int yCoord;
    public int tick;

    public Player(int w, int h) {
        player = new Rectangle(w / 2 - 10, h / 2 - 10, 20, 20);
        speed = 10;
    }

    public boolean playerAction() {

        tick++;

        for (int i = 0; i < obstacle.obstacles.size(); i++) {
            Rectangle ob = obstacle.obstacles.get(i);

            ob.x -= speed;
        }

        if (tick % 2 == 0 && yCoord < 15) {
            yCoord += 2;
        }

        for (int i = 0; i < obstacle.obstacles.size(); i++) {
            Rectangle column = obstacle.obstacles.get(i);

            if (column.x + column.width < 0) {
                obstacle.obstacles.remove(column);

                if (column.y == 0) {
                    obstacle.addObstacle(false);
                }
            }
        }

//            bird.y += yMotion;
//
//            for (Rectangle column : obstacle)
//            {
//                if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10)
//                {
//                    score++;
//                }
//
//                if (column.intersects(bird))
//                {
//                    gameOver = true;
//
//                    if (bird.x <= column.x)
//                    {
//                        bird.x = column.x - bird.width;
//
//                    }
//                    else
//                    {
//                        if (column.y != 0)
//                        {
//                            bird.y = column.y - bird.height;
//                        }
//                        else if (bird.y < column.height)
//                        {
//                            bird.y = column.height;
//                        }
//                    }
//                }
//            }
//
//            if (bird.y > HEIGHT - 120 || bird.y < 0)
//            {
//                gameOver = true;
//            }
//
//            if (bird.y + yMotion >= HEIGHT - 120)
//            {
//                bird.y = HEIGHT - 120 - bird.height;
//                gameOver = true;
//            }
//        }
        return false;
    }
}
