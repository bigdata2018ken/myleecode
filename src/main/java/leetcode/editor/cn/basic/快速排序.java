package leetcode.editor.cn.basic;

public class 快速排序 {


    public int[] quickSort(int[] array) {
        sort(array, 0, array.length);
        return array;
    }


    /**
     * 快排思想: 取一个参照值,使得 比他小的元素在左边，比他大的值在右边
     * f(s, e) = f(s, r) + f(r+1, e)
     * 与归并不同的是: 归并是至下而上, 将子问题拆解后,再重新合并即是有序的数组, 而且需要拷贝数组元素数据
     * 快排是至上而下: 在拆解问题前, 已经保证 局部有序
     * 时间复杂度：O(nlogn)
     * 空间复杂度: O(1)
     * 非稳定排序
     */
    public void sort(int[] array, int start, int end) {
        int partition = partition(array);
        sort(array, start, partition);
        sort(array, partition+1, end);
    }

    // 按参照点 对数组分区, 找到参照元素插入的位置
    private int partition(int[] array) {

        int length = array.length;
        int pivot = array[length - 1];
        // pivot 交换的下标, 需要找到最终与哪一个元素交换
        int swapIndex = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] < pivot) {
                // 交换 swapIndex 与 i上的元素
                swap(array, swapIndex, i);
                swapIndex++;
            }
        }
        swap(array, swapIndex, length-1);
        return swapIndex;

    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
