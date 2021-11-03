package ProblemSolver.util;

import ProblemSolver.days.Day;
import ProblemSolver.days.Day01;
import ProblemSolver.days.Day02;

import java.util.Map;
import java.util.function.Supplier;

public class Solver {

  static Map<Integer, Supplier<Day>> mapping = Map.of(1, Day01::new, 2, Day02::new);

  public static Day choose(int dayNumber) {
    return mapping.get(dayNumber).get();
  }
}
