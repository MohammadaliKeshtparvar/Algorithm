package backtracking;

public class GraphColoring {

    private static int[][] graph;
    private static int[] color;
    private static int colorNumber;
    private static int node;

    public static boolean isPromising() {
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if (graph[i][j] == 1 && color[i] == color[j]) return false;
            }
        }
        return true;
    }

    public static void printSolution() {
        System.out.print("Solution exists : ");
        for (int i = 0; i < node; i++)
            System.out.print("  " + color[i]);
        System.out.println();
    }

    public static boolean graphColoring(int i) {
        if (i == node) {
            if (isPromising()) {
                printSolution();
                return true;
            }
            return false;
        }
        for (int j = 1; j <= colorNumber; j++) {
            color[i] = j;
            if (graphColoring(i + 1))
                return true;
            color[i] = 0;
        }
        return false;
    }


    public static void main(String[] args) {
        graph = new int[][]{{0, 1, 1, 1}
                , {1, 0, 1, 0}
                , {1, 1, 0, 1}
                , {1, 0, 1, 0}};
        colorNumber = 3;
        color = new int[4];
        node = 4;
        graphColoring(0);
    }

}
