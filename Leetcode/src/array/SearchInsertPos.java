package array;

public class SearchInsertPos {
	public int searchInsert(int[] A, int target) {
        //Binary Search.
        int index=0;
        
        int left=0;
        int right=A.length-1;
        int mid;
        while(left<right) {
            mid=left+(right-left)/2;
            if(A[mid]==target) return mid;
            else if(A[mid]<target) left=mid+1;
            else right=mid;
        }
        //if(A[left]==target) return left;
        if(A[right]<target) index=right+1;
        else index=right;
        return index; 
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
