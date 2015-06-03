package string;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while (l<r) {
            if (!isValid(s.charAt(l))) {l++; continue;}  //一定要有continue.
                                                        //想过同时看l，r是否valid，但是这样无法一直++直到找到valid的值，再进行isSame的比较。
            if (!isValid(s.charAt(r))) {r--; continue;}
            if (isSame(s.charAt(l), s.charAt(r))) {
                l++;
                r--;
            } else return false;
            
        }
        return true;
    }
    public boolean isValid(char c) {
        if ((c>='a' && c<='z') || (c>='A' && c<='Z')|| (c>='0' && c<='9')) return true;
        return false;
    }
    public boolean isSame(char a, char b) { 
        
        if (a>='A' && a<='Z')   a=(char) (a-'A'+'a'); //先都统一成小写！！ 记住要强制转换类型！！！
        if (b>='A' && b<='Z')   b=(char) (b-'A'+'a');
        return a==b;
    }
}
