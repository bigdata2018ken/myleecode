package leetcode.editor.cn.basic;

public class 数组实现队列 {

    private final String[] items;

    private int head = 0;

    private int tail = 0;

    private final int size;

    public 数组实现队列(int size) {
        items = new String[size];
        this.size = size;
    }

    /**
     * 入队 ： 移动尾指针
     * 问题：由于是操作尾指针，当尾指针 tail == size 时, 如果head == 0 时才表示 数组满了; 否则需要移动数组中的元素
     */
    public boolean enqueue(String item) {
        if (tail == size) {
            if (head == 0) {
                return false;
            }
            // 移动 [head, tail] -> [0, size-head]
            for (int i = head; i < size ; i++) {
                items[i-head] = items[head];
            }
            tail -= head; head = 0;
        }
        items[tail++]= item;
        return true;
    }

    /**
     * 出队 : 移动头指针
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];


    }
}
