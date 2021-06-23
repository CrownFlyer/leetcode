package linkList;

import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-18 11:45
 */
public class LEETCODE_148_MIDDLE {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        LEETCODE_148_MIDDLE test = new LEETCODE_148_MIDDLE();
        System.out.println(test.sortList(head));
    }

    // O(n^2) O(1)
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        ListNode dummy = new ListNode(-1, head);
        while (fast != null) {
            if (fast.val < slow.val) {
                int insertValue = fast.val;
                ListNode cur = dummy;
                while (cur.next.val < fast.val) cur = cur.next;
                slow.next = fast.next;
                fast = fast.next;
                cur.next = new ListNode(insertValue, cur.next);
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 先计算链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(-1, head);
        for (int subLength = 1; subLength < len; subLength <<= 1) {
            ListNode slow = dummy, fast = dummy.next;
            while (fast != null) {
                ListNode l1 = fast;
                for (int i = 1; i < subLength && fast.next != null; i++) {
                    fast = fast.next;
                }
                ListNode l2 = fast.next;
                fast.next = null;   // 截断l1
                fast = l2;
                for (int i = 1; i < subLength && fast != null; i++) {
                    fast = fast.next;
                }
                ListNode tempNext = null;   //暂存l2后面的链表
                if (fast != null) {
                    tempNext = fast.next;
                    fast.next = null;
                }

                ListNode merged = mergeTwoLists(l1, l2);
                // 将排序好的结果拼接到原链表最后
                slow.next = merged;
                // 将原链表的指针定位到尾节点
                while (slow.next != null) {
                    slow = slow.next;
                }
                fast = tempNext;
            }
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
