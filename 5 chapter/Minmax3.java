class Minmax3{
	public static void main(String args[]){
		int nums[] = { 99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49 };

		int min, max;

		min = max = nums[0];
		for(int x : nums){
			min = min < x ? min : x;
			max = max > x ? max : x;
		}

		System.out.println("Min is : " + min + " Max is: " + max);
	}
}