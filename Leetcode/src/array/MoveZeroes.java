package array;

import java.util.Arrays;

public class MoveZeroes {
	/*
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements. 
	 */
	public void moveZeroes(int[] nums) {
        if (nums.length < 2)
            return;
        int l = 0;
        int r = 1;
        while (r < nums.length) {
        	//System.out.println(l+" "+r+": "+Arrays.toString(nums));
            if (nums[l] == 0) {
                if (nums[r] != 0) {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                    l++;
                    r++;
                    System.out.println(l+" "+r+": "+Arrays.toString(nums));
                }else{
                    r++;
                    System.out.println(l+" "+r+": "+Arrays.toString(nums));
                }
            }
            else {
                l++;
                r++;
                System.out.println(l+" "+r+": "+Arrays.toString(nums));
            }
            
        }
        return;
    }
	public static void main(String[] args){
		int[] nums = {0, 1, 0, 3, 12};
		MoveZeroes test = new MoveZeroes();
		test.moveZeroes(nums);
	}
}
