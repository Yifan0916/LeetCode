package string;

public class ReverseWords {
	/*
	 * Given s = "the sky is blue",return "blue is sky the".
	 * reverse the string word by word.
	 */
	
	public String reverseWords(String s) {  
		/* 思路是一空格分开，从后向前遍历，不为空则添加到结果中并且在其后添加空格。但是最后返回时要把末尾的空格*/
        if(s.length()==0) return "";
        String[] list=s.split(" +");
        StringBuilder sb= new StringBuilder();
        for(int i=list.length-1;i>=0;--i) {
            if(!list[i].equals("")) {  //string比较一定要用eaquls()啊啊啊啊啊！！！
            	//System.out.println(list[i]+"/");
            	sb.append(list[i]+" ");
            }
        }
        if(sb.length()==0) {System.out.println("Empty");return sb.toString();}
        return sb.substring(0,sb.length()-1).toString(); //Delete the last empty space.
    }  
	
	public String reverseWords_2(String s) {
        s=s.trim();
        if(s.length()==0) return "";
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            StringBuilder cur=new StringBuilder();
            for(;i>=0;i--) {
            if(s.charAt(i)!=' ') cur.append(s.charAt(i));  //从末尾开始循环，找出每一个单独的单词存进一个stringbuilder,但这时是倒序的，所以
            else break;
            }
            sb.append(cur.reverse().toString()+" ");  //所以这里要reverse然后加一个空格，
            while(i>=0) {  //这里继续循环，因为两个单词中间可能有多个空格，所以全部skip，知道下一个单词。
                if(s.charAt(i)==' ') i--;
                else break;
            }
        }
        return sb.length()==0?sb.toString():sb.substring(0,sb.length()-1).toString();
        //return res.deleteCharAt(res.length()-1).toString();  //Method2:去掉最后一位的空格然后返回  
    }  
	
	/* 一种递归方法。  */
	public String reverseWords_recurs(String s) {  
	    s = s.trim();  
	    return helper(s,0).toString();  
	}  
	private StringBuilder helper(String s, int index)  
	{  
	    if(index>=s.length())  
	        return new StringBuilder();   
	    StringBuilder cur = new StringBuilder();  
	    int lastIndex = index;  
	    while(index < s.length() && s.charAt(index)!=' ')  
	    {  
	        cur.append(s.charAt(index++));  
	    }  
	    while(index < s.length() && s.charAt(index)==' ')  
	        index++;  
	    if(lastIndex == 0)  
	        return helper(s,index).append(cur);  
	    return helper(s,index).append(cur).append(' ');  
	}  

}
