package array;

public class SearchForRange {
  /*
   * Given a sorted array of integers, find the starting and ending position of a given target value.
   * If the target is not found in the array, return [-1, -1].
   * 九章： http://www.cnblogs.com/yuzhangcmu/p/4048001.html
   */
	/*
	 * 我一开始的思路是if (A[mid]==target)，先找左半部分，再找右边界。
	 * 九章的做法其实和我的是一样的，只不过不用从一开始分类考虑A[mid]==target，不管是否相等，直接分成向左右夹逼即可。
	 */
	public int[] searchRange(int[] A, int target) {
        int [] res = {-1, -1};
        //Left part;
        int l = 0; 
        int r = A.length-1;
        while(l+1 < r) {
            int mid = l + (r - l)/2;
            if(A[mid] < target) l = mid;
            else r = mid;
            
        } 
        if(A[l] == target) res[0]=l;
        else if(A[r] == target) res[0]=r;
        else return res; //not exist.
        System.out.println(res[0]);
        //Right part.
        int a = 0; 
        int b = A.length-1;
        System.out.println(a+" "+b);
        while(a+1 < b) {
            int mid = a + (b - a)/2;
            if(A[mid] > target) b = mid;
            else a = mid;
            
        }  
        System.out.println(a+" "+b);
        if(A[b] == target) res[1]=b;
        else if(A[a] == target) res[1]=a;
        else return res;
        System.out.println(res[1]);
        return res;
    }
	
	public static void main(String[] args) {
		SearchForRange test = new SearchForRange();
		int[] A = {1,2,3};
		test.searchRange(A, 3);
	}
}
