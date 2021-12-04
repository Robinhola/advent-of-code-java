package ProblemSolver.days;

import ProblemSolver.util.InputReader;
import ProblemSolver.util.IntCodeTuring;

import java.util.ArrayList;

/** Day 2: 1202 Program Alarm */
public final class Day02 implements Day<Integer> {
  private static final String name = "02";
  private static final int GOAL = 19690720;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public ArrayList<Integer> getData() {
    return InputReader.fromOneLine(name, InputReader::fromLineToNumbers);
  }

  @Override
  /** https://adventofcode.com/2019/day/2#part1 */
  public int partOne(ArrayList<Integer> data) {
    return IntCodeTuring.from(data, 12, 2);
  }

  @Override
  /** https://adventofcode.com/2019/day/2#part2 */
  public int partTwo(ArrayList<Integer> data) {
    for (int noun = 0; noun <= 100; noun++) {
      for (int verb = 0; verb <= 100; verb++) {
        if (IntCodeTuring.from(data, noun, verb) == GOAL) {
          return 100 * noun + verb;
        }
      }
    }

    throw new RuntimeException("Could not finish!");
  }
}
