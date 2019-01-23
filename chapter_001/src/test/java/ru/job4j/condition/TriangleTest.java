package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    /**
     * Test for the triangle area calculation.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Creating three objects of the Point class.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Creating a triangle object.
        Triangle triangle = new Triangle(a, b, c);
        // Calculating an area.
        double result = triangle.area();
        // Set the expected result.
        double expected = 2D;
        // Compare the calculated result and the expected result.
        assertThat(result, closeTo(expected, 0.1));
    }
}
