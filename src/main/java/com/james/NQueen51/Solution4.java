package com.james.NQueen51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: qinkefa
 * @Date: 2019/12/16 0016 11:48
 */
public class Solution4 {
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        boolean[] cols = new boolean[n];
        boolean[] sums  = new boolean[n + n];
        boolean[] diffs = new boolean[n + n];// + n to avoid negative index
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                board[i][j] = ".";
            }
        }
        List<List<String>> result = new ArrayList<List<String>> ();
        helper(board, result, 0, cols, sums, diffs);
        return result;
    }

    public void helper(String[][] board, List<List<String>> result, int row, boolean[] cols, boolean[] sums, boolean[] diffs) {
        if(row == board.length) {
            addToList(board, result);
        } else {
            for(int c = 0; c < board.length; c ++) {
                if(isValidBoard(board, row, c, cols, sums, diffs)) {
                    board[row][c] = "Q";
                    cols[c] = true;
                    sums[row + c] = true;
                    diffs[row - c + board.length] = true;
                    helper(board, result, row + 1, cols, sums, diffs);
                    cols[c] = false;
                    sums[row + c] = false;
                    diffs[row - c + board.length] = false;
                    board[row][c] = ".";
                }
            }
        }
    }

    private boolean isValidBoard(String[][] board, int row, int col, boolean[] cols, boolean[] sums, boolean[] diffs) {
        if(cols[col]) {
            return false;
        }

        if(sums[row + col]) {
            return false;
        }

        if(diffs[row - col + board.length]) {
            return false;
        }

        return true;
    }

    private void addToList(String[][] board, List<List<String>> result) {
        List<String> temp = new ArrayList<String>();
        for(int i = 0; i < board.length; i ++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        result.add(new ArrayList<String>(temp));
    }
}
