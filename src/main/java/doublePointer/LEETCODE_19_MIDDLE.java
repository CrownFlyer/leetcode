package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-02 11:23
 */
public class LEETCODE_19_MIDDLE {


    // 暴力：两次遍历
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int cnt = 0;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        cnt -= n + 1;
        cur = dummy;
        while (cnt != 0) {
            cur = cur.next;
            cnt--;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    // 双指针：一次遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
