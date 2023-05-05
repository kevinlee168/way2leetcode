package leetcode.Java;

import java.util.PriorityQueue;

/**
 * Created by Kevin Lee on 5/5/23
 */
public class Sort_an_Array_912 {
    /**
     * Method 2: use the PriorityQueue class
     */
    public int[] methodTwo(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int[] res = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.add(num);

        int i = 0;
        while (!pq.isEmpty()) res[i++] = pq.poll();

        return res;
    }

    /**
     * Method: use quicksort
     * !!!Note: there is bug in this codes
     */
    /**
     public int[] sortArray(int[] nums) {
     if (nums == null || nums.length == 0) return nums;
     sort(nums, 0, nums.length - 1);
     return nums;
     }
     public void sort(int[] nums, int low, int high) {
     if (low < high) {
     int p = partition(nums, low, high);
     sort(nums, low, p - 1);
     sort(nums, p + 1, high);
     }
     }

     public int partition(int[] nums, int low, int high) {
     int p = nums[low];
     int l = low;
     int h = high;

     while (l < h) {
     while (l <= high - 1 && nums[l] <= p) {
     l++;
     }   // to find nums[l] > p

     while (low <= h && nums[h] > p) {
     h--;
     }  // to find nums[h] < p

     if (l < h) swap(nums, l, h);
     }

     swap(nums, low, h);

     return l;
     }

     public void swap(int[] nums, int i, int j) {
     int tmp = nums[i];
     nums[i] = nums[j];
     nums[j] = tmp;
     }
     */
}
