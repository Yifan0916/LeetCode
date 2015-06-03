package array;

import java.util.Arrays;

public class majorityElement {
	//Given an array of size n, find the majority element. 
	public int majorityElement(int[] num) { //O(nlogn).
	        int size = num.length;
	        Arrays.sort(num);  //logn.
	        int majority=num[0];
	        int amount=1;
	        
	        for (int i=0;i<size-1;i++) {
	            if(num[i+1]!=num[i]) {
	                amount=1;
	                continue;
	            }
	            amount++;
	            if(amount>size/2) {
	                majority=num[i];
	                break;
	            }
	        }
			return majority;
	    
    }
	
	public int update_1 (int[] num) {  //1 2 3 3 3.
	        int size=num.length;
	        int majority=num[0];
	        int count=0;
	        for (int i=0;i<size;i++) {
	            if(num[i]==majority) count++;
	            else if(count==0) {
	                majority=num[i];
	                count++;
	            }
	            else count--;
	        }
	        return majority;
	    
	}
	
	public int update_2 (int[] num) {  //1 2 3 3 3
		/*Every number in the vector votes for itself, 
		 * the majority number gets the most votes. Different number offsets the votes.
		 */
		Arrays.sort(num);
		return num[num.length/2];
	}
}
