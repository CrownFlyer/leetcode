package linkList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-18 10:36
 */
public class LEETCODE_707_MIDDLE {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0, 1);
        linkedList.addAtIndex(1, 2);
        linkedList.addAtIndex(2, 3);
        linkedList.deleteAtIndex(1);
        linkedList.deleteAtIndex(1);
        linkedList.deleteAtIndex(0);
        linkedList.addAtTail(6);
        linkedList.addAtHead(7);
        linkedList.addAtTail(5);
        System.out.println(linkedList.get(0));
        linkedList.deleteAtIndex(0);
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(0);
        System.out.println(linkedList.get(0));
    }

    static class MyLinkedList {
        Node head;
        Node tail;
        int size;

        class Node {
            int val;
            Node next;
        }

        public MyLinkedList() {
            head = null;
            tail = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            Node cur = head;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            Node dummy = new Node();
            dummy.val = val;
            if (head == null) {
                dummy.next = head;
                head = dummy;
                tail = head;
            } else {
                dummy.next = head;
                head = dummy;
            }
            size++;
        }

        public void addAtTail(int val) {
            if (head == null) {
                head = new Node();
                head.val = val;
                tail = head;
            } else {
                tail.next = new Node();
                tail.next.val = val;
                tail = tail.next;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;
            Node dummy = new Node();
            dummy.next = head;
            Node cur = dummy;
            while (index > 0) {
                if (cur.next != null) cur.val = cur.next.val;
                cur = cur.next;
                index--;
            }
            cur.val = val;
            if (cur.next == null) tail = cur;
            head = dummy;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            Node dummy = new Node();
            dummy.next = head;
            Node cur = dummy;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            // 找到要删除节点的前一个节点
            // 如果要删除的为头节点，head改变
            if (cur == dummy) head = head.next;
            // 如果要删除的是尾节点，tail改变
            if (cur.next.next == null) tail = cur;
            cur.next = cur.next.next;
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
