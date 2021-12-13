package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-22 09:51
 */
public class LEETCODE_725_MIDDLE {
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

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        ListNode[] res = new ListNode[k];

        ListNode fast = head;
        ListNode slow;
        for (int i = 0; i < k; i++) {
            int cnt = (n + k - 1 - i) / k;
            ListNode start = fast;
            slow = start;
            while (cnt > 0 && fast != null) {
                fast = fast.next;
                if (cnt == 1) {
                    slow.next = null;
                    break;
                }
                slow = slow.next;
                cnt--;

            }

            res[i] = start;
        }
        return res;
    }
}
