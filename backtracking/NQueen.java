package backtracking;

public class NQueen {

    private static int size;
    private static int[][] board;

    public static boolean isPromising(int row, int col) {
        for (int i = 0; i < size; i++)
            if (board[i][col] == 1)
                return false;
        int i = row + 1;
        int j = col + 1;
        while (i < size && j < size)
            if (board[i++][j++] == 1)
                return false;
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0)
            if (board[i--][j--] == 1)
                return false;
        i = row + 1;
        j = col - 1;
        while (i < size && j >= 0)
            if (board[i++][j--] == 1)
                return false;
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < size)
            if (board[i--][j++] == 1)
                return false;
        return true;
    }

    public static boolean nQueen(int n, int row) {
        if (n == 0)
            return true;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == 0 && isPromising(row, i)) {
                board[row][i] = 1;
                if (nQueen(n - 1, row + 1))
                    return true;
                board[row][i] = 0;  // backtrack
            }
        }
        return false;
    }

    private static void printMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        size = 4;
        board = new int[size][size];
        nQueen(size, 0);
        printMap();
    }
}
