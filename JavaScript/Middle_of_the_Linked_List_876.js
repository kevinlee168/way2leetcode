/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

/**
 * Method: use fast and slow node to visit the list. fast = fast.next.next; slow = slow.next
 *       When the fast == null or fast.next == null, then the slow is the node that need to find.
 */
var middleNode = function(head) {
    if (head == null || head.next == null) return head;

    let slow = head;
    let fast = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }

    return slow;
};