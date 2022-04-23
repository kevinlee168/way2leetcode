package leetcode;

public class Linked_List_Cycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        /*
        使用fast、slow指针，都向后动指针：fast 每次前进2个节点，slow每次前进1个节点
        如果在移动的过程中，出现fast.next == slow，则表示存在环；
        如果fast.next == null了，则说明不存在环
        */
        ListNode slow = head;
        ListNode fast = head.next;

        //注意判断条件中需要判断：fast.next != null
        while (fast != null && fast.next != null) {
            if (fast.next == slow || fast == slow) return true;
            //slow前进 1 个节点
            slow = slow.next;
            //fast前进 2 个节点
            fast = fast.next.next;
        }
        return false;
    }
}

