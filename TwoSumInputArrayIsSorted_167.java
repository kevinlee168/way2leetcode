package leetcode;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class TwoSumInputArrayIsSorted_167 {
    public static void main(String[] args) {
        int[] numbers1 = {2,7,11,15};
        int[] numbers2 = {2,3,4};
        int[] numbers3 = {-1,0};

        TwoSum(numbers1, 13);
        TwoSum(numbers2, 5);
        TwoSum(numbers3, -1);
    }

    public static int[] TwoSum(int[] nums, int target) {
        if(nums == null || nums.length <= 1){
            return null;
        }

        //【只要数组有序，就应该想到双指针技巧】
        //使用左右指针，相向而行。
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if(target > sum){
                left++;
            } else if (target < sum) {
                right--;
            } else if(target == sum){
                //找到了2个元素之和等于target
                int[] res = {left + 1, right + 1};
                return res;
            }
        }
        return null;
    }
}
