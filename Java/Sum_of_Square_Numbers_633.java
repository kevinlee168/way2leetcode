package leetcode.Java;

import java.util.ArrayList;

/**
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * 思路：利用数组中的"左右指针"
 * 首先，取得右边界限：(int) Math.sqrt(c)
 * 然后，用"左右指针"的思维寻找目标元素
 */
public class Sum_of_Square_Numbers_633 {

    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        if (c == 0) return true;

        //注意，0 <= c <= 231 - 1 所以，left、right的类型应该为long，而不是 int。
        //不然会发生溢出而导致结果不准则
        long left = 0;
        long right = (int) Math.sqrt(c);
        long tmp = -1;
        //利用左右指针，寻找等于目标值到2个元素
        while (left <= right) {
            tmp = left * left + right * right;
            if (tmp > c) right--;
            else if (tmp < c) left++;
            else {
                System.out.println(left + " : " + right);
                return true;
            }
        }
        return false;
    }
}
