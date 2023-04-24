package listeners;

import sprites.Ball;
import sprites.Block;

/**
 * Objects that want to be notified of hit events.
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the sprites.Ball that's doing the hitting.

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the sprites.Ball that's doing the hitting.
     * @param beingHit , block that hit.
     * @param hitter , the ball that hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
