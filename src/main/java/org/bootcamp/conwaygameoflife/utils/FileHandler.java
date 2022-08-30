package org.bootcamp.conwaygameoflife.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileHandler {

  public FileHandler() {
  }

  public String readFile(File file) throws IOException {
    StringBuilder sb = new StringBuilder();
    InputStream in = new FileInputStream(file);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    String line;
    while ((line = br.readLine()) != null) {
      sb.append(line).append(System.lineSeparator());
    }

    return sb.toString();
  }
}
