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
 * level 1.
 */
public class Level1 implements LevelInformation {
    private static final double PADDLE_WIDTH = 120;
    private List<Velocity> velocityList;
    private int speedPaddle;
    private List<Block> blocks;

    /**
     * constructor.
     */
    public Level1() {
        this.velocityList = new ArrayList<>();
        this.velocityList.add(new Velocity(0, -3));
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.black);
                d.fillRectangle(0, 0, 1000, 1000);
                d.setColor(Color.blue);
                d.drawCircle(400, 205, 60);
                d.drawCircle(400, 205, 100);
                d.drawCircle(400, 205, 140);
                d.drawLine(425, 205, 575, 205);
                d.drawLine(375, 205, 225, 205);
                d.drawLine(400, 180, 400, 30);
                d.drawLine(400, 230, 400, 380);
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
        this.blocks.add(new Block(new Rectangle(new Point(385, 190), 30, 30), Color.red));
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}
