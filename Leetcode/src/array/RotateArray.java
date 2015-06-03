package array;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		k=k%nums.length;
		if(nums.length==0) return;
		reverse(nums,0,nums.length-k-1);   //先把（size-k）个数进行reverse，
		reverse(nums,nums.length-k,nums.length-1);       //reverse后半段数，注意边界，因为reverse函数中包含end，所以结尾是nums.length-1.
		reverse(nums,0,nums.length);       //reverse整个nums。
	}
	public void reverse(int[] nums, int start, int end) {
		for(;start<end;start++,end--) { //注意每一次for，start，end都要发生变化。
			int tem=nums[start];
			nums[start]=nums[end];
			nums[end]=tem;
		}
	}
}
