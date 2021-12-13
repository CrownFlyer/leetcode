package exer.leetcode.week265;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-31 10:26
 */
public class Section2 {
    @Test
    public void test() {

    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        boolean[] v = new boolean[n];
        ListNode pre = head;
        cur = head.next;
        int i = 1;
        while (cur != null && cur.next != null) {
            if ((cur.val > pre.val && cur.val > cur.next.val) || (cur.val < pre.val && cur.val < cur.next.val))
                v[i] = true;
            i++;
            cur = cur.next;
            pre = pre.next;
        }
        int cnt = 0;
        for (int idx = 0; idx < n; idx++) {

            if (v[idx]) cnt++;
        }
        if (cnt <= 1) return new int[]{-1, -1};

        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MIN_VALUE;
        int idxl = 0, idxr = n - 1;
        while (idxl < n && !v[idxl]) idxl++;
        while (idxr >= 0 && !v[idxr]) idxr--;
        res[1] = idxr - idxl;
        int lastidx = 0;
        while (lastidx < n && !v[lastidx]) lastidx++;
        for (int idxn = lastidx + 1; idxn < n; idxn++) {
            if (v[idxn]) {
                res[0] = Math.min(res[0], idxn - lastidx);
                lastidx = idxn;
            }
        }
        return res;
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
    }
}


