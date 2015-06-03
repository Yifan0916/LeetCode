package rotate;

public class RotateArray {
	//with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	public void rotate(int[] nums, int k) {
        int size=nums.length; //如果size=null会怎样？？？？
        k=k%size;  //防止出现OutOfBounds的错误。
        reverse (nums,size-k,size-1);
        reverse (nums,0,size-k-1);
        reverse (nums,0,size-1);
    }
    public void reverse (int[] array, int start, int end) {
        for (;start<end;start++,end--) {
         int temp = array[start];
         array[start]=array[end];
         array[end]=temp;
        }
    }
	
}
 