package org.bootcamp.conwaygameoflife.controller;

import java.util.HashSet;
import java.util.List;
import org.bootcamp.conwaygameoflife.model.Cell;

public class Game {

  public Game() {
  }

  public HashSet<Cell> getNextState(HashSet<Cell> currentState) {
    HashSet<Cell> nextState = new HashSet<>(currentState);
    CellHandler cellHandler = new CellHandler(nextState);

    List<Cell> cellsToBeDead = cellHandler.getCellsToBeDead();
    List<Cell> cellsToBeResurrected = cellHandler.getCellsToBeResurrected();

    nextState.addAll(cellsToBeResurrected);
    cellsToBeDead.forEach(nextState::remove);

    return nextState;
  }
}
