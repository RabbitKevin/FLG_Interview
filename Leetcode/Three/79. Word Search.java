public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(help(board, isVisited, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean help(char[][] board, boolean[][] isVisited, int i, int j, String word, int index) {
        if(index == word.length()) return true;
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || isVisited[i][j]) return false;
        if(board[i][j] != word.charAt(index)) return false;
        isVisited[i][j] = true;
        if(help(board, isVisited, i-1, j, word, index+1)) return true;
        if(help(board, isVisited, i+1, j, word, index+1)) return true;
        if(help(board, isVisited, i, j-1, word, index+1)) return true;
        if(help(board, isVisited, i, j+1, word, index+1)) return true;
        isVisited[i][j] = false;
        return false;
    }
}
