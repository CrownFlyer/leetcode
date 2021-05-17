package sort;

import org.junit.Test;

import java.util.Collections;


/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-22 16:20
 */
public class LEETCODE_147_MIDDLE {
    @Test
    public void test() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println(insertionSortList(head));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(0,head);

        ListNode sortedLastNode = head; // store the last node of the sorted list( max )
        ListNode cur;
        while (sortedLastNode.next != null) {
            cur = sortedLastNode.next;
            if (cur.val > sortedLastNode.val) {
                sortedLastNode = sortedLastNode.next;
            } else {
                ListNode prev = dummyNode;
                ListNode search = dummyNode.next;
                while (search.val < cur.val) {
                    prev = prev.next;   // 找到位置的前一个
                    search = search.next;   // 找到位置的后一个
                }
                sortedLastNode.next = cur.next;
                prev.next = cur;
                cur.next = search;
            }
        }
        return dummyNode.next;
    }

}
