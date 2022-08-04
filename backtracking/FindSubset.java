package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class FindSubset {

    private static int[] set;
    private static int size;

    public static void printSubset(int limit, int current, int len, int[] subset) {
        if (len == limit) {
            System.out.print("{ ");
            Arrays.stream(subset).forEach(c -> System.out.print(c +" "));
            System.out.println("}");
            return;
        }
        if (current >= size)
            return;
        subset[len] = set[current];
        printSubset(limit, current + 1, len + 1, subset);
        printSubset(limit, current + 1, len, subset);
    }

    public static void printAllSubset() {
        for (int i = 0; i <= size; i++) {
            int[] subset = new int[i];
            printSubset(i, 0, 0, subset);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        size = scn.nextInt();
        set = new int[size];
        for (int i = 0; i < size; i++)
            set[i] = scn.nextInt();
        printAllSubset();
    }
}



