package backtracking;

import java.util.Stack;

public class SubsetSum {
    private static int[] set;
    private static int targetSum;
    private static Stack<Integer> solutionSet;
    private static boolean hasSolution;

    private static void findSubset(int sum, int index) {
        if (sum > targetSum) return;
        if (sum == targetSum) {
            hasSolution = true;
            displaySolutionSet();
            return;
        }
        for (int i = index; i < set.length; i++) {
            solutionSet.push(set[i]);
            findSubset(sum + set[i], i + 1);
            solutionSet.pop();
        }
    }

    private static void displaySolutionSet() {
        for (Integer item : solutionSet) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        set = new int[]{10, 7, 5, 18, 12, 20, 15};
        targetSum = 30;
        solutionSet = new Stack<>();
        hasSolution = false;
        findSubset(0, 0);
        if (hasSolution)
            System.out.print("No Solution");
    }
}
