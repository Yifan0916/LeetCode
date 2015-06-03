package array;

import java.util.HashMap;

public class TwoSum {
	//暴力解法。
	public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        boolean flag = false;
        for (int i = 0; i< numbers.length-1; i++) {
            for (int j = i+1; j<numbers.length;j++) {
                if (numbers[i]+numbers[i] == target) {
                    index[0] = i+1;
                    index[1] = j+1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return index;
    }
	//不能用Array.sort()，因为题目要求返回数组的原index.
	//多处细节要注意！！！
	public int[] twoSumUpdate(int[] numbers, int target) {
        if (numbers == null || numbers.length <2) return null;
        int[] index = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        //利用HashpMap 存储 number[i]和对应的index, 这样可以直接利用map.containsKey直接查找，不用再做一次循环。
        for (int i = 0; i<numbers.length; i++) {
            map.put(numbers[i],i+1);  
        }
        for (int i = 0; i<numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int index_1 = i+1;
                int index_2 = map.get(target - numbers[i]);
                if (index_1 == index_2) continue;  //!!!一定注意判断两次的index是否相同，不同才继续。
                else {
                    index[0] = index_1;
                    index[1] = index_2;
                    break;
                }
                
            }
            
        }
        return index;
    }
	
	public int[] twoSum_Update(int[] num, int target) {
        int[] res=new int[2];
        if(num.length<2) return res;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<num.length;i++) {
            map.put(num[i],i+1);
        }
        for(int i=0;i<num.length;i++) {
        	System.out.println(i);
            if(map.containsKey(target-num[i])){
                if(map.get(target-num[i])!=i+1) {//index same
                    res[0]=i+1;
                    res[1]=map.get(target-num[i]);
                    break;  //必须有！！！不然index就会反过里啊！！！
                }
            }
        }
        return res;
    }
	
	//Method 2. two-pointer.
	public int[] twoSum_Pointer(int[] num, int target) {
        int[] res=new int[2];
        if(num.length<2) return res;
        int l=0;
        int r=num.length-1;
        while(l<r){
        	System.out.println(l+" "+r);
            int sum=num[l]+num[r];
            if(sum>target) r--;
            else if(sum<target) l++;
            else {
            	
                res[0]=l+1;
                res[1]=r+1;
                break;
            }
        }
        return res;
    }
	
	
	public static void main(String[] args){
		TwoSum test=new TwoSum();
		int[] A={3,2,4};
		test.twoSum_Pointer(A,6);
	}
	
}
