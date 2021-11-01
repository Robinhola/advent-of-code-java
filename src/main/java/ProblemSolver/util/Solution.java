package ProblemSolver.util;

public class Solution {
  public int partOne;
  public int partTwo;

  public Solution(int partOne, int partTwo) {
    this.partOne = partOne;
    this.partTwo = partTwo;
  }

  public String toString() {
    return "{ " + partOne + ", " + partTwo + " }";
  }
}
