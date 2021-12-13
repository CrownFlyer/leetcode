package exer.leetcode.week267;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-14 16:55
 */
public class Section2 {

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

    class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {
            ListNode dummy = new ListNode(-1, head);
            ListNode cur = dummy;
            ListNode first = cur;
            int step = 1;
            while (cur.next != null) {
                int curStep = 0;
                List<Integer> list = new ArrayList<>();
                // cur = first;
                while (cur.next != null && curStep < step) {
                    list.add(cur.next.val);
                    curStep++;
                    cur = cur.next;
                }

                if (list.size() % 2 == 0) {
                    int idx = list.size() - 1;
                    while (idx >= 0) {
                        first.next = new ListNode(list.get(idx--));
                        first = first.next;
                    }
                    first.next = cur.next;
                } else {
                    int idx = 0;
                    while (idx < list.size()) {
                        first.next = new ListNode(list.get(idx++));
                        first = first.next;
                    }
                    first.next = cur.next;
                }
                step++;
            }
            return dummy.next;
        }
    }
}
