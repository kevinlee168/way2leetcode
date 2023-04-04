package leetcode.Java;

public class RemoveElement_27 {
    public static void main(String[] args) {
        //int[] nums = {3,2,2,3};
        int[] nums = {2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    /**
     * 双指针，一前一后，相向而行
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        //不相等的元素计数器
        int k = 0;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            //注意：将游标比较放在前面，以防发生数组越界的错误
            while (start <= end && nums[start] != val) {
                //前面部分存在不等于val的元素时，start往后移一位，k计数器也加1
                start++;
                k++;
            }
            //注意：将游标比较放在前面，以防发生数组越界的错误
            while (0 <= end && nums[end] == val) {
                end--;
            }
            //注意：将游标比较放在前面，以防发生数组越界的错误
            if (start < end && nums[start] == val){
                nums[start] = nums[end];
                start++;
                end--;
                k++;
            }
        }
        return k;
    }
}

