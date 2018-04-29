package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public abstract class Figure {

    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract Figure.copy(Cell dest);

    Cell[] way(Cell source, Cell dest) throw ImposibleMoveException {

    }

}
