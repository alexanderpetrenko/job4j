package ru.job4j.pseudo;

/**
 * A context class of the Strategy interface
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class Paint {
    /**
     * This method executes an operation of Strategy (Shape) interface.
     *
     * @param shape Name of geometric figure.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Program enter point.
     *
     * @param args Arguments from the command line
     *             as an array of String objects.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        System.out.println("----- Square: -----");
        paint.draw(new Square());
        System.out.println("---- Triangle: ----");
        paint.draw(new Triangle());
    }
}
