package ProblemSolver;

import ProblemSolver.util.Display;
import ProblemSolver.util.Solver;

import java.util.stream.IntStream;

public class ProblemSolver {
  public static void main(String[] args) {
    IntStream.rangeClosed(1, 3).mapToObj(Solver::choose).forEach(Display::print);
  }
}
