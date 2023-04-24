package geometry;
import java.util.ArrayList;

/**
 * This class creates rectangle  objects with point ,width and height.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Line upperLine;
    private Line downLine;
    private Line leftLine;
    private Line rightLine;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft , the starting point is in the upper left corner.
     * @param width     , the width of rectangle.
     * @param height    , the height of rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        Point pUpperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point pDownLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point pDownRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.upperLine = new Line(upperLeft, pUpperRight);
        this.leftLine = new Line(pDownLeft, upperLeft);
        this.downLine = new Line(pDownLeft, pDownRight);
        this.rightLine = new Line(pDownRight, pUpperRight);
    }

    /**
     * return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line , the line we want to check the collisions with rectangle
     * @return list of Collision points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> listInter = new ArrayList<>();
        Point pointInter = null;
        if (line.isIntersecting(this.leftLine)) {
            if (line.ifInLine(line.intersectionWith(leftLine))) {
                listInter.add(line.intersectionWith(leftLine));
            }
        }
        if (line.isIntersecting(this.downLine)) {
            if (line.ifInLine(line.intersectionWith(this.downLine))) {
                listInter.add(line.intersectionWith(this.downLine));
            }
        }
        if (line.isIntersecting(this.rightLine)) {
            if (line.ifInLine(line.intersectionWith(this.rightLine))) {
                listInter.add(line.intersectionWith(this.rightLine));
            }
        }
        if (line.isIntersecting(this.upperLine)) {
            if (line.ifInLine(line.intersectionWith(this.upperLine))) {
                listInter.add(line.intersectionWith(this.upperLine));
            }
        }
        for (int i = 0; i < listInter.size(); i++) {
            for (int j = i + 1; j < listInter.size(); j++) {
                if (listInter.get(i).equals(listInter.get(j))) {
                    listInter.remove(i);
                    break;
                }
            }
        }
        return listInter;


    }

    /**
     * Return the width of the rectangle.
     *
     * @return height of rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the  height of the rectangle.
     *
     * @return width of rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return upper-left point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Returns the top side of the rectangle.
     *
     * @return line
     */
    public Line getUpperLine() {
        return upperLine;
    }

    /**
     * Returns the downside of the rectangle.
     *
     * @return line
     */
    public Line getDownLine() {
        return downLine;
    }

    /**
     * Returns the left side of the rectangle.
     *
     * @return line
     */
    public Line getLeftLine() {
        return leftLine;
    }

    /**
     * Returns the right side of the rectangle.
     *
     * @return line
     */
    public Line getRightLine() {
        return rightLine;
    }

    /**
     * update the upper left and the lines that make up the rectangle.
     * @param upperLeft ,the point of rectangle.
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
        Point pUpperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point pDownLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point pDownRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.upperLine = new Line(upperLeft, pUpperRight);
        this.leftLine = new Line(pDownLeft, upperLeft);
        this.downLine = new Line(pDownLeft, pDownRight);
        this.rightLine = new Line(pDownRight, pUpperRight);

    }
}
