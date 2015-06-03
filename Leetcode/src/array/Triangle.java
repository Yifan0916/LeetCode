package array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		/*
		 * Given a triangle, find the minimum path sum from top to bottom. 
		 * Each step you may move to adjacent numbers on the row below.
		 */
		if (triangle.size()==0) return 0;
        int[] sum = new int[triangle.size()];
        sum[0]=triangle.get(0).get(0);
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i=1;i<triangle.size();i++) {
            list=triangle.get(i);
            sum[i]=list.get(i)+sum[i-1];  //处理末尾元素。
            for (int j=i-1;j>0;j--) {
                sum[j]=list.get(j)+Math.min(sum[j-1],sum[j]);  //从后向前遍历。
            }
            sum[0]=sum[0]+list.get(0);    //处理开头元素。
        }
        int min=sum[0];    //循环最后一行，找最小值。
        for (int i=1;i<sum.length;i++) {
            min=Math.min(min,sum[i]);
        }
        return min;
    }
	/*
	 * ，如果这道题不自顶向下进行动态规划，而是放过来自底向上来规划，递归式只是变成下一层对应的相邻两个元素的最小路径和加上自己的值.
	 * 优势在于不用单独处理第一个和最后一个元素。
	 * Note: 每一行不再从后向前遍历，否则还是会覆盖。要从前向后。
	 */
	public int minimumTotal_Update (List<List<Integer>> triangle) {
        if (triangle.size()==0) return 0;
        int[] sum = new int[triangle.size()];
        for (int i=0;i<triangle.size();i++) {
            sum[i]=triangle.get(triangle.size()-1).get(i);
        }
        List<Integer> list= new ArrayList<Integer>();
        for(int i=triangle.size()-2;i>=0;i--){
            list=triangle.get(i);
            for(int j=0;j<list.size();j++) {
                sum[j]=Math.min(sum[j],sum[j+1])+list.get(j);
            }
        }
        return sum[0];
    }
}
