
import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.GameFlow;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.LevelInformation;
import sprites.Counter;
import animation.AnimationRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * This class runs the game.
 */
public class Ass6Game {
    /**
     * This main runs the game.
     *
     * @param args - nothing.
     */
    public static void main(String[] args) {
        Counter counterLives = new Counter(7);
        Counter counterScore = new Counter();
        boolean isNumber;
        int sum = 0;
        int number = 0;
        List<LevelInformation> levels = new ArrayList<>();
        GUI gui = new GUI("Arkanoid", 800, 600);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        AnimationRunner animationRunner = new AnimationRunner(gui, 60);
        for (int i = 0; i < args.length; i++) {
            isNumber = true;
            try {
                number = Integer.parseInt(args[i]);
            } catch (Exception e) {
                isNumber = false;
            }
            if (isNumber) {
                if (number == 1) {
                    levels.add(new Level1());
                    sum = sum + 105;
                } else if (number == 2) {
                    levels.add(new Level2());
                    sum = sum + 175;
                } else if (number == 3) {
                    sum = sum + 300;
                    levels.add(new Level3());
                } else if (number == 4) {
                    sum = sum + 625;
                    levels.add(new Level4());
                }
            }
        }
        if (levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
            sum = 1205;
        }
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor, counterLives,
                counterScore, gui, sum - 100);
        gameFlow.runLevels(levels);
    }
}
