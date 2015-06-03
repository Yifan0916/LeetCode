package string;

public class LongestComPrefix {
	// 1. Method 1, start from the first one, compare prefix with next string, until end;
    // 2. Method 2, start from the first char, compare it with all string, and then the second char
	public String longestCommonPrefix_2(String[] strs) {
		//Method 2.Good!
        if (strs.length==0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<strs[0].length();i++) {
            for (int j=0;j<strs.length;j++) {
                if (i>=strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i)) 
                	return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
	
	public String longestCommonPrefix_1(String[] strs) {
		//Method 1.
        if (strs.length==0) return "";
        String prefix=strs[0];
        for (int i=0;i<strs.length;i++) {
            
            int j=0;
            while (j<strs[i].length()&& j<prefix.length()&& strs[i].charAt(j)==prefix.charAt(j)) {
                j++;
            }
            
            prefix=prefix.substring(0, j);
        }
        return prefix;
    }
}
