package ProblemSolver.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Function;

public class InputReader {
  public static <T> ArrayList<T> fromFile(String name, Function<String, T> visitor) {
    Path file = Path.of("data/days/" + name + ".in");

    ArrayList<T> data = new ArrayList<>();
    try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.US_ASCII)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        data.add(visitor.apply(line));
      }
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }

    return data;
  }

  public static ArrayList<Integer> fromFile(String name) {
    return fromFile(name, Integer::valueOf);
  }
}
