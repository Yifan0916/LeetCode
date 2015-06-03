package array;

public class TwoSumSorted {
	//The array is sorted in advance.
	
	//1. BinarySearch.
	public int[] twoSum_1(int[] numbers, int target) {
		for (int i=0; i<numbers.length; i++) {
			int j = biSearch(numbers, target-numbers[i],i+1);
			if (j != -1) return new int[] {i+1,j+1};
		}
		return null;
	}
	public int biSearch(int[] array, int target, int start) {
		int left = start;
		int right = array.length-1;
		while (left < right) {
			int med = left + (right - left) / 2;
			if (array[med] == target) return med;
            if (array[med] > target) right = med; 
            else left = med+1;
		}
		return (left == right && array[left] == target) ? left : -1;
	}
	
	//2. Two Pointers.
	public int[] twoSum_2(int[] numbers, int target) {
		int left = 0; 
		int right = numbers.length-1;
		
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum <target) left++;
			else if (sum > target) right--;
			else {
				return new int[] {left+1,right+1};
			}
		}
			return null;
	}
}
