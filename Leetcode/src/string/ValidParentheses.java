package string;

import java.util.LinkedList;

public class ValidParentheses {
	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 */
	//下面的方法错了。只考虑到了对称着找，但是其实例如“[({(())}[()])]”也是可以的！！！
	public boolean isValid(String s) {
        if (s.length()==0) return true;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int i=1;
        while (i<s.length()) {
        	//System.out.println(i);
            if (!isPair(s.charAt(i),s.charAt(i-1))) {sb.append(s.charAt(i)); i++;}
            else {
                int j;
                for(j=sb.length()-1;j>=0 && i<s.length();j--) {
                	System.out.println(i+" "+s.charAt(i));
                    if(!isPair(s.charAt(i),sb.charAt(j))) return false; 
                    i++;
                }
                if (j>-1) {return false;}
                //sb.delete(0,sb.length()); 
                sb.setLength(0);
                System.out.println("set 0"); System.out.println(i);
            }
            
            System.out.println(i);
        }
        if (sb.length()>0) {System.out.println(sb.length());return false;}
        return true;
    }
    public boolean isPair(char a, char b){
		boolean pair=false;
        switch(a) {
            case ')': if(b=='(') pair=true; 
            case ']': if(b=='[') pair=true; 
            case '}': if(b=='{') pair=true; 
        }
		return pair;
    }
    /*
     * 主要考察对栈数据结构的操作。遇到左括号就入栈，遇到右括号看栈顶左括号是否与当前右括号匹配，匹配继续，否则返回false。
     * 算法的时间复杂度是O(n)，空间复杂度也是O(n)。
     * 实现中的小陷阱是注意结束的时候要判一下栈是否为空，不为空仍是不合法的。
     */
    public boolean isValid_Modify(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0;i<s.length();i++) {
            switch(s.charAt(i)) {
                case '(': stack.push('('); break;
                case '[': stack.push('['); break;
                case '{': stack.push('{'); break;
                case ')': 
                          if (stack.isEmpty() || stack.pop()!='(') return false;  //一定不能用&&链接两个条件，应该是stack为空，返回值不对都会false!!
                          break;
                case ']': 
                          if (stack.isEmpty() || stack.pop()!='[') return false;
                          break;
                case '}': 
                          if (stack.isEmpty() || stack.pop()!='{') return false;
                          break;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;  //don't have to consider the condition that s.length()==0
    }
    
    public static void main(String[] args){
    	ValidParentheses vp=new ValidParentheses();
    	System.out.println(vp.isValid("[])"));
    	System.out.println('<'+'}');  //??????????
    }
}
