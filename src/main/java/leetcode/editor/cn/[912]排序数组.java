package leetcode.editor.cn;//给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 498 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution912 {

    // 归并排序
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;

        sort(nums, start, middle);
        sort(nums, middle + 1, end);
        // 合并
        merge(nums, start, end);

    }

    private void merge(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] temp = new int[length];
        int middle = (start + end) / 2;
        // (start, middle) (middle+1， end) 已经有序
        int i = start, j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j];
                j++;
            } else {
                temp[k++] = nums[i];
                i++;
            }
        }
        // 处理未完全合并的区间
        if (i > middle) {
            // 说明 (start,middle) 已处理完毕
            while (j <= end) {
                temp[k++] = nums[j++];
            }
        } else {
            // 说明 (start,middle) 已处理完毕
            while (i <= middle) {
                temp[k++] = nums[i++];
            }
        }

        System.arraycopy(temp, 0, nums, start, length);

    }


}
//leetcode submit region end(Prohibit modification and deletion)
