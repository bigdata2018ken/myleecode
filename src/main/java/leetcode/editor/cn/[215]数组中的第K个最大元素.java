package leetcode.editor.cn;//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1526 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution215 {


    // 使用快排思想实现
    // 使用优先队列更简单
    public static int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length, k-1);
        return nums[k - 1];
    }

    private static void sort(int[] nums, int start, int end, int k) {

        // 分区, (0,p)的元素都比 k 大, (p, n)的元素都比 k小
        // p = k 时, 命中
        int partition = partition(nums, start, end);
        // 如果 k = partition, 说明
        if (partition < k) {
            sort(nums, partition + 1, end, k);
        } else if (partition > k){
            sort(nums, 0, partition, k);
        }

    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end - 1];

        // pivot 最终插入的位置
        int insertIndex = start;
        for (; start < end; start++) {
            if (pivot < nums[start]) {
                // 这个位置较难理解, 交换 start 与 insertIndex
                // 表示找到一个比 pivot的元素, 移动至 insertIndex 处
                swap(nums, start, insertIndex);
                insertIndex++;
            }
        }
        swap(nums, insertIndex, end-1);

        return insertIndex;
    }

    private static void swap(int[] nums, int before, int after) {
        int temp = nums[before];
        nums[before] = nums[after];
        nums[after] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
