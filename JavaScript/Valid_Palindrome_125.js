/**
 * @param {string} s
 * @return {boolean}
 */

/**
 * Method:
 *  Step-1: Remove all non-alphanumeric characters
 *  Step-2: Check whether the new string is a palindrome.
 */
var isPalindrome = function(s) {
    if (s == null) return false;
    if (s.length <= 1) return true;

    const regex = new RegExp('[^0-9A-Za-z]', 'g');
    let str = s.toLowerCase().replaceAll(regex, '');
    console.log(str);

    if (str.length <= 1) return true;

    let left = 0;
    let right = str.length - 1;
    while (left <= right) {
        if (str[left] !== str[right]) return false;
        left++;
        right--;
    }

    return true;
};

const s = " ";
console.log(isPalindrome(s));