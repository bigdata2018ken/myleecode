package leetcode.editor.cn;//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution16 {

    // f(n) = f(n-1) + 业务逻辑
    // 这个思路本身没有问题, 但是 n 值太大了, 直接运行，会出现栈溢出
    public double myPow1(double x, int n) {

        if (n == 0) return 1;

        if (n > 0) {
            return x * myPow(x, n - 1);
        } else {
            return 1 / x * myPow(x, n + 1);
        }
    }

    // f(n) = f(n/2) + 业务逻辑, 入栈次数最多32次
    public double myPow(double x, int n) {

        if (n == 0) return 1;

        // n < 0 时，转化成正数处理
        if (n < 0) {
            // n = Integer.MIN_VALUE 取反时, 还是  Integer.MIN_VALUE, 需要单独处理
            return 1 / x * myPow(1 / x, -n - 1);
        } else {
            // 快速幂
            if ((n & 1) != 0) {
                // n 为奇数
                return x * myPow(x * x, n / 2);
            } else {
                return myPow(x * x, n / 2);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
