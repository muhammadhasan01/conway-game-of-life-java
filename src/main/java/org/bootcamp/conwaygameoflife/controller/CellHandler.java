package org.bootcamp.conwaygameoflife.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.bootcamp.conwaygameoflife.model.Cell;

public class CellHandler {

  private static final int[] DIR_X = {0, 0, 1, -1, 1, 1, -1, -1};
  private static final int[] DIR_Y = {1, -1, 0, 0, -1, 1, 1, -1};
  private static final int NUM_DIRECTION = 8;

  private HashSet<Cell> aliveCells;

  public CellHandler() {
  }

  public CellHandler(HashSet<Cell> aliveCells) {
    this.aliveCells = aliveCells;
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

  public int getNumOfSurvivingNeighboringCell(Cell c) {
    int numOfSurvivors = 0;
    List<Cell> neighboringCell = getNeighboringCell(c);
    for (Cell p : neighboringCell) {
      if (aliveCells.contains(p)) {
        numOfSurvivors++;
      }
    }
    return numOfSurvivors;
  }

  public boolean isCellSurvive(Cell c) {
    if (!aliveCells.contains(c)) {
      return false;
    }
    int cntSurviveCell = getNumOfSurvivingNeighboringCell(c);
    return cntSurviveCell == 2 || cntSurviveCell == 3;
  }

  public List<Cell> getCellsToBeDead() {
    List<Cell> cellsToBeDead = new ArrayList<>();
    for (Cell c : aliveCells) {
      if (!isCellSurvive(c)) {
        cellsToBeDead.add(c);
      }
    }
    return cellsToBeDead;
  }

  public HashMap<Cell, Integer> getCntDeadCell() {
    HashMap<Cell, Integer> cntDeadCell = new HashMap<>();
    for (Cell c : aliveCells) {
      List<Cell> neighboringCells = getNeighboringCell(c);
      for (Cell cell : neighboringCells) {
        if (aliveCells.contains(cell)) {
          continue;
        }
        int res = cntDeadCell.getOrDefault(cell, 0);
        cntDeadCell.put(cell, res + 1);
      }
    }
    return cntDeadCell;
  }

  public List<Cell> getCellsToBeResurrected() {
    List<Cell> cellsToBeResurrected = new ArrayList<>();
    HashMap<Cell, Integer> cntDeadCell = getCntDeadCell();
    for (Map.Entry<Cell, Integer> entry : cntDeadCell.entrySet()) {
      if (entry.getValue() == 3) {
        cellsToBeResurrected.add(entry.getKey());
      }
    }
    return cellsToBeResurrected;
  }
}
