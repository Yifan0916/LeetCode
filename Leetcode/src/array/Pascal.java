package array;

import java.awt.List;
import java.util.ArrayList;

public class Pascal {
	//返回杨辉三角。
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        if (numRows==0) return res;
        ArrayList<Integer> inner=new ArrayList<Integer>();
        inner.add(1);
        res.add(inner);
        System.out.println(res);
        if(numRows==1) return res;
        /*//正确做法！！！！！
         * for(int i=1;i<numRows;i++) {
            inner=new ArrayList<Integer>();
            inner.add(1);
            for(int j=1;j<i;j++){
                inner.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            inner.add(1);
            res.add(inner);
        }
        return res;
         */
        inner=new ArrayList<Integer>();  //实验做法！！！一定要定义这一句，不然inner第二次add(1)时，res里面的第一行也会跟着更改。
        inner.add(1);
        inner.add(1);
        res.add(inner);
        System.out.println(res);
        //if(numRows==1) return res;
        for(int i=2;i<numRows;i++) {
            //inner=new ArrayList<Integer>();
            //inner.add(1);
            for(int j=1;j<i;j++){
                inner.set(j, inner.get(j-1)+inner.get(j));
            }
            inner.add(1);
            res.add(inner);
        }
        return res;
    }
	
	public static void main(String[] args) {
		Pascal test=new Pascal();
		test.generate(2);
	}
	
	
}
