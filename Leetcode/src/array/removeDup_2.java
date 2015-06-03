package array;

public class removeDup_2 {
	public int removeDuplicates(int[] A) { //速度慢。
        if(A.length==0 || A==null) return 0;
        if(A.length==1) return 1;
        int size=0;
        int count=1;
        for (int i=0;i<A.length-1;i++) {
            if(A[i]==A[i+1]) {
                count++;
                if(count>2) {
                    //count=0;
                    A[++size]=0;
                    continue;
                }
                else A[++size]=A[i+1];
            }
            else {
                A[++size]=A[i+1];
                count=1;
            }
        }
        return size+1;
    }
	public int removeDuplicates_2(int[] A) {
        if(A.length==0 || A==null) return 0;
        int size=0;
        int count=1;
        for (int i=1;i<A.length;i++) {
            if(A[i]==A[size]) {
                count++;
                if(count>2) {
                    continue;
                }
                else A[++size]=A[i];
            }
            else {
                A[++size]=A[i];
                count=1;
            }
        }
        /*效率更高！！！
         * if(count>2) {
                    continue;
                }
                //else A[++size]=A[i];
            }
            else {
                //A[++size]=A[i];
                count=1;
            }
            A[++size]=A[i];
         */
        return size+1;
    }
}
