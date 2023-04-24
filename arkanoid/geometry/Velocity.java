package geometry;
/*
 * @author lidor mor yosef <lidor28799@gmail .com>
 */

/**
 * This class create ball speed of ball.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * This function initializes the parameters.
     *
     * @param dx , distance between x.
     * @param dy , distance between y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This function initializes the parameters with velocity.
     *
     * @param velocity
     */
    public Velocity(Velocity velocity) {
        this.dx = velocity.dx;
        this.dy = velocity.dy;
    }

    /**
     * This function update the dx.
     *
     * @param dx ,distance.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * This function update the dy.
     *
     * @param dy , distance.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * This function return the dx.
     *
     * @return dx, distance.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * This function return the dy.
     *
     * @return dy, distance.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * This function converts angle and speed to velocity.
     *
     * @param angle , angle between axis and the line.
     * @param speed , the speed of ball.
     * @return velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * This function take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param point , the point that we want to update.
     * @return point, the new location
     */
    public Point applyToPoint(Point point) {
        Point newPoint = new Point(this.dx + point.getX(), this.dy + point.getY());
        return newPoint;
    }
}
