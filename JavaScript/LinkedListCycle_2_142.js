/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */

// 注意：即使存在环，【相遇点】不一定是【环的起点】
/*
    首先，使用快慢指针，确定是否存在环； 如不存在，程序运行结束；
    接着，如果存在，则将（slow、fast）其中一个指向头节点，一个指向相遇节点。
    同时、同节奏向前移动，当slow、fast指针再次相遇时，即为环的入口节点
    */
var detectCycle = function(head) {
    if (head === null || head.next === null) return null;

    let fast = head;
    let slow = head;
    let flag = false;

    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast === slow) {
            flag = true;
            break;
        }
    }

    if (flag) {
        // fast = slow;
        slow = head;
        while( fast !== slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    } else {
        return null;
    }
};