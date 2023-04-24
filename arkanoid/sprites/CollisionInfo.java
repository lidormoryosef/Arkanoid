package sprites;

import geometry.Point;

/**
    sprites.CollisionInfo.
 */
public class CollisionInfo {
    private Point collision;
    private Collidable collidable;

    /**
     * this function create  a new object with collision point
     * and collidable object involved.
     *
     * @param collision  , the collision point.
     * @param collidable , collidable object involved
     */
    public CollisionInfo(Point collision, Collidable collidable) {
        this.collision = collision;
        this.collidable = collidable;
    }

    /**
     * the point at which the collision occurs.
     *
     * @return collision geometry.Point
     */
    public Point collisionPoint() {
        return this.collision;
    }

    /**
     * the collidable object involved in the collision.
     *
     * @return object sprites.Collidable.
     */
    public Collidable collisionObject() {
        return collidable;
    }
}
