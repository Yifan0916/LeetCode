package Implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Anagram {
	//Question: Given an array of strings, return all groups of strings that are anagrams.
	//http://blog.csdn.net/linhuanmars/article/details/21664747
	public List<String> anagrams(String[] strs) {
        List<String> list=new ArrayList<String>();
        if (strs.length==0 || strs ==null) return list;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i=0;i<strs.length;i++) {
            char[] charArray = strs[i].toCharArray(); //分解
            Arrays.sort(charArray);  //排序
            String newString =  new String(charArray); //重组string
            
            if (map.containsKey(newString)) {
                map.get(newString).add(strs[i]);   
            } else {
                ArrayList<String> valueList = new ArrayList<String>();
                valueList.add(strs[i]);
                map.put(newString, valueList);
            }
            
        }
        Iterator iter = map.values().iterator();   //遍历。
        while (iter.hasNext()) {
            ArrayList<String> values = (ArrayList<String>) iter.next();
            if (values.size()>1) {
                list.addAll(values);  //??? addAll()??
            }
        }
        return list;
    }
}
