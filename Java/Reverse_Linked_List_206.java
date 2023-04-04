package leetcode.Java;

import leetcode.Java.ListNode;

public class Reverse_Linked_List_206 {
    /**
     * 思路：思路：一遍遍历链表，一遍使用头插法将节点插入到新链表中
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode();
        newHead.next = null;
        ListNode p;

        //头插法
        while (head != null) {
            p = head;
            // 先把原链表的头节点往后移动
            head = head.next;
            //头插法
            p.next = newHead.next;
            newHead.next = p;
        }

        return newHead.next;
    }
}
