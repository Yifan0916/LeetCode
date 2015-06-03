package array;

//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
public class MaxSubArray {
	/*
	 * Sliding Window.滑动窗口解决。
	 */
	public int maxSubArray(int[] A) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<A.length;i++) {
            sum+=A[i];
            max=Math.max(max,sum); //一开始max和下一句sum和0比较顺序放错了。
                                   //应该是先把全局和局部最优比较，再把sum和0比较，因为这一句是为下一此循环做清零铺垫。
            sum=Math.max(sum,0);
        }
        return max;
    }
	
	/*
	 * Dynamic Programming.动态规划思想。全局最优和局部最优解！！
	 * 递推公式： 
	 * Local[i]=Math.max(local[i-1]+A[i],A[i]);上一步的局部最优local[i]+当前元素A[i]（因为local[i]一定包含第i个元素，所以不违反条件）;
	 * 但是如果local[i]是负的，那么加上他就不如不需要的，所以不然就是直接用A[i]；
     *
	 * Global[i]=Math.max(local[i],global[i-1]);
	 * 
	 */
	public int maxSubArray_DP(int[] A) {
		if(A.length==0||A==null) return 0;
        int local=Integer.MIN_VALUE;
        int global=A[0];
        for (int i=0;i<A.length;i++) {
            local=Math.max(local+A[i],A[i]);
            global=Math.max(global,local);
        }
        return global; 
    }
	
}
