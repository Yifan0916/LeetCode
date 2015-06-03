package string;

public class DecodeWays {
/*
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *For example,Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *The number of ways decoding "12" is 2.
 */
	public int numDecodings(String s) {
        //int[] res=new int[s.length()];
        
        if(s.length()==0||s.charAt(0)=='0') return 0;
        int n1=1;
        int n2=1;
        int n3=0;
        
        for(int i=1;i<s.length();i++) { System.out.println(s.charAt(i));
            //当前的数不管是不是0，肯定可以直decode,所以不算是新方法
            if(s.charAt(i)=='0' ){
                if(s.charAt(i-1)=='0'||s.charAt(i-1)>'2') {return 0;}
                //上一句一开始写成s.charAt(i-1)>2形式，但这是在比较ASCII码！！！，应该是比较char！！！
                else n3=n1;
            }else {
            //与前面数可以一起decode,所以多了一种方法
            //if(Integer.parseInt(s.substring(i-1,i+1))<27&& Integer.parseInt(s.substring(i-1,i+1))>0) 
            //这样写错误！！例如Integer.parseInt("01")=1；但其实这个不能decode.
            if(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2' && s.charAt(i)>'0' && s.charAt(i)<'7')) //注意'2'是char不是int！！！
                {System.out.println(s.charAt(i-1));n3=n1+n2;}
            else {System.out.println(s.charAt(i-1));n3=n2;}
            }
            n1=n2;
            n2=n3;
        }
        return n2;
    }
	/*
	 * Code ganker做法。
	 */
	public int numDecodings_DP(String s) {  
	    if(s==null || s.length()==0 || s.charAt(0)=='0')  
	    {  
	        return 0;  
	    }  
	    int num1=1;  
	    int num2=1;  
	    int num3=1;  
	    for(int i=1;i<s.length();i++)  
	    {  
	        if(s.charAt(i)=='0')  
	        {  
	            if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2')  
	                num3 = num1;  
	            else  
	                return 0;  
	        }  
	        else  
	        {  
	            if(s.charAt(i-1)=='0' || s.charAt(i-1)>='3')  
	                num3 = num2;  
	            else  
	            {  
	                if(s.charAt(i-1)=='2' && s.charAt(i)>='7' && s.charAt(i)<='9')  
	                    num3 = num2;  
	                else  
	                    num3 = num1+num2;  
	            }  
	        }  
	        num1 = num2;  
	        num2 = num3;  
	    }  
	    return num2;  
	}  

	public static void main(String[] arg){
		DecodeWays test=new DecodeWays();
		System.out.println(test.numDecodings("26"));
		//System.out.println(Integer.parseInt("01"));
	}
	
}
