package string;

public class StringToInteger {
	public int atoi(String str) {  
		//错误在于有可能输入比long还大的数。所以parseLong会有问题。
        if (str==null || str.equals("")) return 0; 
		str=str.trim();
		int sign=1;
		int i=0;
		int begin;
		if (str.charAt(0)=='-') {
			sign=-1;
			begin=1;
			i++;
		}
		else if (str.charAt(0)=='+') {begin=1; i++;}
		else {begin=0;i=0;}
        for (;i<str.length();i++) {
            if (str.charAt(i)>='0' && str.charAt(i)<='9') continue;
            else break;
        }
        if (str.substring(begin,i)=="") return 0;  //这里的== 出了问题，==可用于比较引用是否相同。 比较值应该用equal（）。
        long num=Long.parseLong(str.substring(begin,i));
        if (num*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num*sign<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) (sign*num);
    }
	
	public int atoi_Update(String str) {
        if (str==null || str.equals("")) return 0;  //str.length() == 0
		str=str.trim();
		int sign=1;
		int i=0;
	    long num=0;
		
		if (str.charAt(0)=='-'||str.charAt(0)=='+') {
			if (str.charAt(0)=='-') {
			    sign=-1;
			}
			i++;
		}
		
        for (;i<str.length();i++) {
        	//System.out.println(i+" "+str.charAt(i));
            if (str.charAt(i)<'0' || str.charAt(i)>'9') break;
            num=num*10+(str.charAt(i)-'0');
            System.out.println(num);
            if (num>Integer.MAX_VALUE ) break;
            //if (num>Integer.MAX_VALUE+1 && sign==-1) break;  这一句是错误的！因为Integer.MAX_VALUE+1<0(已经溢出)，而num一定比负数大。 
            /*另一种写法：分政府讨论
             * if (num> Integer.MAX_VALUE && sign == 1) break;
            if (num>-(long)(Integer.MIN_VALUE) && sign==-1) break;  必须先将min_value强制转换成long，否则Java规定负号不会起作用
             */
        }
        if (num*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num*sign<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) (sign*num);
    }
	
	public static void main(String[] args) {
		StringToInteger atoi = new StringToInteger();
		//System.out.println(atoi.atoi_Update("-9223372036854775809"));
		System.out.println((long)(-Integer.MIN_VALUE));
		System.out.println(Integer.MIN_VALUE);
	}
}
