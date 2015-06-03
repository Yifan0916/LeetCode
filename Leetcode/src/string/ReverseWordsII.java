package string;

public class ReverseWordsII {
	/*
	 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
     *Could you do it in-place without allocating extra space?
     *Note: 因为string is immutable，所以一定要用char[]
	 */
	public String reverseWords(char[] s) {  
		if(s.length==0) return "";
		reverse(s, 0, s.length);
		for(int i=0,j=0;j<=s.length;j++) {
			if(j==s.length || s[j]==' ') 
				reverse(s, i, j);
			i=j+1;
		}
		
		return s.toString();
	}
	public void reverse(char[] s, int start, int end) {
		for(int i=start;i<(end-start)/2;i++) {   //一开始是错的！！！i<end：因为应该是i从start到一半reverse，否则进行后半段循环的时候会恢复原样。
			char c=s[i];
			s[start+i]=s[end-1-i];  //一开始是错的，应该记得是在begin基础上的i，i只是相对值。
			s[end-1-i]=c;
		}
	}
	public static void main(String[] args) {
		ReverseWordsII test= new ReverseWordsII();
		System.out.print(test.reverseWords("the sky is blue".toCharArray()));
	}
}
