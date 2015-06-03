package string;

public class LongestPalindromic {
/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
	/*Method 1: DP  
	 *从两边向中间判断，利用动态规划思想，但是要利用额外空间。
	 */
	public String longestPalindrome_DP(String s) {
        if(s.length()==0) return "";
        int max=0;
        String lp="";
        boolean[][] judge=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++) {
            for(int j=0;j<=i;j++) {
                if(s.charAt(j)==s.charAt(i) && (i-j<=2||judge[j+1][i-1])) { 
                    judge[j][i]=true;
                    if(i-j+1>max){
                        lp=s.substring(j,i+1);
                        max=i-j+1;
                    }
                } else judge[j][i]=false;
                    
            }
        }
        return lp;
        
    }
     /*
      * Method 3：中心展开法。
      */
	public String longestPalindrome(String s) {
        String res="";
        int max=0;
        if(s.length()==0) return res;
        for(int i=0;i<s.length();i++) {
            String s1=getLongest(s,i,i); //以中心一元素展开。
            String s2=getLongest(s,i,i+1); //以中间两个元素展开；
            if(s1.length()>max){
                max=s1.length();
                res=s1;
            }
            if(s2.length()>max){
                max=s2.length();
                res=s2;
            }
        }
        return res;
    }
    public String getLongest(String s, int l,int r) {
        while(l>=0&&r<s.length()) {
            if(s.charAt(l)!=s.charAt(r)) break;
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
	
    
    /*Method: Brute force  */
	public String longestPalindrome_Brute(String s) {
        if (s == null) {
            return null;
        }

        int len = s.length();

        int max = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (dfs(s, i, j)) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(begin, end + 1);
    }

    public static boolean dfs(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dfs(s, i + 1, j - 1);
        }

        return false;
    }
    public static void main(String[] args){
    	LongestPalindromic test=new LongestPalindromic();
    	test.longestPalindrome_DP("cabaabad");
    }
}
