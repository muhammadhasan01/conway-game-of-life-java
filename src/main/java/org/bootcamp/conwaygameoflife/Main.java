package org.bootcamp.conwaygameoflife;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.bootcamp.conwaygameoflife.controller.Game;
import org.bootcamp.conwaygameoflife.controller.InputHandler;
import org.bootcamp.conwaygameoflife.model.Cell;
import org.bootcamp.conwaygameoflife.view.BoardRenderer;

public class Main {

  private static final int MAX_ITERATE_NUM = 1_000_000;
  private static final int TIME_SLEEP_IN_MILLISECONDS = 100;

  public static void main(String[] args) {
    Game game = new Game();
    HashSet<Cell> state = new HashSet<>();
    initialBuild(state);

    int iterateNum = 0;
    while (iterateNum < MAX_ITERATE_NUM) {
      System.out.println("Board on iteration-" + iterateNum + ":");
      BoardRenderer boardRenderer = new BoardRenderer(state);
      System.out.println(boardRenderer.renderDynamicCell());

      state = game.getNextState(state);

      try {
        TimeUnit.MILLISECONDS.sleep(TIME_SLEEP_IN_MILLISECONDS);
      } catch (InterruptedException e) {
        System.err.println(e.getMessage());
      }

      iterateNum++;
    }
  }

  public static void initialBuild(HashSet<Cell> state) {
    Scanner in = new Scanner(System.in);
    boolean isInputValid = false;

    while (!isInputValid) {
      System.out.print("Input the filename path: ");
      String filename = in.nextLine();

      try {
        InputHandler inputHandler = new InputHandler();
        List<Cell> cells = inputHandler.getStateFromFile(filename);
        state.addAll(cells);
        isInputValid = true;
      } catch (IOException e) {
        System.out.println("There was an error while inputting the filename...");
        System.out.println(e.getMessage());
      }
    }

    in.close();
  }
}
