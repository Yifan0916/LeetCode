package array;

public class UniquePath {
	public int uniquePaths(int m, int n) {
        //if (m==0) return 0;
        int[][] res = new int[m][n];
        res[0][0]=0;
        for (int i=1;i<m; i++) res[i][0]=1; //初始化边缘。
        for (int j=1;j<n; j++) res[0][j]=1;
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) 
                res[i][j] = res[i-1][j]+res[i][j-1];
        }
        return res[m-1][n-1];
    }
	
	//http://blog.csdn.net/linhuanmars/article/details/22126357 Code Ganker.
	//第一种只用了一位数组优化了空间复杂度。
	public int uniquePaths_Update_1(int m, int n) {
        int[] res= new int[n];
        res[0]=1;
        for (int i=0;i<m;i++) {
            for (int j=1;j<n;j++) {
                res[j]+=res[j-1];
            }
        }
        return res[n-1];
   }
	/*背后的数学模型，其实就是机器人总共走m+n-2步，其中m-1步往下走，
	 * n-1步往右走，本质上就是一个组合问题，也就是从m+n-2个不同元素中每次取出m-1个元素的组合数。
	 * 时间复杂度是O(min(m,n))，而空间复杂度是O(1).
	 * 不过这里有个弊端，就是如果代码中的dom和dedom如果不是double，而是用int，那么会很容易越界，因为这是一个阶乘，
	 * 所以大家在面试中讨论这种方法要注意和提及越界的问题
	 */
	public int uniquePaths_Update_2(int m, int n) {
        double num=1;  //分子：numerator;
        double deno=1; //分母：denominator;
        int small=m<n?m-1:n-1;
        int big=m<n?n-1:m-1;
        for (int i=1;i<=small;i++) {
            deno*=i;
            num*=small+big+1-i;
        }
        return (int)(num/deno);
   }
	
}
