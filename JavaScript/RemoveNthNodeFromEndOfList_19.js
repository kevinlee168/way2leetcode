/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Q: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     思路：使用fast、slow节点;
     首先，让fast节点先前进n个节点；
     然后，fast和slow同时同节奏向前移动。 当fast.next == null时，slow.next 指向倒数第 n 个节点。
     最后，找到了删除即可: slow.next = slow.next.next。
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if (head == null || n <= 0) return head;

    let fast = head;
    let slow = head;

    // 让fast节点先前进n个节点
    let i = 0;
    while(fast != null && i < n) {
        fast = fast.next;
        i++;
    }

    // if fast == null; 那么，表示节点个数 < n
    if (fast == null) {
        head = head.next;
        return head;
    }

    // fast和slow同时同节奏向前移动。 当fast.next == null时，slow.next 指向倒数第 n 个节点
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }

    // 删除倒数第 n 个节点
    slow.next = slow.next.next;

    return head;
};