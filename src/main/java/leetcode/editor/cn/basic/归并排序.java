package leetcode.editor.cn.basic;

public class 归并排序 {


    /**
     * 使用分治思想实现归并排序
     * f(s, e) = f(s,m) + f(m+1, e), 其中m = s+e/2
     * 时间复杂度：nlogn
     * 空间复杂度 O(n): merge 时需要开辟一块额外的空间
     * 稳定排序
     */
    public int[] mergeSort(int[] array) {
        sort(array, 0, array.length);
        return array;
    }


    public void sort(int[] arr, int start, int end) {
        if (start >= end) return;

        int middle = (start + end) / 2;

        // 拆分
        sort(arr, start, middle);
        sort(arr, middle + 1, end);

        // 合并

        merge(arr, start, end);
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
