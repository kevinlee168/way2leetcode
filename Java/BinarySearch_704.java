package leetcode.Java;

public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(BinarySearch(nums, -1));
    }

    public static int BinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        //二分查找，左右双指针，相向而行
        int left = 0;
        int right = nums.length - 1;
        //注意判断条件：<=
        while (left <= right ) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
