package org.bootcamp.conwaygameoflife.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CellTest {

  @Test
  void accessor_givenRowColumnValue_shouldBeValid() {
    int row = 3;
    int column = 4;
    Cell cell = new Cell(row, column);

    assertEquals(row, cell.row());
    assertEquals(column, cell.column());
  }

  @Test
  void equality_twoSameCells_shouldBeEqual() {
    Cell first = new Cell(3, 4);
    Cell second = new Cell(3, 4);

    assertEquals(first, second);
    assertEquals(first.hashCode(), second.hashCode());
  }
}
