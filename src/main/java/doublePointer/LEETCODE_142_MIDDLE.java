package doublePointer;


/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-02 12:46
 */
public class LEETCODE_142_MIDDLE {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) {
            return null;
        } else {
            ListNode temp = dummy;
            while (temp != slow) {
                temp = temp.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
