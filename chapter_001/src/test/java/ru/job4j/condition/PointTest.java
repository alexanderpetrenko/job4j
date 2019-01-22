package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    /**
     * Test for calculation distance method.
     */
    @Test
    public void distanceBetweenPointsTest() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 6);

        // The distance between points (1,1) and (1,6) should be 5.
        double result = a.distanceTo(b);
        assertThat(result, closeTo(5, 0.1));
    }
}
