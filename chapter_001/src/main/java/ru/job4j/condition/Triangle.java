package ru.job4j.condition;

/**
 * The {@code Triangle} class provides the triangle area calculation.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    /**
     * The first top of the triangle.
     */
    private Point a;

    /**
     * The second top of the triangle.
     */
    private Point b;

    /**
     * The third top of the triangle.
     */
    private Point c;

    /**
     * Triangle class constructor.
     *
     * @param a The first top of the triangle.
     * @param b The second top of the triangle.
     * @param c The third top of the triangle.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * This method considers the triangle semi-perimeter.
     *
     * @param ab The first side of the triangle.
     * @param ac The second side of the triangle.
     * @param bc The third side of the triangle.
     * @return Triangle period.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * This method considers the area of a triangle.
     *
     * @return Triangle area.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(b);
        double ac = this.a.distanceTo(c);
        double bc = this.b.distanceTo(c);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * This method checks the possibility of building a triangle
     * using three sides.
     *
     * @param ab The first side of triangle.
     * @param ac The second side of triangle.
     * @param bc The third side of triangle.
     * @return Boolean result (true or false).
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean result = false;
        if (ab + ac > bc && ab + bc > ac && bc + ac > ab) {
            result = true;
        }
        return result;
    }
}
