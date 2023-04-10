package leetcode.Java;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Method:
 *  Step 1: According to the value x, partion the list into two sublist:
 *      left: all value of the nodes are small or equal to x;
 *      right: all value of the nodes are larger than x;
 *  Step 2:
 *      Link the linklist right.next to the end of the linklist left.next.
 *      Make the end of the right is null.
 *
 *  Step 3:
 *      Return linklist left.next;
 */
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);

        ListNode leftTail = left;
        ListNode rightTail = right;

        // According to the value x, to partion the list into two sublist
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
    }
}