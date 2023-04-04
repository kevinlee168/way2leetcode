package leetcode.Java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 *
 * 思路：利用HashSet 和 左右指针
 * 首先，将10个vowels字符存入一个hashSet中；
 * 然后，利用left、right双指针遍历数组：分情况将字符存入到左右2部分到StringBuilder对象中。
 * 注意：后部分的字符串会以逆序的形式保存，所以最后需要反转一下。
 */
public class Reverse_Vowels_of_a_String_345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int left = 0;
        int right = s.length() - 1;
        StringBuilder leftStr = new StringBuilder();
        // 后部分的字符串会以逆序的形式保存，所以最后需要反转一下
        StringBuilder rightStr = new StringBuilder();
        while (left <= right && left < s.length() && right >= 0) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            //如果 left、right指向同一个元素了，而且这个元素是元音字符，则加入到前部分字符串中，并终止循环。
            if (left == right && vowels.contains(l)) {
                leftStr.append(l);
                break;
            }

            //左边的字符不是元音字符的情况, 直接把字符保存到 leftStr中
            else if (!vowels.contains(s.charAt(left))){
                leftStr.append(l);
                left++;
            }

            //右边边的字符不是元音字符的情况, 直接把字符保存到 rightStr中
            else if (!vowels.contains(r)){
                rightStr.append(r);
                right--;
            }

            //left、right 指针都指向了元音元素的情况
            else if (vowels.contains(s.charAt(left)) && vowels.contains(s.charAt(right))) {
                leftStr.append(r);
                rightStr.append(l);
                left++;
                right--;
            }
        }

        return leftStr.toString() + rightStr.reverse().toString();
    }
}
