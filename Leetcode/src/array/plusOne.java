package array;

public class plusOne {
	/*
	 * Given a non-negative number represented as an array of digits, plus one to the number.
     *The digits are stored such that the most significant digit is at the head of the list.
	 */
	public int[] plusOne(int[] digits) {
        int count=0; //or 1;
        for(int i=digits.length-1; i>-1 ; i--) {
            int sum = digits[i]+1;
            digits[i]=sum%10;
            count=sum/10;
            if(count==0) return digits;

        }
        //判断第一位是否应该进位。
        int[] newDigits= new int[digits.length+1];
        newDigits[0]=1;
       /* for (int i=0; i<digits.length;i++){
            newDigits[i+1]=digits[i];
        }
                 没必要跑for循环，因为只有当所有位数均为9时才会进位到第一位，而此时，除第一位外，其他为均为0。*/
        
        return newDigits;
    }
	
	public int[] plusOne_2(int[] digits) {
        int carrier=0;
        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i]+1>9) {
                digits[i]=0;
                carrier=1;
            }else {
                digits[i]+=1;
                carrier=0;
            }
            if(carrier==0) return digits;
        }
        //if(carrier==1) {//第一位变到第二位。
            int[] res=new int[digits.length+1];
            res[0]=1;
            return res;
        //}
        //return digits;
    }
	
	public static void main(String[] args) {
		plusOne test=new plusOne();
		int[] digits={0};
		System.out.println(test.plusOne_2(digits)[0]);
	}
}
