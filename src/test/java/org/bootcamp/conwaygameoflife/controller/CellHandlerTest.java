package org.bootcamp.conwaygameoflife.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.bootcamp.conwaygameoflife.model.Cell;
import org.junit.jupiter.api.Test;

class CellHandlerTest {

  @Test
  void getNeighboringCell_onCertainCell_shouldBeValidNeighbors() {
    List<Cell> expectedList = List.of(
        new Cell(1, 0),
        new Cell(-1, 0),
        new Cell(0, 1),
        new Cell(0, -1),
        new Cell(-1, 1),
        new Cell(1, 1),
        new Cell(1, -1),
        new Cell(-1, -1)
    );

    CellHandler cellHandler = new CellHandler();
    List<Cell> actualList = cellHandler.getNeighboringCell(new Cell(0, 0));

    assertEquals(expectedList, actualList);
  }
}
