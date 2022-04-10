package leetcode.editor.cn;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 241 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution06 {

    // 公式：f(n) = f(n-1) + ( res.add(node.val) )
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        print(head, res);

        int size = res.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = res.get(i);
        }
        return ints;

    }

    private void print(ListNode node, List<Integer> res) {
        if (node == null) return;
        print(node.next, res);
        res.add(node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
