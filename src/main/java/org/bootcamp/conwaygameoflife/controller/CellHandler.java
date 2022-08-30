package org.bootcamp.conwaygameoflife.controller;

import java.util.ArrayList;
import java.util.List;
import org.bootcamp.conwaygameoflife.model.Cell;

public class CellHandler {

  private static final int[] DIR_X = {0, 0, 1, -1, 1, 1, -1, -1};
  private static final int[] DIR_Y = {1, -1, 0, 0, -1, 1, 1, -1};
  private static final int NUM_DIRECTION = 8;

  public CellHandler() {
  }

  public List<Cell> getNeighboringCell(Cell c) {
    List<Cell> neighboringCell = new ArrayList<>();
    for (int i = 0; i < NUM_DIRECTION; i++) {
      int row = c.row() + DIR_Y[i];
      int column = c.column() + DIR_X[i];
      neighboringCell.add(new Cell(row, column));
    }
    return neighboringCell;
  }
}
