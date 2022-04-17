package leetcode.editor.cn;//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 47 👎 0


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
class Solution077 {

    public ListNode dumpNode = new ListNode();

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }
        // 遍历(start、end) 取middle
        ListNode middle = findMiddle(start);
        ListNode head1 = sort(start, middle);
        ListNode head2 = sort(middle, end);

        // 合并head1 与 head2
        return merge(head1, head2);

    }

    // 快慢指针
    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;
    }


    private ListNode merge(ListNode head1, ListNode head2) {
        // head1 与 head2 对应的链表已经有序
        ListNode temp = dumpNode;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        // head1已经拼接完毕
        if (head1 == null) {
            temp.next = head2;
        }
        if (head2 == null) {
            temp.next = head1;
        }
        ListNode head = dumpNode.next;
        dumpNode.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
