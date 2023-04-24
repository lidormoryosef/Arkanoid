package geometry;

/*
 * @author lidor mor yosef <lidor28799@gmail .com>
 */

/**
 * This class creates line objects with two points.
 */
public class Line {
    static final double TWO = 2;
    private final Point start;
    private final Point end;
    static final double EPSILON = Math.pow(10, -6);

    /**
     * This function create a line object and initializes it with two points.
     *
     * @param start , the start of line.
     * @param end   , the end of line.
     */
    public Line(Point start, Point end) {
        //check that the smaller point is start.
        if (start.getX() > end.getX()) {
            this.start = end;
            this.end = start;
        } else {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * This function create a line object and initializes it with two points.
     *
     * @param x1 , the x value of first point.
     * @param y1 , the y value of first point.
     * @param x2 , the x value of second point.
     * @param y2 , the y value of second point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        //check that the smaller point is start.
        if (x1 == x2 && y1 > y2) {
            this.start = new Point(x2, y2);
            this.end = new Point(x1, y1);
        } else if (x1 < x2) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            this.start = new Point(x2, y2);
            this.end = new Point(x1, y1);
        }
    }

    /**
     * This function return the length of the line.
     *
     * @return the length between start and end.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * This function returns the middle point of the line.
     *
     * @return middle point.
     */
    public Point middle() {
        double xMiddle, yMiddle;
        xMiddle = (this.start.getX() + this.end.getX()) / TWO;
        yMiddle = (this.start.getY() + this.end.getY()) / TWO;
        return new Point(xMiddle, yMiddle);
    }

    /**
     * This function returns the start point of the line.
     *
     * @return , the start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * This function returns the end point of the line.
     *
     * @return , the end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * This function calculate the line slope.
     *
     * @return , line slope.
     */
    private double slope() {
        double disX, disY;
        disX = this.start.getX() - this.end.getX();
        disY = this.start.getY() - this.end.getY();
        return disY / disX;
    }

    /**
     * This function calculate the free variable of equations of straight
     * lines.
     *
     * @return , the free variable.
     */
    private double freeVariable() {
        return -slope() * this.start.getX() + this.start.getY();
    }

    /**
     * This function calculate the cutting point between two lines.
     *
     * @param other , the second line.
     * @return point of cutting point.
     */
    private Point interPoint(Line other) {
        double disFree, disSlope, yOfInter, xOfInter;
        disSlope = slope() - other.slope();
        disFree = other.freeVariable() - freeVariable();
        xOfInter = disFree / disSlope;
        yOfInter = (this.slope() * xOfInter) + this.freeVariable();
        return new Point(xOfInter, yOfInter);
    }

    /**
     * returns true if the lines intersect, false otherwise.
     *
     * @param other , the second line.
     * @return true or false.
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * This function returns the intersection point if the lines intersect,
     * and null otherwise.
     *
     * @param other , the second line.
     * @return the cutting point.
     */
    public Point intersectionWith(Line other) {
        if (this.infInter(other) != null && this.ifInLine(this.infInter(other))
                && other.ifInLine(this.infInter(other))) {
            return this.infInter(other);
        }
        return null;
    }

    /**
     * This function check if the point on this line.
     *
     * @param point , the point we want to check.
     * @return true or false
     */
    public boolean ifInLine(Point point) {

        if (this.start.getX() == this.end.getX() && point.getX() == this.start.getX()) {
            return point.getY() >= Math.min(this.start.getY(), this.end.getY())
                    && point.getY() <= Math.max(this.start.getY(), this.end.getY());
        }
        return point.getX() >= Math.min(this.start.getX(), this.end.getX())
                && point.getX() <= Math.max(this.start.getX(), this.end.getX());
    }

    /**
     * Checks if the two lines have the same equation.
     *
     * @param other , the second line.
     * @return true or false.
     */
    private Point infInter(Line other) {
        if (this.start.getX() == this.end.getX() && other.start.getX() == other.end.getX()) {
            if (this.start.getX() == other.start.getX()) {
                if (this.start.getY() == other.start.getY() || this.start.getY() == other.end.getY()) {
                    return new Point(this.start.getX(), this.start.getY());
                }
                if (this.end.getY() == other.start.getY() || this.end.getY() == other.end.getY()) {
                    return new Point(this.start.getX(), this.end.getY());
                }
                if (this.start.getX() == this.end.getX() && this.start.getY() == this.end.getY()) {
                    return new Point(this.start.getX(), this.start.getY());
                }
                if (other.start.getX() == other.end.getX() && other.start.getY() == other.end.getY()) {
                    return new Point(other.start.getX(), other.start.getY());
                }
            }
            return null;
        }
        if (this.start.getX() == this.end.getX() && other.start.getX() != other.end.getX()) {
            return new Point(this.start.getX(), other.slope() * this.start.getX() + other.freeVariable());
        }
        if (this.start.getX() != this.end.getX() && other.start.getX() == other.end.getX()) {
            return new Point(other.start.getX(), this.slope() * other.start.getX() + this.freeVariable());
        }
        return this.interPoint(other);
    }

    /**
     * this function return true is the lines are equal, false otherwise.
     *
     * @param other , the second line.
     * @return true or false.
     **/
    public boolean equals(Line other) {

        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect - rectangle.
     * @return point -
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (this.slope() < 0) {
            if (this.isIntersecting(rect.getLeftLine())) {
                return intersectionWith(rect.getLeftLine());
            }
            if (this.isIntersecting(rect.getDownLine())) {
                return intersectionWith(rect.getDownLine());
            }
            if (this.isIntersecting(rect.getUpperLine())) {
                return intersectionWith(rect.getUpperLine());
            }
            if (this.isIntersecting(rect.getRightLine())) {
                return intersectionWith(rect.getRightLine());
            }
        }
        if (this.slope() > 0) {
            if (this.isIntersecting(rect.getUpperLine())) {
                return intersectionWith(rect.getUpperLine());
            }
            if (this.isIntersecting(rect.getLeftLine())) {
                return intersectionWith(rect.getLeftLine());
            }
            if (this.isIntersecting(rect.getRightLine())) {
                return intersectionWith(rect.getRightLine());
            }
            if (this.isIntersecting(rect.getDownLine())) {
                return intersectionWith(rect.getDownLine());
            }

        }
        return null;
    }

    /**
     * This function check if the point on this line.
     *
     * @param point , the point we want to check.
     * @return true or false
     */
    public boolean pointOnLine(Point point) {
        return Math.abs(this.start.distance(end) - point.distance(this.start) - point.distance(this.end)) < EPSILON;
    }


}

