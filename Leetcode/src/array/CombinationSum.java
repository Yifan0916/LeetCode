package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =  new ArrayList<List<Integer>>();
        if (candidates.length==0) 
            return list;
        List<Integer> inner = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        recur(candidates,target, 0, inner, list);
        return list;
    }
    public void recur(int[] candidates, int target, int index, List<Integer> inner, List<List<Integer>> list) {
        if (target==0) {
            list.add(new ArrayList<Integer>(inner));   //target=0,意味着已经找到一个combination，所以可以添加进去！
            return;
        }
        int prev=-1;
        for (int i=index;i<candidates.length;i++) { //一定注意i=index是初始值！！！！不是从0开始！！不然combination不unique！
            if (candidates[i]>target) break; //注意在实现中for循环中第一步有一个判断，
                                             //那个是为了去除重复元素产生重复结果的影响，
                                             //因为在这里每个数可以重复使用，所以重复的元素也就没有作用了，所以应该跳过那层递归。
            if (prev!=-1 && prev==candidates[i]) continue;
            
            inner.add(candidates[i]);
            recur(candidates,target-candidates[i], i, inner, list);  //因为一元素可用很多次，所以不是i+1。
            inner.remove(inner.size()-1);
            
            prev=candidates[i];
        }
    }
    
    public void recur_Update(int[] candidates, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> inn, int index) {
        if(target == 0) {res.add(new ArrayList<Integer>(inn)); return ;}
        //if(sum > target) return;
        for(int i=index; i<candidates.length; i++) {
            if(candidates[i] > target) break;
            while( i<candidates.length-1 && candidates[i] == candidates[i+1]) i++; //去除重复！！！
            
            inn.add(candidates[i]);
            recur_Update(candidates, target-candidates[i], res, inn, i); 
            inn.remove(inn.size()-1);
            
            /*
             * Combination Sum II 把46 传入参数变为i+1， 然后43行放到此处。
             */
        }
    }
    /*
     * Combination Sum II 要求每个元素只能用一次。就把31行传入参数变成i+1，把关于prev 的都drop.
     * 行变成： if (i>index && candidates[i]==candidates[i-1]) continue;注意这里还是要判断和前一个元素不相等，否则会出现重复combination。
     */
}
