package array;

public class BestProfit {
	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i.
     *Design an algorithm to find the maximum profit.
	 */
	public int maxProfit(int[] prices) {
		//http://blog.csdn.net/lsdtc1225/article/details/39648783 
        if (prices.length==0 || prices==null) return 0;
        int max=0;
        int lowest=prices[0];
        for (int i=0;i<prices.length;i++) { //for (int price:prices)
            lowest=Math.min(prices[i],lowest);
            max=Math.max(max,prices[i]-lowest);
        }
        return max;
    }
		
	public int maxProfit_II(int[] prices) {
		//不限制次数。随意进行交易。所以可以在同一天先卖再买，只需要比较两天的差价，》0即可进行交易。
        if (prices.length==0 || prices==null) return 0;
        int max=0;
        int pro=Integer.MAX_VALUE;
        for (int i=0;i<prices.length-1;i++) {
            pro=prices[i+1]-prices[i];
            if(pro>0) max+=pro; 
        }
        return max;
    }
	
	
}
