package leetcode;

public class ReverseString_344 {
    public static void main(String[] args) {
        char[] s1 = {'h', 'e','l', 'l', 'o'};
        char[] s2 = {};
        char[] s3 = {'a'};
        char[] s4 = {'a','b'};
        reverseString(s1);
        reverseString(s2);
        reverseString(s3);
        reverseString(s4);
    }

    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     */
    //利用左右指针，相向而行，同时交换值。
    public static void reverseString(char[] s) {
        System.out.println("length: " + s.length);
        if (s == null || s.length == 0 || s.length == 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }

        for (char c : s) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }
}
