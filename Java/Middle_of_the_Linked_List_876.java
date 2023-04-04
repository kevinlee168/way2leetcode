package leetcode.Java;

/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
 */
public class Middle_of_the_Linked_List_876 {
    /*
      使用快慢指针
    */
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        //不管是fast == null 还是 fast.next == null，循环停止时的slow指针即为所要找的中间指针
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
