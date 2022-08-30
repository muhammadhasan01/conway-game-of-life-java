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

  public String renderDynamicCell() {
    int minColumn = Integer.MAX_VALUE;
    int maxColumn = -Integer.MAX_VALUE;
    int minRow = Integer.MAX_VALUE;
    int maxRow = -Integer.MAX_VALUE;
    for (Cell p : aliveCells) {
      minColumn = Math.min(minColumn, p.column());
      maxColumn = Math.max(maxColumn, p.column());
      minRow = Math.min(minRow, p.row());
      maxRow = Math.max(maxRow, p.row());
    }
    return renderCell(minColumn - 1, maxColumn + 1, minRow - 1, maxRow + 1);
  }
}
