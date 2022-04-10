package leetcode.editor.cn;//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
// Related Topics 栈 双指针 字符串 模拟 👍 363 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution844 {

    // 1、可以使用栈, 但空间复杂度不满足要求 O(m+n)
    // 2、这里使用快慢指针处理
    public boolean backspaceCompare(String s, String t) {
        return simpleString(s).equals(simpleString(t));
    }

    // 通过快慢指针 重新构建char数组
    public String simpleString(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int slow = 0;
        for (int fast = 0; fast < length; fast++) {
            if (charArray[fast] == '#') {
                // slow 回退一步
                if (slow > 0) {
                    slow--;
                }
            } else {
                charArray[slow++] = charArray[fast];
            }
        }
        return new String(charArray, 0, slow);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
