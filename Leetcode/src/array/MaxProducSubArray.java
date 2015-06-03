package array;

public class MaxProducSubArray {
	public int maxProduct(int[] A) {
		/*
		 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
		 * 这道题跟Maximum Subarray模型上和思路上都比较类似,但是
		 * 乘法中有可能现在看起来小的一个负数，后面跟另一个负数相乘就会得到最大的乘积。
		 * 我们只需要在维护一个局部最大的同时，在维护一个局部最小！！
		 * 两个局部变量！！
		 */
        int n=A.length;
        int max=A[0];
        int min=A[0];
        int res=A[0];
        int tem;
        for (int i=1;i<n;i++) { //注意i一定要从1开始！！因为min,max的初始值已经设为A[0]，不然就会出现A[0]*A[0]
            tem=max;
            max = Math.max(Math.max(A[i]*max,A[i]), min*A[i]); //DP方法：一定要包含当前元素A[i]!!
            min = Math.min(Math.min(tem*A[i],A[i]), min*A[i]);
            //为什么不是Math.min(Math.max(min*A[i],A[i]), max*A[i]：是一样的。都是三者的比较!!
            res = Math.max(max, res);
        }
        return res;
    }
}
