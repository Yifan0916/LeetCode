package string;

public class ReverseString {
	public String reverseString(String s) {
        char[] res = s.toCharArray();
        int size = s.length();
        for (int i = 0; i < size/2; i++) {
            char tmp = res[i];
            res[i] = res[size - i - 1];
            res[size - i - 1] = tmp;
            //System.out.println(String.valueOf(res));
        }
        return String.valueOf(res);
    }
	
	public static void main(String[] args) {
		ReverseString test = new ReverseString();
		System.out.println(test.reverseString("hello"));
	}

}
