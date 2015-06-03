package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterComOfPhoneNum {
	/*
	 * Given a digit string, return all possible letter combinations that the number could represent.
     *A mapping of digit to letters (just like on the telephone buttons) is like the dialing number.
     *Method 1: 经典递归。DFS
	 */
	public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        if(digits.length()==0) return res;
        //Initialize the mapping.
        HashMap<Character,char[]> map = new HashMap<Character,char[]>();  //这里可以用String[] 代替。见Method 2.
        map.put('0',new char[]{' '});
        map.put('1',new char[]{});
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        
        StringBuilder sb=new StringBuilder();
        dfs(digits, map, res, sb);
        return res;
    }
    public void dfs(String digits, HashMap<Character,char[]> map, List<String> res, StringBuilder sb) {
        if(sb.length()==digits.length()) {
            res.add(sb.toString());
            return;
        }
        for(char c: map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            dfs(digits, map, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
	
    /*
     * Method 2: Combination
     */
    public List<String> letterCombinations_Com(String digits) {
        List<String> res=new ArrayList<String>();
        res.add("");
        if(digits.length()==0) return res;
        String[] list={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<digits.length();i++) {
            String s=list[digits.charAt(i)-'0'];
            System.out.println(s);
            for(int j=0;j<res.size();j++) {
                for(int z=0;i<s.length();z++) {
                    res.add(res.get(j)+Character.toString(s.charAt(z)));
                }
            }
        }
        return res;
     }
    public static void main(String[] args){
    	LetterComOfPhoneNum test= new LetterComOfPhoneNum();
    	System.out.println(test.letterCombinations_Com("232"));
    	//System.out.println("ab"+'c');
    }
}
