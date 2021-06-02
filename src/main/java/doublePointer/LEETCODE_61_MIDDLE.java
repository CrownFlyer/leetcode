package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-01 11:25
 */
public class LEETCODE_61_MIDDLE {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        System.out.println(rotateRight(head, 0));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 0;
        ListNode cur = head;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }
        size++;
        if (size == 0) return cur;

        k %= size;
        ListNode formerTail = head;
        int temp_k = size - k - 1;
        while (temp_k != 0) {
            formerTail = formerTail.next;
            temp_k--;
        }
        ListNode latterHead = formerTail.next;
        formerTail.next = null;
        cur = latterHead;
        if (cur == null) return head;
        while (cur.next != null) cur = cur.next;
        cur.next = head;
        return latterHead;
    }


}

