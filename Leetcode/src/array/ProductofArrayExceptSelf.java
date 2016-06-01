package array;

public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 0; i < nums.length - 1; i++){
        	System.out.println(i+"-"+left[0]);
            left[i+1] = left[i] * nums[i]; 
        }
        for (int j = nums.length - 1; j > 0; j--){
            right[j - 1] = right[j] * nums[j];
        }
        for (int i = 0; i < nums.length; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }
	public int[] productExceptSelf_update(int[] nums) {
		
		return nums;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0};
		ProductofArrayExceptSelf test = new ProductofArrayExceptSelf();
		test.productExceptSelf(nums);
	}

}
