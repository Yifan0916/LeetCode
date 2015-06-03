package string;

import java.util.ArrayList;

public class SimplifyPath {
	/*
	 * ../表示回到上一级root,也就是删除一级路径（这里要保证上一级存在并已经存起来了）。  ./表示留在当前路径，所以可以ignore.
	 * 
	 */
	public String simplifyPath(String path) {
        if (path.length()==0) return "/";
        String res="";
        String[] arr=path.split("/+");
        ArrayList<String> list = new ArrayList<String>();
        for (String str: arr) {
            if (str.equals("..")) {
                if (list.size()>0)
                    list.remove(list.size()-1);  //pop()
            }
            else if (str.equals(".") || str.equals("")) continue;
            else list.add(str);
        }
        for (String str:list) {
            res+="/"+str;
        }
        if (res.length()==0) res+="/";
        return res;
    }
	/*
	 * 还可以用stack实现：
	 * Stack<String> list=new Stack<String>();  23-25行：
	 * while(!list.empty()) {  
            res+="/"+list.remove(0);  
        }
     *用LinkedList实现stack： 
     * LinkedList<String> list=new LinkedList<String>(); 
     * 24行用：res+="/"+list.removeLast();
	 */
	
	public static void main(String[] args){
		SimplifyPath sim = new SimplifyPath();
		System.out.println(sim.simplifyPath("./home/./foo"));
	}
}
