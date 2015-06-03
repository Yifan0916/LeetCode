package string;

import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		/*
		 * 分析规律，‘IX’， X=10， I=1， IX=10-1=9.
		 * 从后往前遍历罗马数字，如果某个数比前一个数小，则把该数在结果中减掉；反之，则在结果中加上当前这个数；
		 * http://www.cnblogs.com/yuzhangcmu/p/4117312.html
		 */
        int res=0;
        int cur=romanTable(s.charAt(0));;
        int next=0;
        for (int i=0;i<s.length();i++) {
            if (i!=s.length()-1) {
                next=romanTable(s.charAt(i+1));
                if (cur<next) {
                    res-=cur;
                } else res+=cur;
            }
            else res+=cur;
            cur=next;
        }
        return res;
    }
    public int romanTable (char s) {
        int num=0;
        switch (s) {
            case 'I': num=1; break;
            case 'V': num=5;break;
            case 'X': num=10;break;
            case 'L': num=50;break;
            case 'C': num=100;break;
            case 'D': num=500;break;
            case 'M': num=1000;break;
            default: break;
        }
        return num;
    }
    //Another thing is to use HashMapinstead of a function.
    public int romanToInt_Map(String s) {
        int res=0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int cur=map.get(s.charAt(0));
        int next=0;
        
        for (int i=0;i<s.length();i++) {
            if (i!=s.length()-1) {
                next=map.get(s.charAt(i+1));
                if (cur<next) {
                    res-=cur;
                } else res+=cur;
            }
            else res+=cur;
            cur=next;
        }
        return res;
    }
    
}
