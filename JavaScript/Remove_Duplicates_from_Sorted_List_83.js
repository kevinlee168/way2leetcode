/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Method:
 *  Use two node: slow and fast
 */
var deleteDuplicates = function(head) {
    if (head == null || head.next == null) return head;

    let slow = head;
    let fast = head.next;
    while (fast != null) {
        if (slow.val === fast.val) {
            // to delete the node with same val.
            slow.next = fast.next;
        } else {
            slow = slow.next;
        }
        fast = fast.next;
    }

    return head;
};