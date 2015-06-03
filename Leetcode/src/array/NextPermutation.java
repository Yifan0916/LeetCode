package array;

public class NextPermutation {
	/*
	 * mplement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	 * If such arrangement is not possible, it must rearrange it as the lowest possible order 
	 * (ie, sorted in ascending order).
	 * http://blog.csdn.net/linhuanmars/article/details/20434115
	 */
	public void nextPermutation(int[] num) {
		if (num.length==0) return;
        int left=num.length-2;
        while (left>=0 && num[left]>=num[left+1]) {  ////原来的错误在于用了for循环.问题在于[3,2,1]，得到的left为最后一个位置。
        	                                         //所以后面的permutate会没法进行。但实际上应该是升序排列的！
            left--;
        }
        
        if (left>=0) {
            //向右循环，找到第一个比lef小的数，调换。
        int right=left+1;
        while (right<num.length && num[right]>num[left]) { //原来的错误在于用了for循环，问题在于例如[1,2]，找不到，所以也就不会调换，
        	                                               //因为后面left+1，所以也不会permutate最后。
            right++;
        } 
        int temp=num[left];
        num[left]=num[--right];
        num[right]=temp;
        }
        
        //permutate left位置之后的所有数。  
        for (int i=left+1;i<=(num.length+left)/2;i++) {
            int temp=num[i];
            num[i]=num[num.length-i+left];
            num[num.length-i+left]=temp;
        }
    }
	
	public void nextPermutation_9Chapter(int[] num) {
        if (num == null) {
            return;
        }
        
        int len = num.length;
        for (int i = len - 2; i >= 0; i--) {  //嵌套循环。
            if (num[i + 1] > num[i]) {
                int j;
                for (j = len - 1; j > i - 1; j--) {
                    if (num[j] > num[i]) {
                        break;
                    }
                }

                swap(num, i, j);
                reverse(num, i + 1, len-1);
                return;
            }
        }

        reverse(num, 0, len-1);
    }

    void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    void reverse(int[] num, int beg, int end) {
        for (int i = beg, j = end; i < j; i ++, j --) {
            swap(num, i, j);
        }
    }
}
