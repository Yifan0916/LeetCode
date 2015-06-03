package array;

import java.awt.List;
import java.util.ArrayList;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 *For example, given k = 3, Return [1,3,3,1].
 */
public class Pascal_II {
	
	public ArrayList<Integer> getRow(int rowIndex) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> prev =new ArrayList<Integer>();

        if(rowIndex==0) return list;
        
        prev.add(1);
        for (int i=1;i<rowIndex;i++) {
            list.add(1);
            for(int j=1;j<i;j++) {
                list.add(prev.get(i)+prev.get(i-1));
            }
             list.add(1);
             prev=list;
        }
        return list;
    }
	
	/*
	 * 如果我们只用一行空间，那么需要的数据就会被覆盖掉。所以这里采取的方法是从后往前扫，我们需要的数据不会被覆盖
	 */
	public ArrayList<Integer> getRow_Update(int rowIndex) {
		ArrayList<Integer> res= new ArrayList<Integer>();
        //if(rowIndex==0) return res;
        res.add(1);
        if(rowIndex==0) return res;
        for(int i=1;i<=rowIndex;i++) {
            for(int j=i-1;j>0;j--) {
            res.set(j,res.get(j)+res.get(j-1));
            }
            res.add(1); //end with 1.
        }
        
        return res;
	}
}
