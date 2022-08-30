package org.bootcamp.conwaygameoflife.view;

import java.util.HashSet;
import org.bootcamp.conwaygameoflife.model.Cell;

public class BoardRenderer {

  private static final char ALIVE_CELL = '#';
  private static final char DEAD_CELL = ' ';

  private final HashSet<Cell> aliveCells;

  public BoardRenderer(HashSet<Cell> aliveCells) {
    this.aliveCells = aliveCells;
  }

  public String renderCell(int sx, int ex, int sy, int ey) {
    StringBuilder sb = new StringBuilder();
    for (int row = ey; row >= sy; row--) {
      for (int column = sx; column <= ex; column++) {
        Cell c = new Cell(row, column);
        sb.append(aliveCells.contains(c) ? ALIVE_CELL : DEAD_CELL);
      }
      sb.append('\n');
    }
    return sb.toString();
  }
}
