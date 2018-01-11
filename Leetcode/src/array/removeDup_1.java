package array;

public class removeDup_1 {
	/*
	 * Given a sorted array, remove the duplicates in place such
	 * that each element appear only once and return the new length.
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) return nums.length;
        int l = 0;
        int r = 1;
        //int size = 1;
        while (r < nums.length) {
            if (nums[r] == nums[l]) r++;
            else {
                nums[++l] = nums[r];
            }
        }
        return l+1;
        
    }
	public int removeDuplicates_Update(int[] A) {
		if (A == null || A.length == 0) return 0;
        int size=0;
        for (int i=0;i<A.length;i++) {
            if (A[i]!=A[size]) {
                A[++size]=A[i];  //!!!!!!!!!
            }
        }
        return size+1;
        
    }

}
