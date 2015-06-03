package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // 在two-sum方法外面套一层for循环。
	//依次从num中拿出一个元素记为x，将问题转化为寻找和为 -x 的 2 sum 问题.
	//Two pointers.
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) return list;
        Arrays.sort(num);
        
        for (int i=0; i< num.length - 2; i++){
        	if (i != 0 && num[i] == num[i-1]) continue; //Important!!!排除重复元素！！
            int left = i+1;
            int right = num.length-1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < 0) left++;
                else if (sum >0) right--;
                else {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    list.add(temp);
                    left++;
                    right--;
                    while (left<right) {
                        if (num[left] == num[left-1]) left++; //排除重复元素。
                        while (left<right && num[right] == num[right+1]) right--;
                    }
                }
            }
        }
        return list;
    }
	//Code Ganker做法。 为什么时间短？？
	public List<List<Integer>> threeSum_Ganker(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
    if(num==null || num.length<=2)  
        return res;  
    Arrays.sort(num);  
    for(int i=num.length-1;i>=2;i--)  
    {  
        if(i<num.length-1 && num[i]==num[i+1])  
            continue;  
         ArrayList<List<Integer>> curRes = twoSum(num,i-1,-num[i]);  
         for(int j=0;j<curRes.size();j++)  
         {  
             curRes.get(j).add(num[i]);  
         }  
         res.addAll(curRes);  //???????
    }  
    return res;  
}  
private ArrayList<List<Integer>> twoSum(int[] num, int end,int target)  
{  
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();  
    if(num==null || num.length<=1)  
        return res;  
    int l = 0;  
    int r = end;  
    while(l<r)  
    {  
        if(num[l]+num[r]==target)  
        {  
            List<Integer> item = new ArrayList<Integer>();  
            item.add(num[l]);  
            item.add(num[r]);  
            res.add(item);  
            l++;  
            r--;  
            while(l<r&&num[l]==num[l-1])  
                l++;  
            while(l<r&&num[r]==num[r+1])  
                r--;  
        }  
        else if(num[l]+num[r]>target)  
        {  
            r--;  
        }  
        else  
        {  
            l++;  
        }  
    }  
    return res;  
    }
}
