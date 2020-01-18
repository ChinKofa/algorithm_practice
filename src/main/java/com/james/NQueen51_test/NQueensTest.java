package com.james.NQueen51_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: qinkefa
 * @Date: 2019/12/17 0017 11:43
 */
public class NQueensTest {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens1(5);
        for(List<String> l : lists){
            for(String s : l){
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        String[][] board = new String[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = ".";
            }
        }
        helper(result, board, 0, n);
        return result;
    }

    private static List<List<String>> solveNQueens1(int n){
        List<List<String>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        String[][] board = new String[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = ".";
            }
        }

        boolean[] colChecked = new boolean[n];
        boolean[] sumChecked = new boolean[n + n];
        boolean[] diffChecked = new boolean[n + n];

        helper1(result, board, 0, n, colChecked, sumChecked, diffChecked);
        return result;
    }

    private static void helper(List<List<String>> result, String[][] board, int row, int n){
        if(row == n){
            addResult(board, result);
            return ;
        }

        for(int col = 0; col < n; col++){
            if(isValid(board, row, col, n)){
                board[row][col] = "Q";
                helper(result, board, row+1, n);
                board[row][col] = ".";
            }
        }
    }

    private static void helper1(List<List<String>> result,
                                String[][] board,
                                int row,
                                int n,
                                boolean[] colChecked,
                                boolean[] sumChecked,
                                boolean[] diffChecked
                                ){
        if(row == n){
            addResult(board, result);
            return ;
        }

        for(int col = 0; col < n; col++){
            if(isValid1(colChecked, sumChecked, diffChecked, col, row, n)){
                board[row][col] = "Q";
                colChecked[col] = true;
                sumChecked[col + row] = true;
                diffChecked[col - row + n - 1] = true;
                helper(result, board, row+1, n);
                board[row][col] = ".";
                colChecked[col] = false;
                sumChecked[col + row] = false;
                diffChecked[col - row + n - 1] = false;
            }
        }
    }

    private static void addResult(String[][] board, List<List<String>> result){
        int length = board.length;
        List<String> l = new ArrayList<>();
        for(int i = 0; i < length; i++){
            StringBuffer sb = new StringBuffer(length);
            for(int j = 0; j < length; j++){
                sb.append(board[i][j]);
            }
            l.add(sb.toString());
        }
        result.add(l);
    }

    private static boolean isValid(String[][] board, int row, int col, int n){
        for(int i = 0; i < n; i++){
            if(board[i][col] == "Q"){
                return false;
            }
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == "Q"){
                return false;
            }
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == "Q"){
                return false;
            }
        }

        return true;
    }

    private static boolean isValid1(boolean[] colChecked,
                                    boolean[] sumChecked,
                                    boolean[] diffChecked,
                                    int col,
                                    int row,
                                    int len){
        if(colChecked[col]){
            return false;
        }

        if(sumChecked[col + row]){
            return false;
        }

        if(diffChecked[row - col + len]){
            return false;
        }

        return true;
    }
}
