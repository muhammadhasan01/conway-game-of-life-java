package org.bootcamp.conwaygameoflife.controller;

import static org.bootcamp.conwaygameoflife.view.BoardRenderer.ALIVE_CELL;
import static org.bootcamp.conwaygameoflife.view.BoardRenderer.DEAD_CELL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bootcamp.conwaygameoflife.model.Cell;
import org.bootcamp.conwaygameoflife.utils.FileHandler;

public class InputHandler {

  public InputHandler() {
  }

  public List<Cell> getStateFromFile(String filename) throws IOException {
    List<Cell> lst = new ArrayList<>();
    FileHandler fileHandler = new FileHandler();
    File file = new File(filename);

    String content = fileHandler.readFile(file);
    String[] lines = content.split("\n");

    int currentColumn = 0;
    int currentRow = 0;
    for (String line : lines) {
      for (char cc : line.toCharArray()) {
        if (cc == ALIVE_CELL) {
          lst.add(new Cell(currentColumn, currentRow));
        } else if (cc != DEAD_CELL) {
          throw new IOException(
              "Illegal character '" + cc + "' found at (" + currentColumn + ", " + currentRow
                  + ")");
        }
        currentColumn++;
      }
      currentColumn = 0;
      currentRow--;
    }

    if (lst.isEmpty()) {
      throw new IOException("File must have at least one alive cell");
    }

    return lst;
  }
}
