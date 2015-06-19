package array;

import java.util.ArrayList;

public class CombinationSum3 {
/*
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Input: k = 3, n = 9
 * ==>[[1,2,6], [1,3,5], [2,3,4]]
 */
	public ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n == 0) return res;
        ArrayList<Integer> inn = new ArrayList<Integer>();
        recur(res, inn, k, n, 1);
        return res;
    }
    public void recur(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> inn, int k, int n, int ini){
    	System.out.println("k: "+k);
        if (k == 0) {
            if (n ==0 ) {
            	res.add(new ArrayList<Integer>(inn) );
            	//System.out.println(inn);
            }
            return;
        }
        for (int i = ini; i < 10 ; i++) {
        	//System.out.println(i);
            if (i > n) break;
            inn.add(i);
            System.out.println(inn);
            recur(res, inn, k-1, n-i, i+1);
            inn.remove(inn.size()-1); //cannot use inn.remove(i) directly,
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum3 test = new CombinationSum3();
		test.combinationSum3(2, 18);
	}

}
