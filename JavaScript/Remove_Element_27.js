/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
/**
 * Method:
 *  Use two indexs : p1 = 0, p2 = nums.length - 1 to solve the problem.
 */
var removeElement = function (nums, val) {
    if (nums == null || nums.length === 0) return 0;

    if (nums.length === 1 && nums[0] === val) return 0;

    let p1 = 0;
    let p2 = nums.length - 1;
    let k = 0;
    while (p1 <= p2) {
        while (p1 < nums.length && nums[p1] !== val) {  // make p1 point to the element nums[p1] === val
            p1++;
            k++;
        }
        while (p2 >= 0 && nums[p2] === val) { // make p2 point to the element nums[p2] !== val
            p2--;
        }
        if (p1 < p2 && nums[p1] === val) {
            const n = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = n;
            p1++;
            p2--;
            k++;
        }
    }

    return k;
};