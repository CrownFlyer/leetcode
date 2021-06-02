package doublePointer;

import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-01 14:25
 */
public class LEETCODE_234_SIMPLE {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        LEETCODE_234_SIMPLE test = new LEETCODE_234_SIMPLE();
        System.out.println(test.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow = head, fast = head;
        //pre 记录前半段的翻转链表，prepre记录构造翻转链表过程的中间链表
        // 空间复杂度:O(n)
        ListNode pre = head, prepre = null;
        // 快指针走到末尾，慢指针刚好到中间。
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 头插法 逆转链表
            pre.next = prepre;
            prepre = pre;
        }
        if(fast!=null) slow = slow.next;
        while(pre!=null && slow != null){
            if(pre.val!=slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
