/**
 * Method:
 *  Use two index (slow, fast).
 *  Using fast to find the element that nums[fast] != 0, then swap its value with the value of slow.
 */
var moveZeroes = function(nums) {
    if (nums == null || nums.length <= 1) return;

    let slow = 0;
    // Firstly, let the slow point to the element that equals 0;
    while (slow < nums.length && nums[slow] !== 0) slow++;

    let fast = slow + 1;
    while (fast < nums.length) {
        // Swap the element that != 0 with the element 0
        if (nums[fast] !== 0) {
            nums[slow] = nums[fast];
            nums[fast] = 0;
            slow++;
        }
        fast++;
    }
};