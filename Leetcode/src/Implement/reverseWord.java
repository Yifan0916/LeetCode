package Implement;

public class reverseWord {
	public String reverseWords(String s) { //Wrong understanding of the question.
        StringBuffer reverse = new StringBuffer();
        if (s != null) {
            s = s.trim().replaceAll(" +"," ");
            for (int i=s.length()-1; i>=0;i--) {
                //reverse = reverse + s.charAt(i);
                reverse.append(s.charAt(i));
                reverse.reverse();
            }
            return reverse.toString();
        }
        else return null;
        
    }
}
