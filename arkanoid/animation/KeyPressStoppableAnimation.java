package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is in charge of wrapping any animations that are stopped by pressing a specific key.
 */
public class KeyPressStoppableAnimation implements Animation {
    private boolean isAlreadyPressed;
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;

    /**
     * constructor.
     *
     * @param sensor    , KeyboardSensor.
     * @param key       , string
     * @param animation , the screen.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.isAlreadyPressed = true;
        this.key = key;
        this.animation = animation;
        this.sensor = sensor;
        this.stop = false;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }

        } else {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
