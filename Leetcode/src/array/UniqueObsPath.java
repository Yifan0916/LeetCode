package array;

public class UniqueObsPath {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) { //O(n^2)
        if(obstacleGrid[0][0]==1) return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] res = new int[n];
        res[0]=1;
        for (int i=0;i<m;i++) {
            if(obstacleGrid[i][0]==1) res[0]=0; //一定要加！！！因为每次j从1开始， 默认没有obstacle，但这是不对的！！
            // if(obstacleGrid[i][0]==0) res[0]=1; 是错的！因为在第一列上，某一个为obstacle， 下面的都为0.
            for (int j=1;j<n;j++) {
                if (obstacleGrid[i][j]==1) res[j]=0;
                else res[j]+=res[j-1];
            }
        }
        return res[n-1];
    }
	public static void main(String[] args) {
		UniqueObsPath test=new UniqueObsPath();
		int [][] A={{0},{1}};
		int res=test.uniquePathsWithObstacles(A);
		System.out.println(res);
	}
}
