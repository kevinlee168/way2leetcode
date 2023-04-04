package leetcode.Java;

import java.util.Arrays;

public class ReverseString2_541 {
    public static void main(String[] args) {
        String str = "abcdefg";
        String res = stringReverse(str, 1);
        System.out.println(res);
    }

    /**
     * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
     *
     * If there are fewer than k characters left, reverse all of them.
     * If there are less than 2k but greater than or equal to k characters,
     * then reverse the first k characters and leave the other as original.
     */
    public static String stringReverse(String s, int k) {
        if (s == null || s.length() == 1 || k == 1) {
            return s;
        }

        StringBuilder newStr = new StringBuilder();
        if (s.length() < k) {
            newStr.append(reverseSubString(s.substring(0, s.length()), k));
        }
        else {
            //Here s.length() >= k
            int i = 0;
            //i * 2k
            int start = i * 2 * k;
            //i * 2k + 2k
            int end = i * 2 * k + 2 * k;

            while (end < s.length()) {
                newStr.append(reverseSubString(s.substring(start, end), k));
                i++;
                start = i * 2 * k;
                end = i * 2 * k + 2 * k;

            }
            if (s.length() - start <= 2 * k) {
                newStr.append(reverseSubString(s.substring(start, s.length()), k));
            }

        }
        return newStr.toString();
    }

    public static String reverseSubString(String substring, int k) {
        if (substring == null) {
            return null;
        }
        char[] s = substring.toCharArray();
        StringBuilder str = new StringBuilder();

        //左右双指针，相向而行，同时交换值。
        if (s.length == 0 || s.length == 1) {
            for (char c : s) {
                str.append(c);
            }
            return str.toString();
        }

        int left = 0;
        int right = k >= s.length ? s.length - 1 : k - 1;

        //when left >= right, stop the loop
        while (left < right) {
            System.out.println("left: " + left + ", right: " + right);
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }

        for (char c : s) {
            str.append(c);
        }

        return str.toString();
    }
}
