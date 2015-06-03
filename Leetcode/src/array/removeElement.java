package array;

import java.util.ArrayList;
import java.util.List;

public class removeElement {
	
	public int removeElement(int[] A, int elem) {
        int j=A.length-1;
        for (int i=0;i<=j;i++) {
            if(A[i]==elem){
                for(;j>i;j--) {
                    if (A[j]!=elem) break;
                }
                A[i]=A[j];
                j--;
            }
            
        }
        return j+1;
    }
	
	/*
	 * 没必要判断A[j]是否为=elem,因为只要保证最后得到的i-j之间的数组不含有elem就可以。
	 */
	public int removeElement_Update(int[] A, int elem) {
		int j=A.length-1;
		int i=0;
		while(i<=j){
			if(A[i]==elem){
				A[i]=A[j];
				j--;
			}
			else i++;
		}
		return j+1;
	}
	
	public int removeElement_Update2(int[] A, int elem) { //指针从前往后走.
		int j=0;
        for (int i=0;i<A.length;i++) {
            if(A[i]!=elem) A[j++]=A[i];
            else continue;
        }
		return j;
    }  
  
}
