package string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
	/*
	 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	 * Given "25525511135", return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	public List<String> restoreIpAddresses(String s) {
        List<String> list= new ArrayList<String>();
        if(s.length()<4 ) return list; 
        dfs(s,0,1, "",list);
        return list;
    }
    public void dfs (String s, int index, int segment, String item, List<String> list){
        if (index>s.length()-1) return;
        if (segment==4) {
            String str=s.substring(index);
            if (!isValid(str)) return;      //一定要记得判断是否valid！！
            list.add(item+"."+str);
        }
        for (int i=1;i<4 && index+i<=s.length();i++) {
            String str=s.substring(index, index+i);    
            if (!isValid(str)) continue;
            if (segment==1)
                dfs(s, index+i, segment+1, str, list);
            else {
                dfs(s, index+i, segment+1, item+"."+str, list);
            }
        }
    }
    public boolean isValid(String str) {
        if(str.length()>3) return false;
        if(str.charAt(0)=='0' && str.length()>1) return false;
        if(Integer.parseInt(str)>255) return false;
        return true;
    }
public static void main(String[] args) {
	RestoreIP res=new RestoreIP();
	res.restoreIpAddresses("2551358");
}
}
