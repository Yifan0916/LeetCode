package string;

public class AddBinary {
	public static String addBinary(String a, String b) {
        StringBuilder s=new StringBuilder();
        int carry=0;
        int sum=0;
        for (int i=a.length()-1,j=b.length()-1; i>=0 && j>=0; i--,j--) { 
        	sum=carry+Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(j));
        	//System.out.println(sum);
            if (sum>=2) {
                carry=1;
                s.append(sum-2);
            } else {
                s.append(sum);
                carry=0;
            }
        }
        if (a.length()<b.length()) {
            for (int i=b.length()-a.length()-1;i>=0;i--) {
            	sum=carry+Character.getNumericValue(b.charAt(i));
                if (sum>=2) {
                    carry=1;
                    s.append(sum-2);
                }else {
                    s.append(sum);
                    carry=0;
                }
            }
        } else if (a.length()>b.length()) {
            for (int i=a.length()-b.length()-1;i>=0;i--) {
            	sum=carry+Character.getNumericValue(a.charAt(i));
                if (sum>=2) {
                    carry=1;
                    s.append(sum-2);
                }else {
                    s.append(sum);
                    carry=0;
                }
            }
        }
        if (carry==1) s.append(1); //一开始忘记对最后一个进位的处理。
        s.reverse();
        return s.toString();
    }
	//更新的做法简化了代码。不用考虑如果将char-->int, 只要和‘0’比较差即可，非常聪明！！！
	public String addBinary_Update(String a, String b) {
        StringBuilder s=new StringBuilder();
        int carry=0;
        int sum=0;
        int i,j;  //提前定义i，j，后面就不需要比较a和b的长度大小，只需要看i,j是否不小于0即可！
        for (i=a.length()-1,j=b.length()-1; i>=0 && j>=0; i--,j--) {
            sum=carry+(a.charAt(i)-'0')+(b.charAt(j)-'0');
            s.append(sum%2);  //这一部分也是一个简化。用除法和模余运算替换if
            carry=sum/2;
        }
        if (j>=0) {
            for (j=b.length()-a.length()-1;j>=0;j--) {
                sum=carry+(b.charAt(j)-'0');
                s.append(sum%2); 
                carry=sum/2;
            }
        } else if (i>=0) {
            for (i=a.length()-b.length()-1;i>=0;i--) {
                sum=carry+(a.charAt(i)-'0');
                s.append(sum%2);
                carry=sum/2;
            }
        }
        if (carry==1) s.append(1);
        s.reverse();
        return s.toString();
    }
	public static void main(String[] args){
		System.out.println(addBinary("100","110010"));
	}
}
