package array;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		/*
		 * searches for a value in an m x n matrix:
		 * Integers in each row are sorted from left to right.
         * The first integer of each row is greater than the last integer of the previous row.
         * 先确定行，再确定列。
         * 时间复杂度是O(logm+logn)，空间上只需两个辅助变量，因而是O(1)
		 */
		
        int t=0;
        int b=matrix.length-1;
        int mid;
        int row;
        while (t+1<b) {
            mid = t+(b-t)/2;
            if(matrix[mid][0]==target) return true;
            if(matrix[mid][0]<target) t=mid;
            else b=mid;
        }
        //if (matrix[b][0]==target || matrix[t][0]==target) return true;
        if (matrix[b][0]<=target) row=b;
        else row=t;
        int l=0;
        int r=matrix[0].length-1;
        while(l+1<r) {
            mid=l+(r-l)/2;
            if(matrix[row][mid]==target) return true;
            if(matrix[row][mid]<target) l=mid;
            else r=mid;
        }
        if(matrix[row][r]==target || matrix[row][l]==target) return true;
        else return false;
    }
}
