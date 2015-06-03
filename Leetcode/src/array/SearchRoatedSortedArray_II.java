package array;

public class SearchRoatedSortedArray_II {
	public boolean search(int[] A, int target) {
		 int l=0;
	        int r=A.length-1;
	        while(l+1<r){
	            int mid = l + (r-l) / 2;
	            if(A[mid]==target) return true;
	            if(A[l] < A[mid]) {//rotate point is later.
	                if(A[l] <= target && target < A[mid])
	                   r=mid;
	                else l=mid;
	            }else if(A[l] > A[mid]){
	                if(A[mid] < target && target <= A[r]) //一定要有等号！！！
	                    l=mid;
	                else r=mid;
	            } else {
	                l++; //cannot let l=mid directly since {1,3,1,1,1} 3 cannot work here.
	            }
	            
	        }
	        if(A[l]==target || A[r]==target) return true;
	        return false;
    }
	
	public boolean search_9Chapter(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
