package heap;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-08 21:16
 */
public class LEETCODE_23_HARD {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[1];
        lists[0] = new ListNode(1);
        LEETCODE_23_HARD test = new LEETCODE_23_HARD();
        System.out.println(test.mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        int n = lists.length;

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(lists[i]==null){
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if(lists[i]!=null){
                q.offer(new int[]{lists[i].val, i});
                lists[i] = lists[i].next;
            }
        }
        // 当遍历完一个链表的时候cnt++，直到遍历完所有链表

        ListNode res = new ListNode();
        ListNode temp = res;

        while (cnt < n) {
            int[] e = q.poll();
            temp.next = new ListNode(e[0]);
            temp = temp.next;

            int index = e[1];
            if (lists[index] != null) {
                q.offer(new int[]{lists[index].val, index});
                lists[index] = lists[index].next;
            } else cnt++;

        }
        return res.next;
    }


    public static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
