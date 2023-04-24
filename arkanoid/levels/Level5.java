package levels;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level5.
 */
public class Level5 implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int BORDER_SIZE = 25;
    private static final int BLOCK_W = 45;
    private static final int BLOCK_H = 20;
    private static final double PADDLE_WIDTH = 120;
    private List<Velocity> velocityList;
    private int speedPaddle;
    private Sprite backGround;
    private List<Block> blocks;

    /**
     * constructor.
     */
    public Level5() {
        this.velocityList = new ArrayList<>();
        this.velocityList.add(new Velocity(3, -3));
        this.velocityList.add(new Velocity(-3, -3));
        this.velocityList.add(new Velocity(3, 3));
        this.velocityList.add(new Velocity(3, 3));
        this.speedPaddle = 10;
        this.backGround = new Block(new Point(0, 0), 1000, 800, new Color(50, 80, 150));
        this.blocks = new ArrayList<>();
    }
    /**
     * this function create the cage in game.
     *
     * @return list of blocks.
     */

    public java.util.List<Block> cage() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new geometry.Rectangle(new Point(340, 120), 120, 25), Color.GRAY));
        blocks.add(new Block(new geometry.Rectangle(new Point(340, 45), 25, 75), Color.GRAY));
        blocks.add(new Block(new geometry.Rectangle(new Point(435, 45), 25, 75), Color.GRAY));

        return blocks;

    }


    /**
     * this function create all the blocks and add them to the game.
     */


    @Override
    public int numberOfBalls() {
        return 3;
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
        return this.backGround;
    }

    @Override
    public List<Block> blocks() {
        Point uppLeft = new Point(WIDTH - BORDER_SIZE, 300);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i + 9; j++) {
                Point point = new Point(uppLeft.getX() - (j + 1) * BLOCK_W, uppLeft.getY());
                if (i == 2 && j == 8) {
                    Block block = new Block(new geometry.Rectangle(point, 5 * BLOCK_W, BLOCK_H), Color.pink);
                    blocks.add(block);
                    block.setColor(new Color(100, 200, 255));
                    continue;
                }
                if (i == 2 && (j >= 4 && j <= 8)) {
                    continue;
                }
                Block block = new Block(new Rectangle(point, BLOCK_W, BLOCK_H), Color.cyan);
                blocks.add(block);
                if (i == 3 && j == 6) {
                    block.setColor(Color.black);
                } else if ((i == 3 && (j == 2 || j == 10)) || (i == 5 && j == 6) || (i == 1 && j == 6)) {
                    block.setColor(Color.pink);

                }
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
