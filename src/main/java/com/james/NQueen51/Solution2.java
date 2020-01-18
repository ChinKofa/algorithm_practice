package com.james.NQueen51;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

	private final static String DOT = ".";
	private final static String Q = "Q";
	private static int num = 0;

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                board[i][j] = ".";
            }
        }
        List<List<String>> result = new ArrayList<>();
        backTrack(board, result, n, 0, 0, n);
        return result;
    }

	/**
	 * 画地图树，可以理解递归细节
	 * @param board
	 * @param result
	 * @param number
	 * @param row
	 * @param col
	 * @param total
	 */
    public void backTrack(String[][] board, List<List<String>> result, int number, int row, int col, int total) {
    	if(col >= total) {
    		col = 0;
    		row ++;
    	}
		System.out.println(col+":"+row);
    	num++;
    	if(row >= total) {
    		return;
    	}

    	if(board[row][col] == DOT) {
    		board[row][col] = "Q";
    		if(isValidBoard(board, row, col)) {
    			if(number == 1) {
    				addToList(board, result);
    			} else {
      				backTrack(board, result, number - 1, row, col + 1, total);
    			}
    		}
    		board[row][col] = ".";
    		backTrack(board, result, number, row, col + 1, total);
    	}
    }
  
    
    private boolean isValidBoard(String[][] board, int row, int col) {
    	// column
    	for(int i = 0; i < board.length; i++) {
    		if(i != col && board[row][i] == "Q") {
    			return false;
    		}
    	}

    	// row
    	for(int i = 0; i < board.length; i++) {
    		if(i != row && board[i][col] == "Q") {
    			return false;
    		}
    	}

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
    	
    	//right up
    	i = row - 1;
    	j = col + 1;
    	while(i >= 0 && j < board.length) {
    		if(board[i][j] == "Q") {
    			return false;
    		}
    		i --;
    		j ++;
    	}

    	// left down
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
    	List<String> temp = new ArrayList<> ();
    	for(int i = 0; i < board.length; i ++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j = 0; j < board[0].length; j++) {
    			sb.append(board[i][j]);
    		}
    		temp.add(sb.toString());
    	}
    	result.add(new ArrayList<>(temp));
    }

	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		List<List<String>> lists = s2.solveNQueens(2);
		for(List<String> ll : lists){
			for(String s : ll){
				System.out.println(s);
			}
			System.out.println();
		}

		System.out.println(num);
	}
}