package leetcode;

import java.util.Stack;

public class Intersection_of_Two_Linked_Lists_160 {
    /**
      Q: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
      If the two linked lists have no intersection at all, return null.
      思路：利用2个Stack：
      首先，分别遍历A、B两个链表，同时把每个链表的节点都push到相应到stackA、stackB。
      然后，同节奏pop stackA、stackB，同时比较pop出都节点是否相等。
      如果，stack顶都不相等，说明A、B链表不相交；
      如果，出现了相等都节点，当第一次出现不相等节点都都时候的【上一个节点】即为相交的节点。
     */
    public ListNode getIntersectionNode_2_(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        //遍历A、B两个链表，同时把每个链表的节点都push到相应到stackA、stackB。
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }

        //用于保存相交的节点
        ListNode intersect = null;
        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()) {
            intersect = stackA.pop();
            stackB.pop();
        }

        return intersect;
    }

    /**
     * 用两个指针 p1 和 p2 分别在两条链表上前进,
     * 让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，
     * 这样相当于「逻辑上」两条链表接在了一起。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;

            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }

        return p1;
    }
}
