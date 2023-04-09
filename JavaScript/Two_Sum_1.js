/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

/**
 * Method:
 *  Use a map(nums[i], i) to store the value and its index.
 *  Then to iterate the list to check if the diff (target - nums[i]) in the map;
 *  If find the (k, v) in the map, then return the two index;
 */
var twoSum = function(nums, target) {
    if (nums == null || nums.length === 0) return nums;

    let mp = new Map();

    for (let i = 0; i < nums.length; i++) {
        let diff = target - nums[i];

        if (mp.has(diff)) {
            return [i, mp.get(diff)];
        }

        mp.set(nums[i], i);
    }

};