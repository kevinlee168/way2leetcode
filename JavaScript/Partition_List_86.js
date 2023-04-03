/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
/**
 * Method:
 *  Step 1: According to the value x, partion the list into two sublist:
 *      left: all value of the nodes are small or equal to x;
 *      right: all value of the nodes are larger than x;
 *  Step 2:
 *      Link the linklist right to the end of the linklist left.
 *      Make the end of the right is null.
 *
 *  Step 3:
 *      Return linklist left.next;
 */
var partition = function(head, x) {
    if (head == null || head.next == null) return head;

    let left = new ListNode(-1, null);
    let right = new ListNode(-1, null);

    let leftTail = left;
    let rightTail = right;

    while (head != null) {
        if (head.val < x) {
            leftTail.next = head;
            leftTail = leftTail.next;
        } else {
            rightTail.next = head;
            rightTail = rightTail.next;
        }
        head = head.next;
    }

    leftTail.next = right.next;
    rightTail.next = null;

    return left.next;
};