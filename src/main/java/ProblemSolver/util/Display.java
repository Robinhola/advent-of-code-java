package ProblemSolver.util;

import ProblemSolver.days.Day;

public class Display {
  public static void print(Day day) {
    System.out.print("Day" + day.getName() + " " + day.solve() + "\n");
  }
}
