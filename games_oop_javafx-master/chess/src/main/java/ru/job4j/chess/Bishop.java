package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class Bishop extends Figure {

    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
