package string;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if (s.length()==0) return 0;
        String[] array = s.split(" ");
        return array[array.length-1].length();
    }
	
	/*
	 * 九章
	 */
	public int lengthOfLastWord_9Cha(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0) {
                if (chars[i] == ' ') { //从后向前，知道不为空格开始，算长度。
                    continue;
                } else {
                    length++;
                }
            } else {                   //开始计算长度后，指导下一个空格结束。
                if (chars[i] == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }

        return length;
    }
	//Code_Ganker做法。唯一的细节就是要去掉尾部的空格，然后读到下一个空格，记录下长度。时间复杂度是O(n)，n是字符串的长度，空间复杂度是O(1)
	public int lengthOfLastWord_Update(String s) {  
	    if(s==null || s.length()==0)  
	        return 0;  
	    int idx = s.length()-1;  
	    while(idx>=0 && s.charAt(idx)==' ') idx--;  
	    int idx2 = idx;  
	    while(idx2>=0 && s.charAt(idx2)!=' ') idx2--;  
	    return idx-idx2;  
	}  

}
