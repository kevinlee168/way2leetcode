package leetcode.Java;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Merge_Sorted_Array_88 {
    /**
     * 思路：同时从 nums1 和 nums2 的需要排序的末尾元素开始往前遍历对比
     * 将较大的那个元素存入到 num1 的 "最后一个"值为 0 的元素位置
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m < 0 || n <= 0 || nums1.length < n) return;

        int p1 = m - 1;
        int p2 = n - 1;
        //指向 nums1 的末尾
        int p = m + n - 1;

        //将 nums1，nums2 中较大到元素依次存入到 nums1[p]==0 的元素位置上
        while (p >= 0 && nums1[p] == 0 && p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
            }
            // nums1[p1] >= nums2[p2]
            else {
                nums1[p] = nums1[p1];
                nums1[p1] = 0;
                p1--;
            }
            p--;
        }

        //如果 p2 >= 0，说明 nums2 中还有元素未复制到 nums1中，继续复制即可
        if (p2 >= 0) {
            while (p >= 0 && nums1[p] == 0 && p2 >= 0) {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }
        }

//        if (m < 0 || n <= 0 || nums1.length < n) return;
//
//        //m == 0 的情况，即nums1前面部分的元素为0个，只需要将 nums2 的元素都复制到 nums1 中即可
//        if (m == 0) {
//            for (int i = 0; i < n; i++) nums1[i] = nums2[i];
//            return;
//        }
//
//        int p1 = m - 1;
//        int p2 = n - 1;
//        //指向 nums1 的末尾
//        int p = m + n - 1;
//
//        while (p1 >= 0 && p2 >= 0) {
//            if (nums1[p1] < nums2[p2]) {
//                nums1[p] = nums2[p2];
//                p2--;
//            }
//            else {
//                nums1[p] = nums1[p1];
//                if (p1 == 0) {
//                    nums1[p1] = nums2[p2];
//                }
//                p1--;
//            }
//            p--;
//        }
//
//        //如果这种情况出现，说明p1 < 0; nums2中还有元素为复制到nums1中。
//        //所以，需要直接将 nums2 中的元素按顺序复制到 nums1 中
//        if (p2 > 0) {
//            while (p2 >= 0) {
//                nums1[p] = nums2[p2];
//                p--;
//                p2--;
//            }
//        }

    }
}
