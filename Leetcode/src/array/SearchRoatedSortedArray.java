package array;

public class SearchRoatedSortedArray {
	public int search(int[] A, int target) {
        int l=0; 
        int r=A.length-1;
        int mid;
        while(l+1<r) {//must be +1!!!! otherwise, if has 2 elemnet, l=mid always, maybe in while loop always. e.g.[1,3] 2.
            mid=l+(r-l)/2;
            if (A[mid]==target) return mid;
            if (A[mid]<A[r]) { //rotate点在mid之前
                if(A[mid]<target && target<=A[r])  //注意=！！！！！ 但是A[mid]<target不能加=，因为会在上一个if进行判断。
                    l=mid;
                else r=mid;
            } else { 
            	
                if(A[l]<=target && target <A[mid]) //同理。
                    r=mid;                
                else l=mid;
            }
        }
        if(A[l]==target) return l;
        if(A[r]==target) return r;
        else return -1;
    }
}
