/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if (nums == null || nums.length === 0) return -1;

    let start = 0;
    let end = nums.length - 1;
    let mid;
    while (start <= end) {
        // 注意：在JavaScript中，使用除法运算符返回一个浮点数，而不是整数。
        // 可以使用 Math 对象的 floor() 方法来模拟整数除法。
        // floor() 方法返回小于或等于一个给定数字的最大整数，因此可以用来完成整数除法。
        mid = Math.floor((start + end) / 2);
        if (nums[mid] === target) return mid;
        else if (nums[mid] < target) start = mid + 1;
        else end = mid - 1;
    }

    return -1;
};