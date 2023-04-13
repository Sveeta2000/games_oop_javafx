package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sveet
 * @date 11.04.2023
 */
class BishopBlackTest {

    @Test
    void whenPositionIsCorrect() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Cell bishopCell = bishopBlack.position();
        assertThat(bishopCell).isEqualTo(Cell.A1);
    }

    @Test
    void whenWayIsCorrect() {
        Figure bishop1 = new BishopBlack(Cell.C1);
        Cell[] cellWay = bishop1.way(Cell.G5);
        Cell[] expectedWay = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cellWay).isEqualTo(expectedWay);
    }

    @Test
    void whenWayIsIncorrect() {
        Figure bishop1 = new BishopBlack(Cell.C1);
        Exception exception = Assertions.assertThrows(ImpossibleMoveException.class, () -> {
            bishop1.way(Cell.G8);
        });
        String expectedMessage = String.format("Could not move by diagonal from %s to %s", bishop1.position(), Cell.G8);
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void whenIsDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Assertions.assertTrue(bishopBlack.isDiagonal(Cell.A1, Cell.D4));
    }

    @Test
    void whenIsDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Assertions.assertFalse(bishopBlack.isDiagonal(Cell.A1, Cell.D3));
    }

    @Test
    void whenCopyIsCorrect() {
        Figure bishop1 = new BishopBlack(Cell.A1);
        Figure bishop2 = bishop1.copy(Cell.C3);
        assertThat(bishop2.position()).isEqualTo(Cell.C3);
    }
}