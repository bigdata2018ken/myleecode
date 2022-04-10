package leetcode.editor.cn.basic;

import leetcode.editor.cn.ListNode;

public class 链表实现队列 {

    private ListNode head;

    private ListNode tail;


    public void enqueue(Integer item) {
        ListNode node = new ListNode(item);
        if (head == null) head = node;
        if (tail == null) tail = node;
        // 队尾
        tail.next = node;
        tail = tail.next;
    }

    public ListNode dequeue() {
        if (head == null) return null;
        ListNode top = head;
        head = head.next;
        return top;
    }
}
