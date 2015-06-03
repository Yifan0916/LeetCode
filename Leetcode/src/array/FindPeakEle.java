package array;

public class FindPeakEle {
	//时间复杂度是O(n).
	public int findPeakElement(int[] num) {
        if (num.length==0) return -1;
        int peak=0;
        for (int i=1;i<num.length;i++) {
            if (num[i]<num[i-1]) {
               peak=i-1; 
               break;
            }
            if (i==num.length-1 && num[i]>num[i-1]) peak=i; //单独处理末尾元素。
        }
        return peak;
    }
	
	/*
	 * 二分发查找。O(logn)
	 * 如果中间元素大于其相邻后续元素，则中间元素左侧(包含该中间元素）必包含一个局部最大值。
	 * 如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值.
	 */
	
	public int findPeakElement_Update(int[] num) {  //九章。
        int l=0;
        int r=num.length-1;
        int mid;
        while (l+1<r) {
            mid = l+(r-l)/2;
            if (num[mid]<num[mid+1]) l=mid;
            else r=mid;   //num[i] ≠ num[i+1], so num[mid]>num[mid+1]
        }
        //if (num[l])
        return num[l]<num[r]?r:l;
    }
}
