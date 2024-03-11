package levels;

import animation.Animation;
import animation.AnimationRunner;
import animation.CountdownAnimation;
import animation.EndScreen;
import animation.KeyPressStoppableAnimation;
import animation.PauseScreen;
import animation.WinScreen;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;

import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Velocity;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import sprites.Ball;
import sprites.Block;
import sprites.Collidable;
import sprites.Counter;
import sprites.GameEnvironment;
import sprites.Paddle;
import sprites.ScoreIndicator;
import sprites.Sprite;
import sprites.SpriteCollection;


/**
 * create the game.
 */
public class GameLevel implements Animation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER_SIZE = 25;
    private static final double PADDLE_HEIGHT = 20;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private biuoop.KeyboardSensor keyboard;
    private AnimationRunner runner;
    private Boolean running;
    private LevelInformation information;
    private Counter counterBall;
    private Counter counterBlock;
    private ScoreIndicator scoreIndicator;
    private ScoreTrackingListener scoreTrackingListener;
    private Counter counterLives;
    private Counter counterScore;
    private GUI gui;
    private int sum;


    /**
     * constructor.
     *
     * @param information           , the information of we need to run level.
     * @param keyboard              , sensor.
     * @param runner                , runner.
     * @param scoreIndicator        . update the score on the screen.
     * @param scoreTrackingListener , updating the score indicator to update th score.
     * @param counterLives          , counter of lives in the game.
     * @param counterScore          , counter score.
     */
    public GameLevel(LevelInformation information, KeyboardSensor keyboard, AnimationRunner runner,
                     ScoreIndicator scoreIndicator, ScoreTrackingListener scoreTrackingListener,
                     Counter counterLives) {
        this.running = true;
        this.information = information;
        this.counterBall = new Counter();
        this.counterBlock = new Counter();
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.keyboard = keyboard;
        this.runner = runner;
        this.runner.setCounterBall(this.counterBall);
        this.runner.setCounterBlock(this.counterBlock);
        this.scoreIndicator = scoreIndicator;
        this.scoreTrackingListener = scoreTrackingListener;
        this.counterLives = counterLives;
        this.counterScore = scoreTrackingListener.getCurrentScore();
    }

    /**
     * setter.
     *
     * @param sum ,the number of score to win.
     */
    public void setSum(int sum) {
        this.sum = sum;

    }

    /**
     * setter.
     *
     * @param gui ,the screen.
     */
    public void setGui(GUI gui) {
        this.gui = gui;
    }

    /**
     * this function create all the borders and return arr of them.
     */
    public void limits() {
        BallRemover ballRemover = new BallRemover(this, this.counterBall);
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new geometry.Rectangle(new Point(0, 0), WIDTH, 45), Color.GRAY));
        blocks.add(new Block(new geometry.Rectangle(new Point(0, -20), WIDTH, 45), Color.black));
        blocks.add(new Block(new geometry.Rectangle(new Point(-20, 0), 45, HEIGHT), Color.GRAY));
        blocks.add(new Block(new geometry.Rectangle(new Point(-100, HEIGHT + 20), WIDTH + 300, 45),
                Color.GRAY));
        blocks.get(3).addHitListener(ballRemover);
        blocks.add(new Block(new geometry.Rectangle(new Point(WIDTH - BORDER_SIZE, 0), BORDER_SIZE, HEIGHT),
                Color.GRAY));
        for (int i = 0; i < 5; i++) {
            blocks.get(i).addToGame(this);
        }

    }

    /**
     * add a sprite to the array list in sprites.SpriteCollection.
     *
     * @param s , sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * remove collidable from the list.
     *
     * @param c , collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getListCollidable().remove(c);
    }

    /**
     * remove sprite from the list.
     *
     * @param s , sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getListSprite().remove(s);
    }

    /**
     * add a collidable to the array list in environment game.
     *
     * @param c , collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * these function create all the balls and add them to the game.
     */
    public void createBalls() {
        ArrayList<Ball> balls = new ArrayList<>();
        for (int i = 0; i < information.numberOfBalls(); i++) {
            balls.add(new Ball(new Point(400, 568), 6, Color.white));
            balls.get(i).setVelocity(new Velocity(information.initialBallVelocities().get(i).getDx(),
                    information.initialBallVelocities().get(i).getDy()));
            balls.get(i).setGameEnvironment(this.environment);
            balls.get(i).addToGame(this);
            counterBall.increase(1);
        }

    }

    /**
     * initialize the game.
     */
    public void initialize() {
        this.sprites.addSprite(information.getBackground());
        limits();
        List<Block> blocks = information.blocks();
        BlockRemover blockRemover = new BlockRemover(this, this.counterBlock);
        this.sprites.addSprite(this.scoreIndicator);
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).addToGame(this);
            blocks.get(i).addHitListener(this.scoreTrackingListener);
            blocks.get(i).addHitListener(blockRemover);
            this.counterBlock.increase(1);
        }
        createBalls();
        createPaddle();
    }

    /**
     * creating the paddle.
     */
    public void createPaddle() {
        Paddle paddle = new Paddle(new Block(new Point((400 - (double) information.paddleWidth() / 2),
                (double) HEIGHT - BORDER_SIZE - PADDLE_HEIGHT + 25), information.paddleWidth(),
                PADDLE_HEIGHT, Color.ORANGE), keyboard, information.paddleSpeed());
        paddle.addToGame(this);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        if (this.counterBall.getValue() != 0 && this.counterLives.getValue() != 0) {
            this.runner.run(new CountdownAnimation(3, 3, this.sprites));
        }
        this.running = true;
        this.runner.setCounterBlock(counterBlock);
        this.runner.setCounterBall(counterBall);
        this.runner.run(this);

    }

    /**
     * return the sprites.SpriteCollection.
     *
     * @return sprites.SpriteCollection.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * update the sprites.SpriteCollection.
     *
     * @param sprites , sprites.SpriteCollection
     */
    public void setSprites(SpriteCollection sprites) {
        this.sprites = sprites;
    }

    /**
     * return the sprites.GameEnvironment.
     *
     * @return , sprites.GameEnvironment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * update the sprites.GameEnvironment.
     *
     * @param environment , sprites.GameEnvironment.
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.counterBlock.getValue() == 0) {
            this.running = false;
        }
        if (this.counterBall.getValue() == 0) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(keyboard)));
        }
        if (this.counterScore.getValue() == this.sum) {
            this.running = false;
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new WinScreen(this.keyboard, this.counterScore)));
            gui.close();
        }
        if (this.counterLives.getValue() == 0) {
            this.running = false;
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new EndScreen(this.keyboard, this.counterScore)));
            gui.close();
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}

