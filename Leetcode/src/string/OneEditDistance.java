package string;

public class OneEditDistance {
    public boolean isOne(String s, String t) {
    	if(Math.abs(s.length()-t.length())>1) return false;
    	if(s.length()>t.length()) {  //保证s长度不大于t。
    		String tem=s;   //直接用isOne(t,s)代替！！！！！太明智了！！！！！
    		s=t;
    		t=tem;
    	}
    	int i=0;
    	if(t.length()-s.length()==1) {
    		for(;i<s.length();i++) {
        		if(s.charAt(i)!=t.charAt(i)) {
        			if(s.charAt(i)!=t.charAt(i+1)) return false;
        			else break;
        		}
        	}
        	for(;i<s.length();i++) {
        		if(s.charAt(i)!=t.charAt(i+1)) return false; //因为前面已经检查出一个不相等的地方，再错就是false。
        		
        	}
        	return true;
    	}
    	else {
    		while(i<s.length()&&s.charAt(i)==t.charAt(i)) i++;
    	    if(i==s.length()) return false;  //两个字符串完全相等
    	    else {
    		    i++;
    		    while(i<s.length()&&s.charAt(i)==t.charAt(i)) i++;
    		    if(i<s.length()) return false;
    		    else return true;
    	}
    	}
    	
    	
		//return false;
   
    }   	
    public boolean isOneEditDistance(String s, String t) {
    	 int m=s.length();
    	 int n=t.length();
    	 if(n-m>1) return false;
    	 if(m>n) return isOneEditDistance(t,s);
    	 int i=0; 
    	 int shift=n-m;
    	 while(i<m&&s.charAt(i)==t.charAt(i)) i++;
    	 if(i==m) return false;  //完全相等；
    	 //if(n-m==0) i++;  //跳过这个不相等的元素，如果生下的都相同，返回true。     ----这是不对的，因为如果前面的都相同，只是append一个元素，也会返回false.
    	 if(n-m==0) return shift==1;
    	 
    	 while(i<s.length()&&s.charAt(i)==t.charAt(i+shift)) i++;
    	 return i==m;
    }
    
    public static void main(String[] args) {
    	OneEditDistance test=new OneEditDistance();
    	System.out.println(test.isOneEditDistance("cabcde", "abcde"));
    }
}
