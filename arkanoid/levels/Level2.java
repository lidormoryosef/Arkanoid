package levels;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 2.
 */
public class Level2 implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int BORDER_SIZE = 25;
    private static final int BLOCK_W = 45;
    private static final int BLOCK_H = 20;
    private static final double PADDLE_WIDTH = 500;
    private List<Velocity> velocityList;
    private int speedPaddle;
    private List<Block> blocks;

    /**
     * constructor.
     */
    public Level2() {
        this.velocityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double angle = (double) 180 / 10;
            velocityList.add(new Velocity(5 * Math.cos(Math.toRadians(angle * i)),
                    0.5 - 5 * Math.sin(Math.toRadians(angle * i))));
        }

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
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {

        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.white);
                d.fillRectangle(0, 0, 1000, 800);
                for (int i = 0; i < 700; i = i + 6) {
                    d.setColor(new Color(230, 235, 150));
                    d.drawLine(140, 150, i, 250);

                }
                d.setColor(new Color(230, 235, 150));
                d.fillCircle(140, 150, 60);
                d.setColor(new Color(230, 235, 100));
                d.fillCircle(140, 150, 50);
                d.setColor(new Color(255, 230, 0));
                d.fillCircle(140, 150, 40);

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
        Point uppLeft = new Point(25, 300);
        for (int i = 0; i < 15; i++) {
            if (i == 0 || i == 1) {
                Block block = new Block(new geometry.Rectangle(new Point(i * 50 + 25, 250), 50, BLOCK_H), Color.red);
                blocks.add(block);
            }
            if (i == 2 || i == 3) {
                Block block = new Block(new geometry.Rectangle(new Point(i * 50 + 25, 250), 50, BLOCK_H), Color.orange);
                blocks.add(block);
            }
            if (i == 4 || i == 5) {
                Block block = new Block(new geometry.Rectangle(new Point(i * 50 + 25, 250), 50, BLOCK_H), Color.yellow);
                blocks.add(block);
            }
            if (i == 6 || i == 7 || i == 8) {
                Block block = new Block(new geometry.Rectangle(new Point(i * 50 + 25, 250), 50, BLOCK_H), Color.green);
                blocks.add(block);
            }
            if (i == 9 || i == 10) {
                Block block = new Block(new geometry.Rectangle(new Point(i * 50 + 25, 250), 50, BLOCK_H), Color.blue);
                blocks.add(block);
            }
            if (i == 11 || i == 12) {
                Block block = new Block(new geometry.Rectangle(new Point(i * 50 + 25, 250), 50, BLOCK_H), Color.pink);
                blocks.add(block);
            }
            if (i == 13 || i == 14) {
                Block block = new Block(new geometry.Rectangle(new Point(i * 50 + 25, 250), 50, BLOCK_H), Color.cyan);
                blocks.add(block);
            }

        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}
