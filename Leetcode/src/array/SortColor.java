package array;

public class SortColor {
	public void sortColors(int[] A) {
		/*
		 * Given an array with n objects colored red, white or blue, 
		 * sort them so that objects of the same color are adjacent,
		 * with the colors in the order red, white and blue.
		 * Method: Two Pointer.
		 */
        int index_0=-1;
        int index_1=-1;
        for (int i=0;i<A.length;i++) {
            if (A[i]==0) {
                A[i]=2;  //必须有！！ 不然[2,0]会变成[0，0]
                A[++index_1]=1;  
                A[++index_0]=0;   //前后两句顺序很重要，不然0会被1覆盖！！
            }
            else if (A[i]==1) {
                A[i]=2;
                A[++index_1]=1;
            }
        }
    }
	/*
	 * 九章： http://www.cnblogs.com/yuzhangcmu/p/4048668.html
	 * Method: radix sort --先count出现频率， 再A修改。
	 */
	public void sortColors_1(int[] A) {
		          if (A == null || A.length == 0) {
		              return;
		          }
		          
		          int len = A.length;
		          
		         int red = 0;
		          int white = 0;
		         int blue = 0;
		         
		         for (int i = 0; i < len; i++) {
		             if (A[i] == 0) {
		                 red++;    
		             } else if (A[i] == 1) {
		                 white++;
		             } else {
		                 blue++;
		             }
		         }
		        
		         for (int i = 0; i < len; i++) {
		             if (red > 0) {
		                 A[i] = 0;
		                 red--;
		             } else if (white > 0) {
		                 A[i] = 1;
		                 white--;
		            } else {
		                 A[i] = 2;
		             }
		         }
		     }
	//Method 2: two pointer 一个从开头开始， 令一个从末尾开始。
	public void sortColors_2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        
        int len = A.length - 1;
        int left = 0;
        int right = len;
        
        int cur = 0;
        while (cur <= right) {
            if (A[cur] == 2) {
                // 换到右边，换过来的有可能是0，也有可能是1，所以cur要停留
                
                swap(A, cur, right);
                right--;
            } else if (A[cur] == 0) {
                // 从左边换过来的只可能是1，所以可以直接cur++,
                // 因为所有的2全部换到右边去了。
                //System.out.println(left+"  "+cur);
                swap(A, left, cur);
                left++;
                cur++; //这一步不能忽略，否则，只有left++,left会超过cur，甚至outofbound，而cur一直停留在原地，例如{0}。
            } else {
                cur++;
            }
        }
    }
    
    public void swap(int[] A, int n1, int n2) {
        int tmp = A[n1];
        A[n1] = A[n2];
        A[n2] = tmp;
    }
    
    /*
     * http://blog.csdn.net/kenden23/article/details/17440519
     * counting sort ?????
     */
	public static void main(String[] args) {
		SortColor test= new SortColor();
		int[] A={0};
		test.sortColors_2(A);
		System.out.println(A);
	}
}
