package leetcode.Java;

/**
 * Q: Given a string s, return true
 * if the s can be palindrome after deleting at most one character from it.
 */
public class Valid_Palindrome_2_680 {
    /**
     * 思路： 1. 正序，使用left, right 左右指针，相向而行，判断元素是否相等；逆序，
     * 1）如果 left == right 了，说明存在回文 （原字符串就是一个回文）
     * 2）如果 left == right - 1了，这种情况，随便删除一个字符，字符串就是回文了。
     * 3）如果 在 left 达到 right - 1 or right 的过程中出现左右元素不相等，即不是回文。
     * 2. 如果正序，结果为false，则在对逆序的字符串进行同样的操作比较。如果，逆序操作的结果为true，那也就是存在回文。
     */

    public boolean validPalindrome(String s) {
        //先正序操作，如果正序结果为true，逆序操作就不用进行了，直接返回true
        if (isPalindrome(s) || isPalindrome(new StringBuilder(s).reverse().toString())) return true;
        //正序、逆序操作结果都为false，返回false
        else return false;
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;
        int num = 0;
        while (left <= right) {
            System.out.println(left + " : " + right);
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else if (num == 0 && left + 1 < s.length() && s.charAt(left + 1) == s.charAt(right)) {
                left = left + 2;
                right--;
                num++;
            }
            else if (num == 0 && right - 1 >= 0 && s.charAt(left) == s.charAt(right - 1)) {
                left++;
                right = right - 2;
                num++;
            }
            else break;
        }

        if (left >= right || left == right - 1) return true;
        return false;
    }
}
