package org.bootcamp.conwaygameoflife.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import org.bootcamp.conwaygameoflife.model.Cell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardRendererTest {

  private final Cell one = new Cell(0, 0);
  private final Cell two = new Cell(0, 1);
  private final Cell three = new Cell(0, 2);

  private HashSet<Cell> aliveCells;

  @BeforeEach
  void setUp() {
    aliveCells = new HashSet<>();
    aliveCells.add(one);
    aliveCells.add(two);
    aliveCells.add(three);
  }

  @AfterEach
  void tearDown() {
    aliveCells.clear();
  }

  @Test
  void renderCell_onThreeSpecifiedCells_shouldReturnCorrectRender() {
    String expected = "### \n";
    BoardRenderer boardRenderer = new BoardRenderer(aliveCells);
    String result = boardRenderer.renderCell(0, 3, 0, 0);

    assertEquals(expected, result);
  }

  @Test
  void renderDynamicCell_onThreeSpecifiedCells_shouldReturnCorrectRender() {
    BoardRenderer boardRenderer = new BoardRenderer(aliveCells);

    String expected = boardRenderer.renderCell(-1, 3, -1, 1);
    String result = boardRenderer.renderDynamicCell();

    assertEquals(expected, result);
  }
}
