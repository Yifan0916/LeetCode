package array;

public class SearchForRange {
  /*
   * Given a sorted array of integers, find the starting and ending position of a given target value.
   * If the target is not found in the array, return [-1, -1].
   * 涔濈珷锛� http://www.cnblogs.com/yuzhangcmu/p/4048001.html
   */
	/*
	 * 鎴戜竴寮�濮嬬殑鎬濊矾鏄痠f (A[mid]==target)锛屽厛鎵惧乏鍗婇儴鍒嗭紝鍐嶆壘鍙宠竟鐣屻��
	 * 涔濈珷鐨勫仛娉曞叾瀹炲拰鎴戠殑鏄竴鏍风殑锛屽彧涓嶈繃涓嶇敤浠庝竴寮�濮嬪垎绫昏�冭檻A[mid]==target锛屼笉绠℃槸鍚︾浉绛夛紝鐩存帴鍒嗘垚鍚戝乏鍙冲す閫煎嵆鍙��
	 */
	public int[] searchRange(int[] A, int target) {
		int [] res = {-1, -1};
		if (A == null || A.length == 0) return res;
        
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
