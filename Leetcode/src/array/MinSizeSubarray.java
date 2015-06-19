package array;

public class MinSizeSubarray {
	/*
	 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
	 * If there isn't one, return 0 instead.
	 */
	public int minSubArrayLen(int s, int[] nums) { //two pointers.
        if (nums.length == 0) return 0;
        //boolean flag = false;
        int sum= 0;
        int min =Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while (l <= r && r < nums.length) {
            sum += nums[r];
            if (sum >= s) {
                while (sum >= s && l<= r) {
                    sum -= nums[l++];
                }
                //l--;
                min = Math.min(min, r-l+2);
            }
            r++;
        }
        System.out.println(min);
        return min == Integer.MAX_VALUE? 0:min;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinSizeSubarray test = new MinSizeSubarray();
		int[] nums = {2,3,1,2,4,3};
		test.minSubArrayLen_binary(7, nums);
	}

	/*Method2: binary search */
	public int minSubArrayLen_binary(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int[] sums = new int[nums.length]; 
        sums[0] = nums[0];
        for (int i = 1; i<nums.length; i++) {//create the sum array.
            sums[i] = sums[i-1] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<sums.length; i++) {
            int l = i;
            int r = sums.length-1;
            while ( l + 1 < r) {
            	
                int mid = l + (r - l)/2;
                System.out.println("l: "+ l+" r: "+r+" mid: "+mid);
                if (sums[mid] - sums[i] + nums[i] == s) {
                    r = mid;
                    break;
                }else if(sums[mid] - sums[i] + nums[i] <s) l = mid;
                else r = mid;
                //System.out.println("r: "+r);
                System.out.println("l: "+ l+" r: "+r);
                
            }
              r = sums[l] - sums[i] + nums[i] >= s ? l: r; //这是为了避免如果nums[l] >=s，i=l时，r会一直向左接近i，
                                                           //但是又因为l<r时不会进入循环，意味着直接用r-i+1 会使结果多1.例如｛10，2，3｝，6.
              //another method: r = nums[l] >=s ? l:r;
            
            if (sums[r] - sums[i] + nums[i] >= s)
                min = Math.min(min, r - i + 1);
             
            System.out.println("sums[r ]"+ sums[r]);
            System.out.println("min: "+min);
        }
        System.out.println(min);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
