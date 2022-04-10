package leetcode.editor.cn;//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 213 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution25 {

    /**
     * 本题还是 f(n) = f(n-1) + 处理逻辑
     * 处理逻辑 由 l1 或者 l2 决定 连接 f(n-1) 的结果
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
        }

        return l1.val > l2.val ? l2 : l1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
