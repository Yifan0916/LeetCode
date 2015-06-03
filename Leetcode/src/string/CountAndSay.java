package string;


public class CountAndSay {
	/*
	 * The count-and-say sequence is the sequence of integers beginning as follows:
     *1, 11, 21, 1211, 111221, ...
	 */
	public String countAndSay(int n) {
        if (n==0) return "";
        StringBuilder prev= new StringBuilder(); //Update: 可以直接用String prev 代替StringBuilder.只是在后面29行赋值的时候，
                                                         //改为prev=res.toString();
        prev.append(1);
        int count;
        for (int i=1;i<n;i++) {
            StringBuilder res= new StringBuilder();
            count=1;
            for(int j=1;j<prev.length();j++) {
                
                if (prev.charAt(j)==prev.charAt(j-1))  count++;
                else {
                    res.append(count);
                    res.append(prev.charAt(j-1));
                    count=1;
                }
            }
            //不要忽略对最后一个数的处理！！！因为for最后一步是倒数第二个数！！
            res.append(count);
            res.append(prev.charAt(prev.length()-1));
            prev=res;
        }
        return prev.toString();
    }
	
	/*
	 * 九章做法： recursive递归做法。
	 */
		public String countAndSay_recurse(int n) {
	        if (n==0) return null;
	        if (n==1) return "1";
	        String prev=countAndSay(n-1);
	        int count=0;
	        StringBuilder build = new StringBuilder();
	        for (int i=0;i<prev.length();i++) {
	            count++;
	            if (i==prev.length()-1|| (i<prev.length()&&prev.charAt(i)!=prev.charAt(i+1))) { //结尾和不结尾元素要区分好
	            
	                build.append(count);    //节省代码量！！
	                build.append(prev.charAt(i));
	                count=0;
	            }
	        }
	       
	        return build.toString();
	    
    }
	
	
	public static void main(String[] args) {
		CountAndSay c= new CountAndSay();
		System.out.println(c.countAndSay_recurse(3));
	}
}
