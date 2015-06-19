package array;

import java.util.HashSet;

public class ContainsDuplicateII { //O(0)
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        //不需要HashMap！！ 因为维护slide window, 把超出大小的元素删除即可，
        int str = 0;
        for (int i=0; i<nums.length; i++) {
            if (i - str > k) { //sliding window
                set.remove(nums[str]);
                str++;
            }
            //System.out.println(set);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
	public static void main(String[] args){
		ContainsDuplicateII test = new ContainsDuplicateII();
		int[] nums = {1,2,3,4,5,2};
		System.out.println(test.containsNearbyDuplicate(nums, 3));
	}
}
