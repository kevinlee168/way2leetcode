package leetcode.Java;

import java.util.regex.Pattern;

/**
 * Method:
 *  Step-1: Remove all non-alphanumeric characters
 *  Step-2: Check whether the new string is a palindrome.
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;

        String res = s.toLowerCase().replaceAll("[^0-9A-Za-z]", "");
        if (res.length() <= 1) return true;

        int left = 0;
        int right = res.length() - 1;
        while (left <= right) {
            if (res.charAt(left) != res.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    /**
     * Method:
     *  Use two point (left, right) to compare the value.
     *  if the value of the char is not an alphabetic or digit, then ignore it.
     */
    public boolean isPalindrome2(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;

        String str = s.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            while (left < str.length() && !Character.isLetterOrDigit(str.charAt(left))) left++;
            while (0 <= right && !Character.isLetterOrDigit(str.charAt(right))) right--;

            if (left < str.length() && right >= 0) {
                if (str.charAt(left) != str.charAt(right)) return false;
                else {
                    left++;
                    right--;
                }
            }
            else return true;
        }

        return true;
    }
}