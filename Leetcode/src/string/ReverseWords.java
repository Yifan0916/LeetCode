package string;

public class ReverseWords {
	/*
	 * Given s = "the sky is blue",return "blue is sky the".
	 * reverse the string word by word.
	 */
	
	public String reverseWords(String s) {  
		/* 鎬濊矾鏄竴绌烘牸鍒嗗紑锛屼粠鍚庡悜鍓嶉亶鍘嗭紝涓嶄负绌哄垯娣诲姞鍒扮粨鏋滀腑骞朵笖鍦ㄥ叾鍚庢坊鍔犵┖鏍笺�備絾鏄渶鍚庤繑鍥炴椂瑕佹妸鏈熬鐨勭┖鏍�*/
        if(s.length()==0) return "";
        String[] list=s.split(" +");
        StringBuilder sb= new StringBuilder();
        for(int i=list.length-1;i>=0;--i) {
            if(!list[i].equals("")) {  //string姣旇緝涓�瀹氳鐢╡aquls()鍟婂晩鍟婂晩鍟婏紒锛侊紒
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
            if(s.charAt(i)!=' ') cur.append(s.charAt(i));  //浠庢湯灏惧紑濮嬪惊鐜紝鎵惧嚭姣忎竴涓崟鐙殑鍗曡瘝瀛樿繘涓�涓猻tringbuilder,浣嗚繖鏃舵槸鍊掑簭鐨勶紝鎵�浠�
            else break;
            }
            sb.append(cur.reverse().toString()+" ");  //鎵�浠ヨ繖閲岃reverse鐒跺悗鍔犱竴涓┖鏍硷紝
            while(i>=0) {  //杩欓噷缁х画寰幆锛屽洜涓轰袱涓崟璇嶄腑闂村彲鑳芥湁澶氫釜绌烘牸锛屾墍浠ュ叏閮╯kip锛岀煡閬撲笅涓�涓崟璇嶃��
                if(s.charAt(i)==' ') i--;
                else break;
            }
        }
        return sb.length()==0?sb.toString():sb.substring(0,sb.length()-1).toString();
        //return res.deleteCharAt(res.length()-1).toString();  //Method2:鍘绘帀鏈�鍚庝竴浣嶇殑绌烘牸鐒跺悗杩斿洖  
    }  
	
	/* 涓�绉嶉�掑綊鏂规硶銆�  */
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
