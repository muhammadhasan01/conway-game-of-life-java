package org.bootcamp.conwaygameoflife.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import org.bootcamp.conwaygameoflife.model.Cell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellHandlerTest {

  private final Cell one = new Cell(1, 1);
  private final Cell two = new Cell(1, 2);
  private final Cell three = new Cell(1, 3);
  private final Cell four = new Cell(2, 2);
  private HashSet<Cell> aliveCells;

  @BeforeEach
  void setUp() {
    aliveCells = new HashSet<>();
  }

  @AfterEach
  void tearDown() {
    aliveCells.clear();
  }

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

  @Test
  void getNumOfSurvivingNeighboringCell_onCertainCell_shouldBeCorrectValue() {
    aliveCells.add(one);
    aliveCells.add(two);
    aliveCells.add(three);

    CellHandler cellHandler = new CellHandler(aliveCells);

    assertEquals(cellHandler.getNumOfSurvivingNeighboringCell(one), 1);
    assertEquals(cellHandler.getNumOfSurvivingNeighboringCell(two), 2);
    assertEquals(cellHandler.getNumOfSurvivingNeighboringCell(three), 1);
  }

  @Test
  void isCellSurvive_notSurvivingCondition_shouldNotSurvive() {
    aliveCells.add(one);

    CellHandler cellHandler = new CellHandler(aliveCells);

    assertFalse(cellHandler.isCellSurvive(one));
    assertFalse(cellHandler.isCellSurvive(two));
    assertFalse(cellHandler.isCellSurvive(three));
  }

  @Test
  void isCellSurvive_twoSurvivingNeighboringCells_shouldSurvive() {
    aliveCells.add(one);
    aliveCells.add(two);
    aliveCells.add(three);

    CellHandler cellHandler = new CellHandler(aliveCells);

    assertTrue(cellHandler.isCellSurvive(two));
  }

  @Test
  void isCellSurvive_threeSurvivingNeighboringCells_shouldSurvive() {
    aliveCells.add(one);
    aliveCells.add(two);
    aliveCells.add(three);
    aliveCells.add(four);

    CellHandler cellHandler = new CellHandler(aliveCells);

    assertTrue(cellHandler.isCellSurvive(two));
  }

  @Test
  void getCellsToBeDead_onThreeSpecifiedCells_shouldReturnDeadCells() {
    aliveCells.add(one);
    aliveCells.add(two);
    aliveCells.add(three);

    CellHandler cellHandler = new CellHandler(aliveCells);
    List<Cell> cellsToBeDead = cellHandler.getCellsToBeDead();

    assertTrue(cellsToBeDead.contains(one));
    assertTrue(cellsToBeDead.contains(three));
    assertFalse(cellsToBeDead.contains(two));
  }
}
