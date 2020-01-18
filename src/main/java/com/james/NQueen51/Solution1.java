package com.james.NQueen51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: qinkefa
 * @Date: 2019/12/4 0004 12:45
 */
public class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        if (n <= 0) {
            return solutions;
        }

        char[][] board = getBoard(n);
        solveNQueens(n, board, 0, solutions);
        return solutions;
    }

    private void solveNQueens(int n, char[][] board, int currCol, List<List<String>> solutions) {

        if (currCol == n) {
            addSolution(board, solutions);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(n, board, row, currCol)) {
                board[row][currCol] = 'Q';
                solveNQueens(n, board, currCol + 1, solutions);
                board[row][currCol] = '.';
            }
        }
        return;
    }

    private boolean isSafe(int n, char[][] board, int row, int currCol) {
        int i, j;

        // check this row on left
        for (i = 0; i < currCol; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // check upper diagonal i.e. i++ and j--
        for (i = row, j = currCol; i < n && j>= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check lower diagonal i.e. i-- and j--
        for (i = row, j = currCol; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void addSolution(char[][] board, List<List<String>> solutions) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        solutions.add(solution);
    }

    private char[][] getBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    public static void main(String[] args) {

    }
}
