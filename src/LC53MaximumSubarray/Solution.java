package LC53MaximumSubarray;

// Kadane's Algorithm
//要想明白哪一部分是值得被保留的 - any subarray sum > 0
//从第一个元素开始遍历 不断往后加后面的元素计算sum 一旦sum<0就重置为0，考虑下一个sub array
//[1,2,3,4] sub: [1,2,3,4],[1,2,3],[2,3,4],[1,2][2,3][3,4][1][2][3][4] 


//class Solution {
//  public int maxSubArray(int[] nums) {
//      int currentSum = nums[0];
//      int maxSum = nums[0];
     
//      for(int i=1; i < nums.length; i++){
//          int num = nums[i];
//          currentSum = Math.max(num, currentSum + num);
//          maxSum = Math.max(maxSum, currentSum);
//      }
//      return maxSum;
//  }
//}

//Divide and Conquer，利用recursion
//比上一个方法耗时且占用空间
//考虑成3种情况，只取元素左边的subarray, 只取右边的subarray, 两边都取 但是两边都取中间的元素必须取 不能中断
//也就是说从mid元素开始 往左i-- 往右i++找最大subarray

public class Solution {
	private int[] numsArray;
	 
	public int maxSubArray(int[] nums) {
	    numsArray = nums;
	     
	    return findBestSubarray(0, numsArray.length-1);
	}
 
	 private int findBestSubarray(int left, int right) {
	     if (left > right) {
	         return Integer.MIN_VALUE;
	     }
	     
	     int mid = Math.floorDiv(left + right, 2);
	     int curr = 0;
	     int bestLeftSum = 0;
	     int bestRightSum = 0;
	     
	     for (int i=mid-1; i >= left; i--) {
	         curr += numsArray[i];
	         bestLeftSum = Math.max(bestLeftSum, curr);
	     }
	     
	     curr = 0;
	     for (int i = mid + 1; i <= right; i++) {
	         curr += numsArray[i];
	         bestRightSum = Math.max(bestRightSum, curr);
	     }
	     
	     int combSum = numsArray[mid] + bestLeftSum + bestRightSum;
	     
	     int leftHalf = findBestSubarray(left, mid - 1);
	     int rightHalf = findBestSubarray(mid + 1, right);
	     
	     return Math.max(combSum, Math.max(leftHalf, rightHalf));
	     
	 }
}