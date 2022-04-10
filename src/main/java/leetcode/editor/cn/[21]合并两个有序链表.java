package leetcode.editor.cn;////将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
////
//// 
////
//// 示例 1： 
////
//// 
////输入：l1 = [1,2,4], l2 = [1,3,4]
////输出：[1,1,2,3,4,4]
//// 
////
//// 示例 2： 
////
//// 
////输入：l1 = [], l2 = []
////输出：[]
//// 
////
//// 示例 3： 
////
//// 
////输入：l1 = [], l2 = [0]
////输出：[0]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 两个链表的节点数目范围是 [0, 50] 
//// -100 <= Node.val <= 100 
//// l1 和 l2 均按 非递减顺序 排列 
//// 
//// Related Topics 递归 链表 👍 2143 👎 0
//


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 依次比较两个ListNode, 重新添加到新的ListNode上
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        // 添加哨兵节点
        ListNode head = new ListNode();
        ListNode current = head;
        while (list1 != null && list2 != null) {
           current = current.next == null ? current : current.next;

            if (list1.val < list2.val) {
                //向合并后的链表添加节点
                current.next = list1;
                // 移动小的节点到后继节点
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
        }

        // 处理剩下未合并的 节点
        if (list1 == null) {
            current=current.next;
            current.next = list2;
        }
        if (list2 == null) {
            current=current.next;
            current.next = list1;
        }
        return head.next;
    }

}






//leetcode submit region end(Prohibit modification and deletion)
