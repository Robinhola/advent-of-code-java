package ProblemSolver.days;

import ProblemSolver.util.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Day03 implements Day<ArrayList<String>> {
  public static final int INITIAL_CAPACITY = 30_000;
  private static final String name = "03";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public ArrayList<ArrayList<String>> getData() {
    return InputReader.fromFile(name, s -> new ArrayList(Arrays.stream(s.split(",")).toList()));
  }

  @Override
  public int partOne(ArrayList<ArrayList<String>> data) {
    int[][] grid = new int[INITIAL_CAPACITY][INITIAL_CAPACITY];

    for (ArrayList<String> instructions : data) {
      int xPos = INITIAL_CAPACITY / 2;
      int yPos = INITIAL_CAPACITY / 2;

      for (String move : instructions) {
        String direction = move.substring(0, 1);
        int distance = Integer.parseInt(move.substring(1));

        switch (direction) {
          case "R":
            for (int i = 0; i < distance; ++i) {
              xPos = xPos + 1;
              grid[yPos][xPos] += 1;
            }
            break;
          case "L":
            for (int i = 0; i < distance; ++i) {
              xPos = xPos - 1;
              grid[yPos][xPos] += 1;
            }
            break;
          case "U":
            for (int i = 0; i < distance; ++i) {
              yPos = yPos + 1;
              grid[yPos][xPos] += 1;
            }
            break;
          case "D":
            for (int i = 0; i < distance; ++i) {
              yPos = yPos - 1;
              grid[yPos][xPos] += 1;
            }
            break;
          default:
            System.out.println("OUPS");
            System.out.println(direction);
            break;
        }
      }
    }

    for (int y = INITIAL_CAPACITY / 2; y < INITIAL_CAPACITY; ++y) {
      List<Integer> list = Arrays.stream(grid[y]).boxed().collect(Collectors.toList());

      int index = list.indexOf(2);
      if (index == -1) continue;

      return y + index - INITIAL_CAPACITY;
    }

    for (int y = INITIAL_CAPACITY / 2; y > 0; --y) {
      List<Integer> list = Arrays.stream(grid[y]).boxed().collect(Collectors.toList());

      int index = list.indexOf(2);
      if (index == -1) continue;

      return y + index + INITIAL_CAPACITY;
    }

    return 0;
  }

  @Override
  public int partTwo(ArrayList<ArrayList<String>> data) {
    return 0;
  }
}
