package leetcode.Java;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("abb"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        String palindrome = "";
        String s1 = null;
        String s2 = null;

        //从字符串第一个字符开始（从左到右）调用找回文的函数，并返回回文
        for (int i = 0; i < len; i++) {
            // the length of the string is 奇数的情况
            s1 = subPalindromic(s, i, i);
            //the length of the string is 偶数
            s2 = subPalindromic(s, i, i + 1);
            String res = s1.length() > s2.length() ? s1 : s2;
            if (palindrome.length() < res.length()) {
                palindrome = res;
            }
        }
        return palindrome;
    }

    /**
     *   从字符串中间位置(l,r)向左右扩展，寻找回文
     */
    public static String subPalindromic(String s, int l, int r) {
        if (s == null || s.length() <= 1 ) {
            return s;
        }

        int len = s.length();
        //注意防止索引越界
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
