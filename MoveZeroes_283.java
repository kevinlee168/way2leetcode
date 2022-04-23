package leetcode;

/**
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {1,0};
        int val = 0;

        //使用快慢双指针：快指针向后找不等于0的值，找到就赋值slow位置的元素，并将fast位置的元素设置为0。
        // 然后，slow、fast指针向后移动
        //最后，将后面部分（slow之后）的元素设置为0.
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        //将后面部分（slow之后）的元素设置为0.
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }

    }
}
