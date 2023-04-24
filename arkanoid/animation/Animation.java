package animation;

import biuoop.DrawSurface;

/**
 * draw animation on the screen.
 */
public interface Animation {
    /**
     * draw animation.
     * @param d , draw.
     */
    void doOneFrame(DrawSurface d);

    /**
     * return if stop the animation.
     * @return , true or false.
     */
    boolean shouldStop();
}
