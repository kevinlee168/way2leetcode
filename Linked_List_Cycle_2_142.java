package leetcode;

public class Linked_List_Cycle_2_142 {

    //注意：即使存在环，【相遇点】不一定是【环的起点】
    /*
       首先，使用快慢指针，确定是否存在环； 如不存在，程序运行结束；
       接着，如果存在，则将（slow、fast）其中一个指向头节点，一个指向相遇节点。
       同时、同节奏向前移动，当slow、fast指针再次相遇时，即为环的入口节点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        //标记是否存在环
        boolean flag = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //存在环，就在fast、slow指针相遇的节点，跳出终止循环
            if (slow == fast){
                flag = true;
                break;
            };
        }

        if (flag) {
            //如果找到了slow、fast指针的相遇点，则将其中一个指向头节点，一个指向相遇节点
            //同时、同节奏向前移动，当slow、fast指针再次相遇时，即为环的入口节点
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null;
    }

}
