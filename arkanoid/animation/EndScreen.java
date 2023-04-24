package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import sprites.Counter;
import java.awt.Color;

/**
 * prints the  end screen.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter counterScore;

    /**
     * constructor.
     * @param k , sensor.
     * @param counterScore , score of the game.
     */
    public EndScreen(KeyboardSensor k, Counter counterScore) {
        this.keyboard = k;
        this.stop = false;
        this.counterScore = counterScore;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillCircle(380, 200, 100);
        d.setColor(Color.yellow);
        d.fillCircle(380, 200, 95);
        d.setColor(Color.white);
        d.fillCircle(345, 180, 20);
        d.fillCircle(420, 180, 20);
        d.setColor(Color.black);
        d.fillCircle(345, 180, 12);
        d.fillCircle(420, 180, 12);
        d.setColor(Color.cyan);
        d.fillRectangle(345, 200, 4, 10);
        d.fillRectangle(345, 215, 4, 10);
        d.fillRectangle(345, 230, 4, 10);
        d.fillRectangle(345, 245, 4, 10);
        d.fillRectangle(345, 260, 4, 10);
        d.fillRectangle(420, 200, 4, 10);
        d.fillRectangle(420, 215, 4, 10);
        d.fillRectangle(420, 230, 4, 10);
        d.fillRectangle(420, 245, 4, 10);
        d.fillRectangle(420, 260, 4, 10);
        d.setColor(Color.black);
        d.fillOval(352, 240, 60, 30);
        d.setColor(Color.yellow);
        d.fillOval(352, 250, 60, 30);
        d.setColor(Color.black);
        d.drawText(150, 400, "Game Over. Your score is " + Integer.toString(counterScore.getValue()), 35);
        d.drawText(210, 435, "press space to exit!", 35);

//        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
//            this.stop = true;
//        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
