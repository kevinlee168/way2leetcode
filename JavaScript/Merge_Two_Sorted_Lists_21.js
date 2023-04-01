/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    if (list1 == null ) return list2;
    if (list2 == null) return list1;

    let head;
    let p1 = list1;
    let p2 = list2;
    if (p1.val <= p2.val) {
        head = p1;
        p1 = p1.next;
    }
    else {
        head = p2;
        p2 = p2.next;
    }

    let index = head;
    while (p1 != null && p2 != null) {
        if (p1.val <= p2.val) {
            index.next = p1;
            p1 = p1.next;
        }
        else {
            index.next = p2;
            p2 = p2.next;
        }
        index = index.next;
    }

    if (p1 != null) {
        index.next = p1;
    }
    if (p2 != null) {
        index.next = p2;
    }

    return head;
};