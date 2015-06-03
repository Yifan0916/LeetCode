package array;

public class MinInRoatedSortedArray {
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * Find the minimum element.
	 */
	public int findMin(int[] num) {
        int l=0;
        int r=num.length-1;
        int mid;
        while(l+1<r) {
            mid = l+(r-l)/2;
            if (num[mid]<num[r]) r=mid;
            else if(num[mid]>num[r]) l=mid;
        }
        return num[l]<num[r]?num[l]:num[r];
    }
	
	//This time array has duplicate.
	public int findMin_II(int[] num) {
        int l=0;
        int r=num.length-1;
        int mid;
        while(l+1<r) {
            mid = l+(r-l)/2;
            if (num[mid]<num[r]) r=mid;
            else if(num[mid]>num[r]) l=mid;
            else r--;  
        }
        return num[l]<num[r]?num[l]:num[r];
    }
}
