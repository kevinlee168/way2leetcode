package leetcode.Java;

import java.util.HashMap;

/**
 Q: Given an array of integers nums and an integer target,
 return indices of the two numbers such that they add up to target.z
 */
public class TwoSum_1 {
    /**
     * 思路1：2层循环，遍历数组，寻找目标元素下标。 时间复杂度：O(N*N)
     *
     * 思路2：利用空间换时间。 时间复杂度 O(N)
     * 首先，用一个  HashMap 映射元素值 与 下标 (k, v) = (元素值，下标)
     * 然后，遍历数组，用（target - nums[i]）去 hashMap中查询是否存在（k，v）。
     * 如果存在，表示找到对应都2个元素，返回2个元素都下标。
     * 如果不存在，继续遍历数组，直到遍历完。
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //将数组（值，下标）映射到 hashMap 中
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        //遍历数组，寻找目标下标
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashMap.containsKey(diff)){
                //注意：不能是同一个元素使用2次，即这2个元素到下标应该不相同
                if (i != hashMap.get(diff))
                    return new int[]{i, hashMap.get(diff)};
            }
        }
        return null;
    }
}
