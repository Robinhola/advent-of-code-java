package ProblemSolver.util;

import com.google.common.collect.Iterators;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

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

  public static <T> ArrayList<T> fromOneLine(String name, Function<String, ArrayList<T>> visitor) {
    return Iterators.getOnlyElement(fromFile(name, visitor).iterator());
  }

  public static ArrayList<Integer> fromLineToNumbers(String line) {
    return new ArrayList<>(
        Arrays.stream(line.split(",")).map(Integer::valueOf).collect(Collectors.toList()));
  }

  public static ArrayList<Integer> fromFile(String name) {
    return fromFile(name, Integer::valueOf);
  }
}
