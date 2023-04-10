/**
 * @param {string} s
 * @return {boolean}
 */
/**
 * Method:
 *  Use two index (start, end) to compare the value from the start and end of the list,
 *  When s[start] != s[end] && start > end && flag = 0, to check the two substring of s is Palindrome.
 */
var validPalindrome = function(s) {
    if (s == null || s.length === 0) return false;

    let start = 0;
    let end = s.length - 1;
    let flag = 0;
    while (start <= end) {
        if (s[start] === s[end]) {
            start++;
            end--;
        } else { // s[start] != s[end]
            if (flag === 0) {
                flag = 1;
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            else
                return false;
        }
    }

    return end < start;
};

function isPalindrome(s, start, end) {
    if (s == null || s.length === 0) return false;

    while (start <= end && s[start] === s[end]) {
        start++;
        end--;
    }
    return start > end;
}
