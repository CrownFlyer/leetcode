package exer.leetcode.week270;

class Solution2 {

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

    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        int n = 0;
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        ListNode fast = head;
        ListNode slow = dummy;
        int cnt = n / 2;
        while (cnt > 0) {
            fast = fast.next;
            slow = slow.next;
            cnt--;
        }
        slow.next = fast.next;
        return dummy.next;
    }
}