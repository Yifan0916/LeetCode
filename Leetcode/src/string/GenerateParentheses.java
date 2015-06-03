package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n==0) return list;
        recurs(n,n,new StringBuilder(), list);
        return list;
    }
    public void recurs(int l, int r, StringBuilder sb, List<String> list) {
        if (l==0 && r==0) list.add(sb.toString());
        if (r < l) return; //前面）个数多于（，这是不合理的。
        if (l>0) 
        	recurs(l-1,r,sb.append('('),list);
        if (r>0)
            recurs(l,r-1,sb.append(')'),list);
    }
    /*
     * http://www.cnblogs.com/yuzhangcmu/p/4113563.html
     * http://blog.csdn.net/linhuanmars/article/details/19873463 ?????????
     */
    
public static void main(String[] args) {
	GenerateParentheses gp= new GenerateParentheses();
	gp.generateParenthesis(3);
}
}
