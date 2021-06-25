package 算法.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] simpleArray = ArrayDataUtil.getSimpleArray(10);

        ArrayDataUtil.show(simpleArray);
        mergeSortMain(simpleArray);
        ArrayDataUtil.show(simpleArray);

        long l = System.currentTimeMillis();
        int[] advanceArray1 = ArrayDataUtil.getAdvanceArray(8000000);
        mergeSortMain(advanceArray1);
        System.out.println("归并排序,共耗时:" + (System.currentTimeMillis() - l));
        ArrayDataUtil.show(advanceArray1);
    }

    private static void mergeSortMain(int[] simpleArray) {
        int[] temp = new int[simpleArray.length];
        mergeSort(simpleArray, 0, simpleArray.length - 1, temp);
    }

    public static void mergeSort(int[] simpleArray, int start, int end, int[] temp) {
        if (start == end) {
            return;
        }
        int middle = (end + start + 1) / 2;
        mergeSort(simpleArray, start, middle - 1, temp);
        mergeSort(simpleArray, middle, end, temp);

        merge(simpleArray, start, middle, end, temp);
    }

    /**
     * 合并两个数组 start => middle - 1 | middle => end
     * 先把两个数组按顺序存入temp，然后从temp拷贝到simpleArray得start到end下标
     *
     * @param simpleArray
     * @param start
     * @param middle
     * @param end
     * @param temp
     */
    private static void merge(int[] simpleArray, int start, int middle, int end, int[] temp) {
        int leftIndex = start;
        int rightIndex = middle;
        int tempIndex = start;
        while (tempIndex <= end) {
            if (rightIndex > end || simpleArray[leftIndex] <= simpleArray[rightIndex]) {
                temp[tempIndex++] = simpleArray[leftIndex++];
            } else {
                temp[tempIndex++] = simpleArray[rightIndex++];
            }
        }

        // 将temp复制到simpleArray
        for (int i = start; i <= end; i++) {
            simpleArray[i] = temp[i];
        }
    }
}
