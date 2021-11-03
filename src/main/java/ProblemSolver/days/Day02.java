package ProblemSolver.days;

import ProblemSolver.util.InputReader;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

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
        int result = IntCodeTuring.from(data, noun, verb);
        if (result == GOAL) {
          return 100 * noun + verb;
        }
      }
    }

    throw new RuntimeException("Could not finish!");
  }

  private static class IntCodeTuring {
    static final int STOP_CODE = 99;
    static final int ADD_CODE = 1;
    static final int MULTIPLY_CODE = 2;

    int address = 0;
    ArrayList<Integer> memory;

    private IntCodeTuring(ArrayList<Integer> initialMemory, int noun, int verb) {
      this.memory = new ArrayList<>(initialMemory);
      this.memory.set(1, noun);
      this.memory.set(2, verb);
    }

    public static int from(ArrayList<Integer> initialMemory, int noun, int verb) {
      return new IntCodeTuring(initialMemory, noun, verb).compute().get(0);
    }

    private ArrayList<Integer> compute() {
      int instruction = memory.get(address);

      while (instruction != STOP_CODE) {
        instruction = switch (instruction) {
          case ADD_CODE -> operation(Integer::sum);
          case MULTIPLY_CODE -> operation((a, b) -> a * b);
          default -> throw new IllegalStateException("Invalid instruction: " + instruction);
        };
      }

      return memory;
    }

    private int operation(BinaryOperator<Integer> operator) {
      int a = memory.get(memory.get(address + 1));
      int b = memory.get(memory.get(address + 2));
      int c = memory.get(address + 3);

      memory.set(c, operator.apply(a, b));

      address += 4;

      return memory.get(address);
    }
  }
}
