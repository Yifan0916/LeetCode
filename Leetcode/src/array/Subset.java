package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> set=new ArrayList<List<Integer>>();
        List<Integer> tmp=new ArrayList<Integer>();
        set.add(tmp); //空集合。
        Arrays.sort(S);
        recur(S,0,tmp,set);
        return set;
    }  
    
    public void recur(int[] S, int pos, List<Integer> tmp,List<List<Integer>> set) {
        for(int i=pos;i<S.length;i++) { //i初始值为pos，不为0！！！！
            tmp.add(S[i]);
            set.add(new ArrayList<Integer>(tmp)); //为什么一定要new？？？？？？
           // System.out.println(tmp.toString());
            recur(S,i+1,tmp,set); 
            tmp.remove(tmp.size()-1);
        }
    }
   
    /*Code Ganker   */
    public ArrayList<ArrayList<Integer>> subsets_II(int[] S) {
        //ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        //ArrayList<Integer> inn = new ArrayList<Integer>();
         if(S == null)  
        return null;  

        Arrays.sort(S);
        
        return dfs(S, S.length-1);  //必须从末尾开始，否则会出现后面元素先添加的问题。
    }
    
    public ArrayList<ArrayList<Integer>> dfs(int[] S, int index){
    	System.out.println(index);
        if(index == -1) {
            ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> inn = new ArrayList<Integer>();
            res.add(inn);
            return res;
        }
        ArrayList<ArrayList<Integer>> res= dfs(S, index-1);
        int size = res.size();  
        for (int i=0; i<size; i++) {
            ArrayList<Integer> inn = new ArrayList<Integer>(res.get(i));
            inn.add(S[index]);
            res.add(inn);
        }
        return res;
    }
    public static void main(String[] args) {
    	Subset test = new Subset();
    	int[] S = {0};
    	test.subsets_II(S);
    }
    
}
