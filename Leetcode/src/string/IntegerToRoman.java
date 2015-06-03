package string;

import java.util.ArrayList;

public class IntegerToRoman {
	
	public String intToRoman(int num) {
		/*
		 * 罗马数字对于每个位有三个单位：1,5,10，对于1到9，表示方法如下：
         *1-3：用1表示；
         *4:1：5左边加一个1；
         *5： 直接用5表示； 
         *6-8: 5右边加相应的1；
         *9： 10左边加一个1。
         *因为知道不会超过4000，所以直接求4位出来，算法时间复杂度是O(整数的位数），空间复杂度是O(1)
		 */
        int remainder=num;
        int div=0;
        int digit=1000;
        StringBuilder build = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(digit>=1) {
            div=remainder/digit;
            remainder%=digit;
            //if (div!=0)  //不需要保证某一位不为0， 因为会进入trans函数的switch-default 选项直接跳出。
                list.add(div);
            digit/=10;
        }
        build.append(trans(list.get(0), 'M', ' ',' '));
        build.append(trans(list.get(1), 'C', 'D','M'));
        build.append(trans(list.get(2), 'X', 'L','C'));
        build.append(trans(list.get(3), 'I', 'V','X'));
        return build.toString();
    }
    public String trans (int div, char one, char five, char ten) {
        StringBuilder s = new StringBuilder();
        switch (div) {
            case 9: s.append(one); s.append(ten); break;
            case 8:
            case 7:
            case 6: 
                s.append(five);
                //s.append(one);
                for (int i=0; i<div-5;i++) {
                   s.append(one);
                 }
                 break;
            case 5: s.append(five); break;
            case 4: s.append(one); s.append(five);break;
            case 3:
            case 2:
            case 1: for (int i=0; i<div;i++) {
                       s.append(one);
                    }  
                    break;
            default: break;     
        }
        return s.toString();
    }
}
