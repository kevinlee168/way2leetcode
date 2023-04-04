package leetcode.Java;

import java.util.PriorityQueue;

public class Merge_K_SortedLists_23 {
    /*
        使用优先级队列的 最小堆： 堆顶的值最小。
        每次插入新值后，优先级队列自动保持堆顶的元素值最小。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        //使用优先级队列的 最小堆： 堆顶的值最小
        //注意lambda表达的comparator：(a, b) -> (a.val - b.val)  // a < b
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        //将各个链表的【表头节点】加入到优先级队列中
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }

        //边遍优先级队列，边添加、删除节点.
        while (pq.size() != 0) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;

            //如果node节点不是末尾节点，就将其后一个节点添加到pq中
            if (node.next != null){
                pq.add(node.next);
            }
            //p指针往后移动
            p = p.next;
        }

        //返回值需要先后移一个指针
        return dummy.next;
    }

}



