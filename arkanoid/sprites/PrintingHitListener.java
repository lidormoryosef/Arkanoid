package sprites;

import listeners.HitListener;

/**
 * print message.
 */
public class PrintingHitListener  implements HitListener {
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A sprites.Block was hit.");
    }
}
