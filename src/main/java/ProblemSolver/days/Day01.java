package ProblemSolver.days;

import ProblemSolver.util.InputReader;

import java.util.ArrayList;

/** Day 1: The Tyranny of the Rocket Equation */
public final class Day01 implements Day<Integer> {
  private static final String name = "01";

  private static Integer fuelFor(Integer mass) {
    int fuel = Math.floorDiv(mass, 3) - 2;
    return Math.max(fuel, 0);
  }

  private static Integer totalFuelFor(Integer mass) {
    if (mass <= 0) {
      return 0;
    }
    int fuel = fuelFor(mass);
    return fuel + totalFuelFor(fuel);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public ArrayList<Integer> getData() {
    return InputReader.fromFile(name);
  }

  /**
   * The Elves quickly load you into a spacecraft and prepare to launch.
   *
   * <p>At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't
   * determined the amount of fuel required yet.
   *
   * <p>Fuel required to launch a given module is based on its mass. Specifically, to find the fuel
   * required for a module, take its mass, divide by three, round down, and subtract 2.
   *
   * <p>Your puzzle answer was 3154112.
   *
   * @return the sum of the fuel requirements for all the modules on your spacecraft
   * @param data
   */
  @Override
  public int partOne(ArrayList<Integer> data) {
    return data.stream().map(Day01::fuelFor).reduce(Integer::sum).orElseThrow();
  }

  /**
   * During the second Go / No Go poll, the Elf in charge of the Rocket Equation Double-Checker
   * stops the launch sequence. Apparently, you forgot to include additional fuel for the fuel you
   * just added.
   *
   * <p>What is the sum of the fuel requirements for all the modules on your spacecraft when also
   * taking into account the mass of the added fuel? (Calculate the fuel requirements for each
   * module separately, then add them all up at the end.)
   *
   * <p>Your puzzle answer was 4728317.
   *
   * @param data
   */
  @Override
  public int partTwo(ArrayList<Integer> data) {
    return data.stream().map(Day01::totalFuelFor).reduce(Integer::sum).orElseThrow();
  }
}
