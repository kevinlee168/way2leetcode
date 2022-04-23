package leetcode;

public class RemoveDuplicatesfromSortedArray_26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(nums));
        for (int i: nums) {
            System.out.print(i + ", ");
        }

        System.out.println("**************");
        int[] nums2 = {1,1,2,2};
        System.out.println(removeDuplicates2(nums2));
        for (int i: nums2) {
            System.out.print(i + ", ");
        }

    }

    /*
     * 我们让慢指针 slow 走在后面，快指针 fast 走在前面探路，找到一个不重复的元素就告诉 slow 并让 slow 前进一步。
     * 这样当 fast 指针遍历完整个数组 nums 后，**nums[0..slow] 就是不重复元素**。
     */
    public static int removeDuplicates2(int[] nums) {
        int pre = 0;
        int curr = 1;
        int len = nums.length;
        while (curr < len) {
            if (nums[pre] != nums[curr]) {
                nums[++pre] = nums[curr];
            }
            curr++;
        }
        return pre + 1;
    }
}
