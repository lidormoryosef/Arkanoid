package levels;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import listeners.ScoreTrackingListener;
import sprites.Counter;
import sprites.ScoreIndicator;
import animation.AnimationRunner;
import java.util.List;

/**
 * moving from one level to the next.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter counterScore;
    private Counter counterLives;
    private GUI gui;
    private int sum;

    /**
     * contractor.
     * @param ar , Animation runner.
     * @param ks , sensor
     * @param counterLives , counter of lives in the game.
     * @param counterScore , counter score.
     * @param gui , screen.
     * @param sum , the number of score to win.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter counterLives,
                    Counter counterScore, GUI gui, int sum) {
        this.ar = ar;
        this.ks = ks;
        this.counterScore = counterScore;
        this.counterLives = counterLives;
        this.gui = gui;
        this.sum = sum;
    }

    /**
     * run the levels one after one.
     * @param levels , list of levels.
     */

    public void runLevels(List<LevelInformation> levels) {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.counterScore);
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreTrackingListener);
        for (int i = 0; i < levels.size(); i++) {
            boolean firstTime = true;
            this.ar.setCounterBlock(new Counter(levels.get(i).numberOfBlocksToRemove()));
            this.ar.setCounterBall(new Counter(levels.get(i).numberOfBalls()));
            scoreIndicator.setName(levels.get(i).levelName());
            scoreIndicator.setLive(counterLives.getValue());
            GameLevel level = new GameLevel(levels.get(i), this.ks, this.ar, scoreIndicator,
                    scoreTrackingListener, this.counterLives, this.counterScore);
            level.setGui(this.gui);
            level.setSum(this.sum);
            level.initialize();
            while (this.ar.getCounterBall().getValue() != 0 && this.ar.getCounterBlock().getValue() != 0) {
                while (this.counterLives.getValue() > 0) {
                    level.run();
                    if (this.ar.getCounterBall().getValue() == 0) {
                        counterLives.decrease(1);
                        if (firstTime) {
                            level.getSprites().getListSprite().remove(1);
                            level.getEnvironment().getListCollidable().remove(0);
                            firstTime = false;
                        } else {
                            level.getSprites().getListSprite().remove(level.getSprites().getListSprite().size() - 1);
                            level.getEnvironment().getListCollidable().
                                    remove(level.getEnvironment().getListCollidable().size() - 1);
                        }
                        scoreIndicator.setLive(counterLives.getValue());
                        level.createBalls();
                        level.createPaddle();
                        level.setSprites(level.getSprites());
                        level.setEnvironment(level.getEnvironment());
                        this.ar.setCounterBall(new Counter(levels.get(i).numberOfBalls()));
                        level.run();
                    }
                    if (this.ar.getCounterBlock().getValue() == 0) {
                        this.counterScore.increase(100);
                        break;
                    }
                }
            }
            firstTime = true;
        }

    }

}
