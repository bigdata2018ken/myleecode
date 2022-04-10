package leetcode.editor.cn;//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1072 👎 0


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution347 {


    // 时间复杂度 O(n)
    public  int[] topKFrequent(int[] nums, int k) {
        // 使用 HashMap 计数
        Map<Integer, Integer> eleCountMap = new HashMap<>();
        // 使用 优先队列 记录前k高数据, int[]存储， 0:计数， 1：存储元素
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < nums.length; i++) {
            Integer count = eleCountMap.getOrDefault(nums[i], 0);
            eleCountMap.put(nums[i], ++count);
        }

        eleCountMap.forEach((key, count) -> {
            if (queue.size() < k) {
                queue.add(new Integer[]{count, key});
            } else {
                // 堆顶最小的元素
                Integer[] top = queue.peek();
                if (top != null && count > top[0]) {
                    queue.remove(top);
                    queue.add(new Integer[]{count, key});
                }
            }
        });
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll()[1];
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
