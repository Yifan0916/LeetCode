package DP;

public class ClimbStairs {
	public int climbStairs(int n) {
        if(n==0) return 0;
        int num1=0;
        int num2=1;
        int num3=0;
        for(int i=1;i<=n;i++) {
            num3=num1+num2;
            num1=num2;
            num2=num3;
        }
        return num2;
    }
}
