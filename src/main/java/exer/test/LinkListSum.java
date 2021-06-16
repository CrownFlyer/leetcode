package exer.test;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-14 15:49
 */
public class LinkListSum {
    @Test
    public void test() {
        LinkListSum test = new LinkListSum();
        ListNode l1 = new ListNode(0);
//        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(0);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        System.out.println(test.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = carry;
            if(l1!=null) {
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            carry = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
        }
        if(carry!=0) cur.next = new ListNode(carry);

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
