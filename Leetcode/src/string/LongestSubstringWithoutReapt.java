package string;

import java.util.HashSet;

public class LongestSubstringWithoutReapt {
	public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int l=0;
        int r=0;
        HashSet<Character> set= new HashSet<Character>();
        int max=0;
        //int size=0;
        while (r<s.length()) {
            if (set.contains(s.charAt(r))) {
                while(l<r) {
                    if(s.charAt(l)==s.charAt(r)) {
                    	System.out.print("Repeat "+s.charAt(r));
                        //set.remove(s.charAt(l));  找到的同样的元素不应该删除，因为set中不会添加同样 的s.charAt(r),所以应该保留，只需l++就可以了。
                        l++;
                        //max=Math.max(max,r-l); 没必要用，因为每次添加的时候都会做。
                        break;
                    } else {
                        set.remove(s.charAt(l));
                        System.out.println("remove "+s.charAt(l));
                        l++;
                    }
                }
                r++;
            } else {
            	//System.out.println(set.contains(s.charAt(r)));
            	set.add(s.charAt(r));
            	//System.out.println(set);
            	max=Math.max(max,r-l+1);   //这里不能用max++,因为例如"abba",max不可能会减少，只会递增，所以就出现3
                //System.out.println(max);
                r++;
            }
        }
       //max=Math.max(max,r-l);
        return max;
    }
	/*
	 * 简化一下while中嵌套的while部分。
	 */
	public int lengthOfLongestSubstring_Update(String s) {
        if (s.length()==0) return 0;
        int l=0;
        int r=0;
        HashSet<Character> set= new HashSet<Character>();
        int max=0;
        //int size=0;
        while (r<s.length()) {
            if (set.contains(s.charAt(r))) {
                while(l<r&&s.charAt(l)!=s.charAt(r)) { //条件合一。
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;  //不用担心，while里面l++后外面又++出现错误，因为一定会存在重复元素。
            }
                
             else {
                set.add(s.charAt(r));
                max=Math.max(max,r-l+1);
                
            }
            r++;
        }
        return max;
    }
	
	public static void main(String[] args) {
		LongestSubstringWithoutReapt test=new LongestSubstringWithoutReapt();
		System.out.println(test.lengthOfLongestSubstring("abba"));
	}
}
