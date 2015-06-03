package Implement;

public class implementStr {
	public int strStr(String haystack, String needle) {
        int index = -1;
        
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.equals("")) return 0;
        if (haystack.equals("") && !needle.equals("")) return -1;
    
        for (int i = 0; i <= haystack.length() - needle.length(); i++){
           
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if(j == needle.length()-1) index = i;
            }
            if(index != -1) break;
        }
        return index; 
    }
	
	public int strStr_Update(String haystack, String needle) {
        if(needle.length()==0) return 0;

        for (int i=0;i<=haystack.length()-needle.length();i++) {
            int j=0;
            for (;j<needle.length();j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
                //if(j==needle.length()-1) return i;
            }
            if(j==needle.length()) return i;
            
        }
        return -1;
    }
	
	public int strStrSimple(String haystack, String needle) {
		for (int i=0;; i++) {
			for (int j=0; ; j++) {
				if (j == needle.length()) return i;  //j= needle.length()-1; then j++ 如果能成功， 说明needle已经匹配。
				if (i+j == haystack.length()) return -1; //既考虑了两个string的边界问题，又排除了haystack || needle =null 和 haystack为空，但是 needle不为空的情况。
				if (haystack.charAt(i+j) != needle.charAt(j)) break;
			}
		}
	}
	public static void main(String[] args){
		implementStr test=new implementStr();
		System.out.println(test.strStr_Update("aaa", "aa"));
		
	}
}
