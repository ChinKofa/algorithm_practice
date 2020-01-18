package com.james.NQueen51;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                board[i][j] = ".";
            }
        }
        List<List<String>> result = new ArrayList<> ();
        helper(board, result, 0);
        return result;
    }

    public void helper(String[][] board, List<List<String>> result, int row) {
        if(row == board.length) {
            addToList(board, result);
        } else {
            for(int c = 0; c < board.length; c ++) {
                if(isValidBoard(board, row, c)) {
                    board[row][c] = "Q";
                    helper(board, result, row + 1);
                    board[row][c] = ".";
                }
            }
        }
    }

    private boolean isValidBoard(String[][] board, int row, int col) {
        for(int i = 0; i < board.length; i++) {
            if(i != col && board[row][i] == "Q") {
                //System.out.println(col + "," + i + ", " + board[row][i]);
                return false;
            }
        }
        //System.out.println("row...");
        for(int i = 0; i < board[0].length; i++) {
            if(i != row && board[i][col] == "Q") {
                return false;
            }
        }
        //System.out.println("col...");
        //left up
        int i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == "Q") {
                return false;
            }
            i --;
            j --;
        }

        //right down
        i = row + 1;
        j = col + 1;
        while(i < board.length && j < board.length) {
            if(board[i][j] == "Q") {
                return false;
            }
            i ++;
            j ++;
        }

        //left down
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < board.length) {
            if(board[i][j] == "Q") {
                return false;
            }
            i --;
            j ++;
        }

        i = row + 1;
        j = col - 1;
        while(i < board.length && j >= 0) {
            if(board[i][j] == "Q") {
                return false;
            }
            i ++;
            j --;
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
        result.add(new ArrayList<>(temp));
    }
}