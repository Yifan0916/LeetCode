package array;

public class ContainMostWater {
	public int maxArea(int[] height) {
        //if (height.length<2) return 0;
		/*
		 * Given n non-negative integers a1, a2, ..., an, 
		 * where each represents a point at coordinate (i, ai). 
		 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
		 * Find two lines, which together with x-axis forms a container, 
		 * such that the container contains the most water.
		 */
        int l=0;
        int r=height.length-1;
        int max=0;
        while (l<r) {
           max=Math.max(max,(r-l)*Math.min(height[l],height[r])); 
           if(height[l]<height[r])
               l++;
           else r--; 
        }
        return max;
    }
}
