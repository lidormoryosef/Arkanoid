package sprites;

import listeners.HitListener;

/**
 * The HitNotifier interface indicate that objects that
 * implement it send notifications when they are being hit.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl , listener.
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl , listener.
     */
    void removeHitListener(HitListener hl);
}
