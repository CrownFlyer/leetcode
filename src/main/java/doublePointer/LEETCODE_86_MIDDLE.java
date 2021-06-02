package doublePointer;

import org.junit.Test;

import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-01 11:25
 */
public class LEETCODE_86_MIDDLE {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
        System.out.println(partition(head, 3));
    }

    public static ListNode partition1(ListNode head, int x) {
//        if(head==null) return null;
        ListNode newhead = null;
        ListNode cur = head;
        ListNode newcur = null;
        while (cur != null) {
            if (cur.val < x) {
                if (newhead == null) {
                    newcur = new ListNode(cur.val);
                    newhead = newcur;
                } else {
                    newcur.next = new ListNode(cur.val);
                    newcur = newcur.next;
                }
            }
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                if (newhead == null) {
                    newcur = new ListNode(cur.val);
                    newhead = newcur;
                } else {
                    newcur.next = new ListNode(cur.val);
                    newcur = newcur.next;
                }
            }
            cur = cur.next;
        }
        return newhead;

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode large = null;
        ListNode small = null;
        ListNode curSmall = null;
        ListNode curLarge = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (small == null) {
                    small = new ListNode(cur.val);
                    curSmall = small;
                } else {
                    curSmall.next = new ListNode(cur.val);
                    curSmall = curSmall.next;
                }
            } else {
                if (large == null) {
                    large = new ListNode(cur.val);
                    curLarge = large;
                } else {
                    curLarge.next = new ListNode(cur.val);
                    curLarge = curLarge.next;
                }
            }
            cur = cur.next;
        }
        if (curSmall == null) return large;
        curSmall.next = large;
        return small;
    }


}

