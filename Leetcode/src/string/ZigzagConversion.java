package string;

public class ZigzagConversion {
	/*
	 * https://leetcode.com/problems/zigzag-conversion/
	 */
	public String convert(String s, int nRows) {
        if (nRows==1) return s;
        int size=2*(nRows-1);
        char[] conv= new char[s.length()];
        int count=0;
        for (int i=0;i<nRows;i++) {
            int interval=size-2*i;  
            for (int j=i;j<s.length();j+=size) {
                conv[count]=s.charAt(j); //每一行第一个元素。
                count++;
                if (i!=0 && i!=nRows-1 && j+interval<s.length()) {   //中间短的列。
                    conv[count]=s.charAt(j+interval);
                    count++;    //Bug:之前少了这一行，不对！
                }
            }
        }
        return new String(conv);// 另一种做法是用StringBuilder,最后用conv.toString();代替！   
    }
	
	 public static void main(String[] args) {
		 ZigzagConversion con= new ZigzagConversion();
		 System.out.println(con.convert("PAYPALISHIRING",5));
	 }
}
