package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * prints the  pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k , sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.drawCircle(375, 200, 100);
        d.setColor(Color.GRAY);
        d.fillCircle(375, 200, 100);
        d.setColor(Color.black);
        d.fillCircle(375, 200, 90);
        d.setColor(Color.white);
        d.fillRectangle(345, 160, 20, 80);
        d.fillRectangle(385, 160, 20, 80);
        d.setColor(Color.black);
        d.drawText(225, 350, "press space to continue", 32);
//        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
//            this.stop =
//                    true;
//        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
