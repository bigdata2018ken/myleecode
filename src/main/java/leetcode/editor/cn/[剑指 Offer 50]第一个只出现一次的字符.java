package leetcode.editor.cn;//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 175 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution50 {


    public char firstUniqChar(String s) {
        Map<Character, Integer> charCounterMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ele : chars) {
            Integer count = charCounterMap.getOrDefault(ele, 0);
            charCounterMap.put(ele, ++count);
        }
        for (char aChar : chars) {
            if (1 == charCounterMap.get(aChar)) {
                return aChar;
            }
        }
        return ' ';
    }

}
//leetcode submit region end(Prohibit modification and deletion)
