package org.bootcamp.conwaygameoflife.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import org.bootcamp.conwaygameoflife.model.Cell;
import org.junit.jupiter.api.Test;

class GameTest {

  private final Cell one = new Cell(1, 1);
  private final Cell two = new Cell(1, 2);
  private final Cell three = new Cell(1, 3);
  private final Cell four = new Cell(0, 2);
  private final Cell five = new Cell(2, 2);

  private final Game game = new Game();

  @Test
  void getNextState_givenEmptyState_shouldReturnSameEmptyState() {
    HashSet<Cell> state = new HashSet<>();
    HashSet<Cell> result = game.getNextState(state);

    assertEquals(state, result);
  }

  @Test
  void getNextState_givenOneAliveCell_shouldReturnEmptyState() {
    HashSet<Cell> state = new HashSet<>();
    state.add(one);

    HashSet<Cell> result = game.getNextState(state);
    HashSet<Cell> expected = new HashSet<>();

    assertEquals(expected, result);
  }

  @Test
  void getNextState_givenCertainState_shouldReturnCorrectState() {
    HashSet<Cell> state = new HashSet<>();
    state.add(one);
    state.add(two);
    state.add(three);

    HashSet<Cell> result = game.getNextState(state);
    HashSet<Cell> expected = new HashSet<>();
    expected.add(five);
    expected.add(two);
    expected.add(four);

    assertEquals(expected, result);
  }
}
