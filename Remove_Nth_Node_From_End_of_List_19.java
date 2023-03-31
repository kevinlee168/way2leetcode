package leetcode;

/**
  Q: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
  思路：使用fast、slow节点;
  首先，让fast节点先前进n个节点；
  然后，fast和slow同时同节奏向前移动。 当fast.next == null时，slow.next 指向倒数第 n 个节点。
  最后，找到了删除即可: slow.next = slow.next.next。
  特例：如果在fast前进 n 个节点的过程中出现 if fast == null; 那么，表示节点个数 < n。 这种情况下，一般要删除头节点，可以画图测试发现。
 */
public class Remove_Nth_Node_From_End_of_List_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;
        int i = 0;

        ListNode slow = head;
        ListNode fast = head;
        //首先，尝试让fast前进n个节点
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        //if fast == null; 那么，表示节点个数 < n。 这种情况下，一般要删除头节点，可以画图测试发现。
        if (fast == null) {
            head = head.next;
            return head;
        }

        //if fast != null; 那么，表示节点个数 >= n
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除倒数第 n 个节点
        slow.next = slow.next.next;
        return head;
    }
}
