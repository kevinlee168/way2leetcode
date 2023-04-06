package leetcode.Java;

/**
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        //使用快慢双指针：快指针向后找不等于0的值，找到就赋值slow位置的元素，并将fast位置的元素设置为0。
        // 然后，slow、fast指针向后移动
        //最后，将后面部分（slow之后）的元素设置为0.
        int slow = 0;
        int fast = 0;
        int tmp;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }

    }
}
