package sprites;

import geometry.Line;
import geometry.Point;

import java.util.ArrayList;

/**
 * The sprites.GameEnvironment class will be a collection of such things.
 */
public class GameEnvironment {
    private ArrayList<Collidable> listCollidable;

    /**
     * create a new list of obstacles.
     */
    public GameEnvironment() {
        listCollidable = new ArrayList<>();
    }

    /**
     * update the list collidable.
     * @param listCollidable , array list of collidable.
     */
    public GameEnvironment(ArrayList<Collidable> listCollidable) {
        this.listCollidable = listCollidable;
    }

    /**
     * return the list collidable.
     * @return , list collidable.
     */
    public ArrayList<Collidable> getListCollidable() {
        return this.listCollidable;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c , An object that the ball can collide with.
     */
    public void addCollidable(Collidable c) {
        listCollidable.add(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory , the line that the move.
     * @return ob
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        ArrayList<Point> pointInter = new ArrayList<>();
        int closest = 0;
        double distance = trajectory.length();
        int j = 0;
        for (int i = 0; i < this.listCollidable.size(); i++) {
            pointInter.add(trajectory.
                    closestIntersectionToStartOfLine(this.listCollidable.get(i).getCollisionRectangle()));
            if (pointInter.get(i) != null) {
                j++;
            }
        }
        if (j == 0) {
            return null;
        }
        for (int i = 0; i < pointInter.size(); i++) {
            if (pointInter.get(i) == null) {
                continue;
            }
            if (pointInter.get(i).distance(trajectory.start()) < distance) {
                distance = pointInter.get(i).distance(trajectory.start());
                closest = i;
            }
        }
        if (pointInter.get(closest) != null) {
            return new CollisionInfo(pointInter.get(closest), listCollidable.get(closest));
        }
        return null;
    }

}
