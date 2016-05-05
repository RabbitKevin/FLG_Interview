public class TicTacToe {
    int condition;
    int size;
    int[] rows;
    int[] cols;
    int[] diagonal;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        condition = 0;
        size = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = new int[2];
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(condition != 0) return condition;
        helpLine(rows, row, player);
        helpLine(cols, col, player);
        if(row == col) helpLine(diagonal, 0, player);
        if(row+col == size-1) helpLine(diagonal, 1, player);
        return condition;
    }

    private void helpLine(int[] nums, int index, int player) {
        if(nums[index] < 0 || condition != 0) return;
        if(nums[index] == 0) {
            if(player == 1) nums[index]+=1;
            else nums[index]+=size+2;
        }
        else if(nums[index] < size) {
            if(player == 1) nums[index]++;
            else nums[index] = -1;
        }
        else {
            if(player == 2) nums[index]+=2;
            else nums[index] = -1;
        }
        if(nums[index] == size && player == 1) condition = 1;
        else if(nums[index] == 3*size && player == 2) condition = 2;
    }
}

/*
    Neat solution, set alias much better
*/

public class TicTacToe {
    private int diagonal;
    private int antiDiagonal;
    private int[] rows;
    private int[] cols;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col)
            diagonal += toAdd;

        if (col == (cols.length - row - 1))
            antiDiagonal += toAdd;

        int size = rows.length;
        if (rows[row] == size || rows[row] == -size)
            return rows[row] < 0 ? 2 : 1;

        if (cols[col] == size || cols[col] == -size)
            return cols[col] < 0 ? 2 : 1;

        if (diagonal == size || diagonal == -size)
            return diagonal < 0 ? 2 : 1;

        if (antiDiagonal == size || antiDiagonal == -size)
            return antiDiagonal < 0 ? 2 : 1;

        return 0;
    }
}
