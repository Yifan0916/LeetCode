package array;

public class removeDup_2 {
	public int removeDuplicates(int[] A) { //閫熷害鎱€��
        if(A.length==0 || A==null) return 0;
        if(A.length==1) return 1;
        int size=0;
        int count=1;
        for (int i=0;i<A.length-1;i++) {
            if(A[i]==A[i+1]) {
                count++;
                if(count>2) {
                    //count=0;
                    A[++size]=0;
                    continue;
                }
                else A[++size]=A[i+1];
            }
            else {
                A[++size]=A[i+1];
                count=1;
            }
        }
        return size+1;
    }
	public int removeDuplicates_2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        int count = 1; //!!!!
        int size = 0;
        for (int i = 1; i < nums.length; i++) {  //i starts from 1 !!!!!
            if (nums[i] == nums[size]) {
                if (count < 2) {
                    nums[++size] = nums[i];
                    count++;
                }
            }
            else {
                nums[++size] = nums[i];
                count = 1;
            }
        }
         
        return size + 1;
    }
}
