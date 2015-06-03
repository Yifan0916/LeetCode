package DP;

public class HouseRobber {
	public int rob(int[] num) {
        if(num.length==0) return 0;
        if(num.length==1) return num[0];
        if(num.length==2) return num[0]<num[1]?num[1]:num[0];
        if(num.length==3) return num[0]+num[2]<num[1]?num[1]:num[0]+num[2];
        num[2]=num[0]+num[2];
        int max=Math.max(num[1],num[2]);
        for(int i=3;i<num.length;i++) {
            num[i]=Math.max(num[i-2],num[i-3])+num[i];
            max=Math.max(max,num[i]);
        }
        return max;
    }
	
	public int rub_update(int[] num) {
		if(num.length==0) return 0;
		int prev=0;
		int cur=0;
		int max=0;   //这里的cur是不考虑前一位数的最大值。
		for(int i=0;i<num.length;i++) {
			prev=cur;
			cur=max+num[i];
			max=Math.max(prev,max);
		}
		return Math.max(cur, prev);
	}
}
