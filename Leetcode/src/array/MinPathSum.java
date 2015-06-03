package array;

public class MinPathSum {
	public int minPathSum(int[][] grid) {  
		//http://blog.csdn.net/linhuanmars/article/details/22257673.
        int m=grid.length;
        int n=grid[0].length;
        int[] min=new int[n];
        min[0]=grid[0][0];
        for(int i=1;i<n;i++)   //因为按列循环，所以初始化第一行。
            min[i]=min[i-1]+grid[0][i];
        for(int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(j==0) min[j]+=grid[i][j];
                else min[j]=Math.min(min[j],min[j-1])+grid[i][j];
            }
        }
        return min[n-1];
       
    }  
	/*
	 * 另一种方法是初始化第一行和第一列，所以第二个for里面嵌套的for不用专门考虑j==0时的情况，并且j从1开始。
	 * http://blog.csdn.net/lsdtc1225/article/details/39648987 不太好的地方应该是用了二维数组，空间复杂度高。
	 */
}
