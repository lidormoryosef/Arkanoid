package levels;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 4.
 */
public class Level4 implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int BORDER_SIZE = 25;
    private static final int BLOCK_W = 50;
    private static final int BLOCK_H = 20;
    private static final double PADDLE_WIDTH = 120;
    private List<Velocity> velocityList;
    private int speedPaddle;
    private List<Block> blocks;
    /**
     * constructor.
     */
    public Level4() {
        this.velocityList = new ArrayList<>();
        this.velocityList.add(Velocity.fromAngleAndSpeed(0, 4));
        this.velocityList.add(Velocity.fromAngleAndSpeed(70, 3));
        this.velocityList.add(Velocity.fromAngleAndSpeed(290, 5));
        this.speedPaddle = 10;
        this.blocks = new ArrayList<>();
    }

    @Override
    public int numberOfBalls() {
        return this.velocityList.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velocityList;
    }

    @Override
    public int paddleSpeed() {
        return this.speedPaddle;
    }

    @Override
    public int paddleWidth() {
        return (int) PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {

        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(50, 80, 150));
                d.fillRectangle(0, 0, 1000, 800);
                int x = 150, y = 380;
                int x1 = x, y1 = y;
                d.setColor(new Color(192, 192, 192));
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 100; j = j + 2) {
                        d.drawLine(x, y, x - 1, y + 7);
                        x = x - 2;
                        y = y + 10;
                    }
                    x1 = x1 + 10;
                    x = x1;
                    y = y1;

                }
                d.setColor(new Color(192, 192, 192));
                d.fillCircle(150, 380, 25);
                d.setColor(new Color(192, 192, 192));
                d.fillCircle(170, 400, 25);
                d.setColor(new Color(169, 169, 169));
                d.fillCircle(190, 370, 30);
                d.setColor(new Color(132, 136, 132));
                d.fillCircle(230, 385, 35);
                d.setColor(new Color(132, 136, 132));
                d.fillCircle(210, 400, 35);
                x = 610;
                y = 430;
                x1 = x;
                y1 = y;
                d.setColor(new Color(192, 192, 192));
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 100; j = j + 2) {
                        d.drawLine(x, y, x - 1, y + 7);
                        x = x - 2;
                        y = y + 10;
                    }
                    x1 = x1 + 10;
                    x = x1;
                    y = y1;

                }
                d.setColor(new Color(192, 192, 192));
                d.fillCircle(600, 430, 25);
                d.setColor(new Color(192, 192, 192));
                d.fillCircle(620, 450, 25);
                d.setColor(new Color(169, 169, 169));
                d.fillCircle(640, 420, 30);
                d.setColor(new Color(132, 136, 132));
                d.fillCircle(680, 435, 35);
                d.setColor(new Color(132, 136, 132));
                d.fillCircle(660, 450, 35);

                x = 460;
                y = 350;
                x1 = x;
                y1 = y;
                d.setColor(new Color(192, 192, 192));
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 100; j = j + 2) {
                        d.drawLine(x, y, x - 1, y + 7);
                        x = x - 2;
                        y = y + 10;
                    }
                    x1 = x1 + 10;
                    x = x1;
                    y = y1;

                }
                d.setColor(new Color(192, 192, 192));
                d.fillCircle(450, 350, 25);
                d.setColor(new Color(192, 192, 192));
                d.fillCircle(470, 370, 25);
                d.setColor(new Color(169, 169, 169));
                d.fillCircle(490, 340, 30);
                d.setColor(new Color(132, 136, 132));
                d.fillCircle(530, 355, 35);
                d.setColor(new Color(132, 136, 132));
                d.fillCircle(510, 370, 35);
            }

            @Override
            public void timePassed() {

            }

            @Override
            public void addToGame(GameLevel g) {

            }
        };
    }

    @Override
    public List<Block> blocks() {
        Point uppLeft = new Point(WIDTH - BORDER_SIZE, 220);
        Color[] arrCol = {Color.cyan, Color.pink, Color.white, Color.green, Color.yellow, Color.red, Color.gray};
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Point point = new Point(uppLeft.getX() - (j + 1) * BLOCK_W, uppLeft.getY());
                Block block = new Block(new Rectangle(point, BLOCK_W, BLOCK_H), arrCol[i]);
                blocks.add(block);
            }
            uppLeft = new Point(WIDTH - BORDER_SIZE, uppLeft.getY() - BLOCK_H);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}
