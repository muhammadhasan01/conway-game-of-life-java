package org.bootcamp.conwaygameoflife.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileHandlerTest {

  private static final String RESOURCE = "src/test/resources/";
  private static final String VALID_INPUT = RESOURCE + "test_input_valid.txt";
  private static final String INVALID_INPUT = RESOURCE + "test_input.txt";

  @Test
  void readFile_fromValidInput_shouldReturnAsExpected() throws IOException {
    String expected = "###\n";
    String result = new FileHandler().readFile(new File(VALID_INPUT));

    assertEquals(expected, result);
  }

  @Test
  void readFile_fromInvalidInput_shouldThrowException() {
    Exception exception = Assertions.assertThrows(IOException.class,
        () -> new FileHandler().readFile(new File(INVALID_INPUT)));

    String expectedMessage = INVALID_INPUT + " (No such file or directory)";
    String actualMessage = exception.getMessage();

    assertEquals(expectedMessage, actualMessage);
  }
}
