package ProblemSolver.days;

import ProblemSolver.util.Solution;

import java.util.ArrayList;

public interface Day<T> {

  default Solution solve() {
    ArrayList<T> data = getData();
    return new Solution(partOne(data), partTwo(data));
  }

  String getName();

  ArrayList<T> getData();

  int partOne(ArrayList<T> data);

  int partTwo(ArrayList<T> data);
}
