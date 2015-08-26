package firstPrac;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.
 *
 */

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'b','b'},{'a','b'},{'b','a'}};
		String word = "a";
		boolean res = exist(board, word);
		System.out.println(res);
	}
	
	public static boolean exist(char[][] board, String word) {
        boolean [][]state = new boolean[board.length][board[0].length];
        // find the first one
        for (int i = 0; i<board.length; i++)
        	for (int j = 0; j<board[0].length; j++)
        	{
        		if (existhelper(board, i, j, state, word, 0))
        			return true;
        	}
		return false;
    }

	public static boolean existhelper(char[][] board, int starti, int startj, boolean[][] state, String word, int k) {
        if (board[starti][startj] != word.charAt(k))    return false;
		if (k == word.length()-1)   return true;
        
		state[starti][startj] = true;
		int size1 = board.length, size2 = board[0].length;
        // down
        if (starti+1<size1 && !state[starti+1][startj] && existhelper(board, starti+1, startj, state, word, k+1) )  return true;
        // right
        if (startj+1<size2 && !state[starti][startj+1] && existhelper(board, starti, startj+1, state, word, k+1))  return true;
        // up
        if (starti>0 && !state[starti-1][startj] && existhelper(board, starti-1, startj, state, word, k+1))  return true;
        // left
        if (startj>0 &&!state[starti][startj-1] && existhelper(board, starti, startj-1, state, word, k+1))  return true;
        // RESET !!!
        state[starti][startj] = false;
		return false;
    }
}
