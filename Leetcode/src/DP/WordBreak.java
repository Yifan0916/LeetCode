package DP;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        if(s.length()==0) return false;
        boolean[] res=new boolean[s.length()];
        //res[0]=true;
        for(int i=0;i<s.length();i++) {
            StringBuilder sb=new StringBuilder(s.substring(0,i+1));
            if(dict.contains(sb.toString())) {
                res[i]=true;
            }else {
                for(int j=0;j<=i;j++) {
                	//System.out.println(j);
                    sb.deleteCharAt(0);   //一开始这里是delete（j）,但是不能删除j,因为每次删除一个元素后，后面的元素index-1，所以会出现outofbounds的情况。只删除开头元素就好了。
                    if(res[j]&&dict.contains(sb.toString())) { //res[] 长度为s.length，这就表示res[j]为当前位是否为true
                    	res[i]=true;
                    	break;
                    }
                    
                }    
            }
        }
        return res[s.length()-1];
    }
	
	public boolean wordBreak_Update(String s, Set<String> dict) {  
	    if(s==null || s.length()==0)  
	        return true;  
	    boolean[] res = new boolean[s.length()+1];  
	    res[0] = true;  
	    for(int i=0;i<s.length();i++)  
	    {  
	        StringBuilder str = new StringBuilder(s.substring(0,i+1));  
	        for(int j=0;j<=i;j++)  
	        {  
	            if(res[j] && dict.contains(str.toString()))  
	            {  
	                res[i+1] = true;  
	                break;  
	            }  
	            str.deleteCharAt(0);  
	        }  
	    }  
	    return res[s.length()];  
	}  
    public static void main(String[] args) {
    	WordBreak test= new WordBreak();
    	Set<String> dict=new HashSet<String>();
    	dict.add("abc");
    	dict.add("a");
    	dict.add("b");
    	dict.add("cd");
    	test.wordBreak("abcd", dict);
    	//System.out.println(test.wordBreak("aaaaa", dict));
    	//boolean[] res = new boolean[2];  
    	//System.out.println(res[0]+" "+res[1]);
    	
    }
}
