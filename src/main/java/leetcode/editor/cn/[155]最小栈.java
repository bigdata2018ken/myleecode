package leetcode.editor.cn;//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 👍 1159 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    //用于检索的最小栈, 用于存储元素的最小值
    private final Stack<Integer> minStack;
    private final Stack<Integer> realStack;

    public MinStack() {
        realStack = new Stack<>();
        minStack = new Stack<>();
        // 初始化一个最大值，或者在push时使用null判断
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 每一个入栈的元素需要与minStack栈顶元素比较
     */
    public void push(int val) {
        realStack.push(val);
        Integer topMin = minStack.peek();
        if (topMin > val) {
            minStack.push(val);
        } else {
            minStack.push(topMin);
        }
    }

    // 需要将minStack 也一并取出
    public void pop() {
        realStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return realStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
