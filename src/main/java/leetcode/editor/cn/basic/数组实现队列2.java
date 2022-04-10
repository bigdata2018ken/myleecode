package leetcode.editor.cn.basic;

/**
 * 实现循环队列
 * 线性队列需要在 入队时判断队列是否已满, 还需要频繁移动元素。 如果是循环队列则可以避免移动元素
 * 核心：环形的实现 考虑取模运算
 */
public class 数组实现队列2 {

    private final String[] items;

    private int head = 0;

    private int tail = 0;

    private final int n;

    public 数组实现队列2(int n) {
        items = new String[n];
        this.n = n;
    }

    /**
     * 入队 ： 移动尾指针 tail
     * 问题： 什么时候队列已满  (tail + 1)%n = head => tail 一定小于n,
     * 取模运算 tail%n = tail, 但当处于 边界 tail = n-1 时, 此时 取模后tail复位，即tail = 0，因此实现了环
     */
    public boolean enqueue(String item) {

        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队 : 移动头指针
     */
    public String dequeue() {
        if (tail == head) return null;
        String item = items[head];
        head = (head + 1) % n;
        return item;

    }
}
