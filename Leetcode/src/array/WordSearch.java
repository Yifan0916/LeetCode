package array;

public class WordSearch {
    /*
     * http://www.cnblogs.com/yuzhangcmu/p/4040418.html
     * 
     */
	public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (dfs(board,word,i,j,0)) {
                return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs (char[][] board, String word, int i, int j, int index) {
        if (index>=word.length()) return true; //word has been found 
        if (i>=board.length || i<0 || j>=board[0].length || j<0) return false; //limit the i and j
        if (board[i][j]!=word.charAt(index)) return false;
        char tem=board[i][j];
        board[i][j] = '#'; //Mark to avoid this cell is used again.
        
        if (dfs(board,word,i+1,j,index+1) || dfs(board,word,i,j+1,index+1) 
            || dfs(board,word,i-1,j,index+1) || dfs(board,word,i,j-1,index+1))
            return true;
        board[i][j] = tem;
        return false;
            
    }
}
