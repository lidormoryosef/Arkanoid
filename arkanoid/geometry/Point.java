package geometry;

/*
 * @author lidor mor yosef <lidor28799@gmail .com>
 */

/**
 * This class creates point objects with x value and y value.
 */
public class Point {
    static final double ERROR = Math.pow(10, -6);
    private double x;
    private double y;

    /**
     * This function create a point object and initializes it with x,y values.
     *
     * @param x , a value on axis x.
     * @param y , a value on axis y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This function calculate the distance between two points.
     *
     * @param other , The point we want to calculate the distance between them.
     * @return the distance.
     */
    public double distance(Point other) {
        double disX, disY;
        disX = (this.x - other.getX()) * (this.x - other.getX());
        disY = (this.y - other.getY()) * (this.y - other.getY());
        return Math.sqrt(disX + disY);
    }

    /**
     * This function check if two points is equals.
     *
     * @param other , the point we want to check.
     * @return true or false.
     */
    public boolean equals(Point other) {
        if (Math.abs(this.x - other.getX()) < ERROR && Math.abs(this.y - other.getY()) < ERROR) {
            return true;
        }
        return false;
    }

    /**
     * This function return the x value of point.
     *
     * @return x, the value of x.
     */
    public double getX() {
        return x;
    }

    /**
     * This function return the x value of point.
     *
     * @return y - the value of y.
     */
    public double getY() {
        return y;
    }

    /**
     * This function updates the x value to the desired value.
     *
     * @param x , the new value.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * This function updates the x value to the desired value.
     *
     * @param y , the new value.
     */
    public void setY(double y) {
        this.y = y;
    }
}
