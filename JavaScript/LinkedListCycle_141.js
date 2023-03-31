/*
 Given head, the head of a linked list, determine if the linked list has a cycle in it.

 There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 Note that pos is not passed as a parameter.

 Return true if there is a cycle in the linked list. Otherwise, return false.
 */

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */

/*
   使用fast、slow指针，都向后动指针：fast 每次前进2个节点，slow每次前进1个节点
   如果在移动的过程中，出现fast.next == slow，则表示存在环；
   如果fast.next == null了，则说明不存在环
   */
var hasCycle = function (head) {

    if (head == null) return false;

    let fast = head.next;
    let slow = head;

    while (fast != null && fast.next != null) {
        if (fast == slow || fast.next == slow) return true;

        fast = fast.next.next;
        slow = slow.next;
    }

    return false;
};