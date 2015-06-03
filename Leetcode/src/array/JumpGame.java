package array;

public class JumpGame {
	public boolean canJump(int[] A) {
	       //if (A.length==0) return true;
	       int reach=0;
	       for (int i=0;i<=reach&&i<A.length;i++) {
	           reach = Math.max(A[i]+i,reach);
	           if (reach>=A.length) return true;
	           //if (i==reach) return false;
	       }
	       if(reach<A.length-1)  //Or just: return reach>=A.length-1; 代替这三行。
	       return false;
	       return true; 
	    }
}
