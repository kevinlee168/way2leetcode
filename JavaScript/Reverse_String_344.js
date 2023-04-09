/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
/**
 * Method:
 *  Use two index (start = 0, end = s.length - 1) to visit the list from the begin and end.
 *  Switch each element until start > end
 */
var reverseString = function(s) {
    if (s == null || s.length <= 1) return;

    let start = 0;
    let end = s.length - 1;

    let tmp;
    while (start <= end) {
        tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
        start++;
        end --;
    }
};