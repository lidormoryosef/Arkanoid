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
 * level 3.
 */
public class Level3 implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int BORDER_SIZE = 25;
    private static final int BLOCK_W = 45;
    private static final int BLOCK_H = 20;
    private static final double PADDLE_WIDTH = 120;
    private List<Velocity> velocityList;
    private int speedPaddle;
    private List<Block> blocks;

    /**
     * constructor.
     */
    public Level3() {
        this.velocityList = new ArrayList<>();
        this.velocityList.add(new Velocity(3, -3));
        this.velocityList.add(new Velocity(-3, -3));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.green);
                d.fillRectangle(0, 0, 1000, 800);
                d.setColor(new Color(242, 210, 189));
                d.fillCircle(133, 165, 15);
                d.setColor(Color.red);
                d.fillCircle(133, 165, 10);
                d.setColor(Color.white);
                d.fillCircle(133, 165, 5);
                d.setColor(new Color(52, 52, 52));
                d.fillRectangle(125, 175, 15, 200);
                d.setColor(new Color(27, 18, 18));
                d.fillRectangle(110, 360, 45, 100);
                d.setColor(new Color(20, 20, 0));
                d.fillRectangle(75, 430, 110, 280);
                int x = 85, y = 440;
                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < 5; i++) {
                        d.setColor(Color.white);
                        d.fillRectangle(x, y, 12, 25);
                        x = x + 20;
                    }
                    x = 85;
                    y = y + 35;
                }
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
        Point uppLeft = new Point(WIDTH - BORDER_SIZE, 250);
        Color[] arrCol = {Color.white, Color.blue, Color.yellow, Color.red, Color.gray};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 6; j++) {
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
