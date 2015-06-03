package array;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] num, int target) {
		/*
		 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
		 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
		 * 方法参照3Sum的夹逼，时间复杂度是O(n^2+nlogn)=(n^2).
		 */
		
        if (num.length<3) return Integer.MAX_VALUE;
        Arrays.sort(num);
        int closest=num[0]+num[1]+num[2];
        int sum=num[0]+num[1]+num[2];
        for (int i=0;i<num.length-2;i++) {
            int l=i+1;
            int r=num.length-1;
            while(l<r) {
                sum=num[i]+num[l]+num[r];
                if (sum==target) return target;
                if (sum>target) r--;
                else l++;
                closest=Math.abs(sum-target) < Math.abs(closest-target)? sum:closest;
            }
        }
        return closest;
    }
}
