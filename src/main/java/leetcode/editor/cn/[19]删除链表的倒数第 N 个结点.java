package leetcode.editor.cn;//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1753 👎 0


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
class Solution19 {
    public  ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        // 指针1：处理链表的长度
        int length = 0;
        ListNode currentNode1 = head;
        while (currentNode1 != null){
            ++length;
            currentNode1 = currentNode1.next;
        }
        // 特殊情况处理, 超过链表长度时
        if (n > length) {
            return head;
        }
        if (n == length) {
            return head.next;
        }
        // 指针2：正向遍历
        //正向遍历 删除倒数第n个 -> 删除 正向 length - n
        int nodeNo = 1;
        ListNode currentNode2 = head;
        while (nodeNo < length - n ) {
            currentNode2 = currentNode2.next;
            nodeNo ++;
        }
        // 将指针2 指向 length - n + 1的 next
        currentNode2.next = currentNode2.next.next;

        return head;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
