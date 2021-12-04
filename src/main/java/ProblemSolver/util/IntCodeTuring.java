package ProblemSolver.util;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class IntCodeTuring {
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
