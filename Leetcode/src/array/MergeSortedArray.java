package array;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        //if(m==0) {都不必要。可用for循环代替。
        //    for(int i=0; i<n;i++) A[i]=B[i];
        //}
        //if(n==0) return; 
        int a=m-1;
        int b=n-1;
        for (int i=m+n-1;i>=0&&b>=0;i-- ) {
            if(a>=0&&A[a]>=B[b]){
                A[i]=A[a];
                a--;
            }
            else {
                A[i]=B[b];
                b--;
            }
        }
    }
	
	//Nine Chapter!!
	public void merge_9Chapter(int A[], int m, int B[], int n) {
		
		int size=m+n;
        while(m>0 && n>0) {
            if(A[m-1]>=B[n-1]) //一开始我在这里用的是A[--m]>B[--n]，就是每次比较都会-1， 但是下一个while会出问题。
            	               //所以应该是每次赋值的时候-1！！
                A[--size]=A[--m];
            else A[--size]=B[--n];
        }
        while(n>0)
            A[--size]=B[--n];
   }
	/*
	 * while(m>0 && n>0) {
        if(A[m-1]>B[n-1]){
            A[m+n-1]=A[m-1];
            m--;
        }else{
            A[m+n-1]=B[n-1];
            n--;
        }
    }
    while(n>0){
        A[n-1]=B[n-1];
        n--;
	 */
	
    
}
