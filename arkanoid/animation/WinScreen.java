package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import sprites.Counter;
import java.awt.Color;
/**
 * prints the  win screen.
 */
public class WinScreen implements Animation {
    private Counter counterScore;
    private KeyboardSensor keyboardSensor;
    private boolean stop;

    /**
     * constructor.
     * @param keyboardSensor , sensor.
     * @param counterScore , score of the game.
     */

    public WinScreen(KeyboardSensor keyboardSensor, Counter counterScore) {
        this.keyboardSensor = keyboardSensor;
        this.counterScore = counterScore;
        this.stop = false;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillCircle(380, 200, 100);
        d.setColor(Color.yellow);
        d.fillCircle(380, 200, 95);
        d.setColor(Color.black);
        d.fillOval(345, 230, 80, 40);
        d.setColor(Color.yellow);
        d.fillOval(345, 220, 80, 40);
        d.setColor(Color.white);
        d.fillCircle(345, 180, 20);
        d.fillCircle(420, 180, 20);
        d.setColor(Color.black);
        d.fillCircle(345, 180, 12);
        d.fillCircle(420, 180, 12);
        d.setColor(new Color(250, 128, 114));
        d.fillCircle(310, 215, 12);
        d.fillCircle(445, 215, 12);
        d.setColor(Color.black);
        d.drawText(160, 360, "You Win! Your Score is " + Integer.toString(counterScore.getValue() + 100), 35);
        d.drawText(220, 385, "press space to exit!", 35);
//        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
//            this.stop = true;
//        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
