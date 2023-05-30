package leetcode.Java;

/**
 * Created by Kevin Lee on 5/30/23
 * Method:
 *  To iterate the string s from end to start:
 *      the initial sum = 0;
 *      to add each 'number' of the first to sum if first >= second;
 *      to subtract the 'number' of the first from sum if first < second;
 *      ...
 *      Last, return sum.
 */
public class Roman_to_Integer_13 {
    public int romanToInt(String s) {
        int sum = 0, first = 0, second = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I': first = 1; break;
                case 'V': first = 5; break;
                case 'X': first = 10; break;
                case 'L': first = 50; break;
                case 'C': first = 100; break;
                case 'D': first = 500; break;
                case 'M': first = 1000; break;
            }

            if (first < second) {
                sum -= first;
            } else {
                sum += first;
            }
            second = first;
        }

        return sum;
    }
}
