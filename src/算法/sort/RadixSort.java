package 算法.sort;

/**
 * 基数排序，也叫桶排序
 * 默认不支持复数，但是可以优化
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] simpleArray = ArrayDataUtil.getSimpleArray(10);

        ArrayDataUtil.show(simpleArray);
        radixSort(simpleArray);
        ArrayDataUtil.show(simpleArray);

        long l = System.currentTimeMillis();
        int[] advanceArray1 = ArrayDataUtil.getAdvanceArray(8000000);
        radixSort(advanceArray1);
        System.out.println("基数排序,共耗时:" + (System.currentTimeMillis() - l));
        ArrayDataUtil.show(advanceArray1);
    }

    private static void radixSort(int[] arr) {
        //定义10个桶，用于存储，最后一位为0-9的数据
        int[][] bucket = new int[10][arr.length];
        //记录10个桶中，每个桶的元素个数，每放入一个就+1
        int[] bucketIndex = new int[10];
        int len = getMaxLength(arr);
        for (int i = 1, m = 1; i <= len; i++, m *= 10) {
            // 放入桶中
            for (int j = 0; j < arr.length; j++) {
                //取个位数的逻辑
                int index = arr[j] / m % 10;
                bucket[index][bucketIndex[index]++] = arr[j];
            }

            int arrIndex = 0;
            //从桶中取出来，重新放入数组
            for (int j = 0; j < bucketIndex.length; j++) {
                if (bucketIndex[j] == 0) {//说明这个桶里没数据
                    continue;
                }
                //把桶里的数据按顺序迭代出来放入原数组
                for (int k = 0; k < bucketIndex[j]; k++) {
                    arr[arrIndex++] = bucket[j][k];
                }
                //清空记录下标的桶
                bucketIndex[j] = 0;
            }
        }
    }

    /**
     * 获取位数最大的那个数的位数
     *
     * @param arr
     * @return
     */
    private static int getMaxLength(int[] arr) {
        int maxNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
            }
        }
        return (maxNumber + "").length();
    }
}
