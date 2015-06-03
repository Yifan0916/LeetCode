package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	/*
	 * Given a sorted integer array where the range of elements are [0, 99] inclusive, 
	 * return its missing ranges.
	 * In this case, start=0, end=99;
	 */
	public List<String> findMissRanges (int[] num, int start, int end) {
		List<String> list = new ArrayList<String>();
		int prev=start-1;
		int cur=num[0];
		for (int i=0; i<=num.length;i++) {
			if (i==num.length) cur=end+1;
			else cur=num[i];
			//更简单写法： cur= i==num.length ? end+1: num[i];
			
			if (cur-prev>=2) 
				 list.add(getRanges(prev+1, cur-1));
			prev=cur;
		}
		return list;
	}
	public String getRanges (int start, int end) {
		if (start == end) 
			return String.valueOf(start);
		else return start+" -> "+end;
		//更简单直接的方法： return start==end?String.valueOf(start):start+" -> "+end;
	}
}
