package org.bootcamp.conwaygameoflife.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.bootcamp.conwaygameoflife.model.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

  private static final String RESOURCE = "src/test/resources/";
  private static final String VALID_INPUT = RESOURCE + "test_input_valid.txt";
  private static final String INVALID_INPUT = RESOURCE + "test_input_invalid.txt";
  private static final String EMPTY_INPUT = RESOURCE + "test_input_empty.txt";

  @Test
  void getStateFromFile_whenGivenValidInputFile_shouldReturnValidList() throws IOException {
    InputHandler inputHandler = new InputHandler();
    List<Cell> expectedList = List.of(new Cell(0, 0), new Cell(1, 0),
        new Cell(2, 0));
    List<Cell> actualList = inputHandler.getStateFromFile(VALID_INPUT);

    assertEquals(expectedList, actualList);
  }

  @Test
  void getStateFromFile_whenGivenInvalidInputFile_shouldThrowIOException() {
    InputHandler inputHandler = new InputHandler();
    Exception exception = Assertions.assertThrows(IOException.class,
        () -> inputHandler.getStateFromFile(INVALID_INPUT));
    String expectedMessage = "Illegal character 'X' found at (1, 0)";
    String actualMessage = exception.getMessage();

    assertEquals(expectedMessage, actualMessage);
  }

  @Test
  void getStateFromFile_whenGivenEmptyInputFile_shouldThrowIOException() {
    InputHandler inputHandler = new InputHandler();
    Exception exception = Assertions.assertThrows(IOException.class,
        () -> inputHandler.getStateFromFile(EMPTY_INPUT));
    String expectedMessage = "File must have at least one alive cell";
    String actualMessage = exception.getMessage();

    assertEquals(expectedMessage, actualMessage);
  }
}
