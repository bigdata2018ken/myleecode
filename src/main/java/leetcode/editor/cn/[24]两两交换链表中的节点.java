package leetcode.editor.cn;//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1346 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution24s {

    public  ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        // 递归交换
        swap(head);
        return res;

    }

    // 1 -> 2 -> 3
    // 1 -> 3, 2 -> 1
    // 2 -> 1 -> 3
    private  ListNode swap(ListNode node) {

        if (node == null ) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        ListNode preNode = swap(node.next.next);
        // 取出 2
        ListNode nextNode = node.next;
        // 1 -> 3
        node.next = preNode;
        // 2 -> 1
        nextNode.next = node;

        return nextNode;

    }

//    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//        System.out.println(swapPairs(node1));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
