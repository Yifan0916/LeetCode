package array;

public class removeDup_1 {
	/*
	 * Given a sorted array, remove the duplicates in place such
	 * that each element appear only once and return the new length.
	 */
	public int removeDuplicates(int[] A) {
        if(A.length==0) return 0;
        if(A.length==1) return 1;
        int size=1;
        for (int i=0;i<A.length-1;i++) {
            if (A[i]!=A[i+1]) {
                A[size++]=A[i+1];
            }
            else continue;
        }
        return size;
        
    }
	public int removeDuplicates_Update(int[] A) {
        if(A.length==0) return 0;
        int size=0;
        for (int i=0;i<A.length;i++) {
            if (A[i]!=A[size]) {
                A[++size]=A[i];
            }
        }
        return size+1;
        
    }

}
