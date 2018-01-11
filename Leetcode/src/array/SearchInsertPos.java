package array;

public class SearchInsertPos {
	public int searchInsert(int[] nums, int target) {
        //Binary Search.
		if (nums.length == 0 || nums[0] >= target) return 0;
        
        int s = 0;
        int e = nums.length - 1;
        if (nums[e] < target) return e + 1;
        int mid;
        while (s + 1 < e) {
            mid = s + (e -s) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) s = mid;
            else e = mid;
        }
        if (nums[s] == target) return s;
        return e;
    }
	
	public int searchInsert_9Chapter(int[] A, int target) {
        int start = 0, end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}
