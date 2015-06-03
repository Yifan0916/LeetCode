package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> set=new ArrayList<List<Integer>>();
        List<Integer> inner= new ArrayList<Integer>();
        Arrays.sort(num);
        set.add(inner);
        helper(num,0,inner,set);
        return set;
        }
        public void helper(int[] num, int pos, List<Integer> inner, List<List<Integer>> set) {
            for (int i=pos;i<num.length;i++) {
                inner.add(num[i]);
                set.add(new ArrayList<Integer>(inner));
                helper(num,i+1,inner,set);
                inner.remove(inner.size()-1);
                while(i<num.length-1 && num[i]==num[i+1]) i++;
        }
    }
}
