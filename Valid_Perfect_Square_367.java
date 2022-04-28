package leetcode;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Follow up: Do not use any built-in library function such as sqrt.
 */
public class Valid_Perfect_Square_367 {
    /**
     * 思路：先用num / 2 设定一个数组遍历的范围
     * 然后，利用二分查找，遍历寻找【1...num/2】这个范围内是否存在某个数 mid： mid * mid == num
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        if (num <= 0) return false;

        int max = num / 2;
        if (max <= 1) return false;

        // 下面是二分查找思路
        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            long square = mid * mid;

            if (square < num) left = mid + 1;
            else if (square > num) right = mid - 1;
            else {
                System.out.println("mid: " + mid);
                return true;
            }
        }

        return false;
    }
}
