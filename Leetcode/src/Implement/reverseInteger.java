package Implement;

public class reverseInteger {
	public int reverse(int x) {
        if (x == 0) return 0;
        //int div= Math.abs(x);
        int div = x;
        int remainder = 0;
        int reverse = 0;
        
        while (Math.abs(div) >=1) {
            
            remainder = div % 10;
            reverse = reverse * 10 + remainder;
            div = div / 10;
        }
        
       // if (x < 0) reverse = -reverse;
        return reverse;
        
    }
	
	 public static void main (String[] args) {
		 reverseInteger r=new reverseInteger();
		 System.out.println(r.reverse(-1234));
		 //System.out.println(-123%10);
	 }
	 
	// 注意越界后返回0.先用long来计算，然后，把越界的处理掉。
	 public int reverseUpdate(int x) {
	        long ret = 0;
	        
	        while (x != 0) {//Pay attention to the condition!
	            ret = ret * 10 + x % 10;
	            x /= 10;
	        }
	        
	        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
	            return 0;
	        }
	        
	        return (int)ret;
	    }
}
