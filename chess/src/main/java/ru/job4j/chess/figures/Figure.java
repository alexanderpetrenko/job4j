package ru.job4j.chess.figures;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    default boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            rst = true;
        }
        return rst;
    }

    default boolean isHorizontal(Cell source, Cell dest) {
        boolean rst = false;
        if (dest.y == source.y && dest.x != source.x) {
            rst = true;
        }
        return rst;
    }

    default boolean isVertical(Cell source, Cell dest) {
        boolean rst = false;
        if (dest.x == source.x && dest.y != source.y) {
            rst = true;
        }
        return rst;
    }

    Figure copy(Cell dest);

}
