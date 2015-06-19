package array;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) { //O(nlogn)
        if (nums.length < 1) return false; 
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
	/*
	 * Method 2: HashSet way.
	 */
	public boolean containsDuplicate_HashSet(int[] nums) {
        if (nums.length < 1) return false; 
        HashSet<Integer> count = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if (!count.contains(nums[i])) count.add(nums[i]);
            else return true;
        }
        return false;
    }
}
