package 算法.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] simpleArray = ArrayDataUtil.getSimpleArray(10);
        insertSort(simpleArray);
//        insertSortOptimized(simpleArray);
//        insertSortOptimized2(simpleArray);
        ArrayDataUtil.show(simpleArray);

        long l = System.currentTimeMillis();
        int[] advanceArray1 = ArrayDataUtil.getAdvanceArray(80000);
        insertSort(advanceArray1);
        System.out.println("插入排序,共耗时:" + (System.currentTimeMillis() - l));
        ArrayDataUtil.show(advanceArray1);

        long l2 = System.currentTimeMillis();
        int[] advanceArray2 = ArrayDataUtil.getAdvanceArray(80000);
        insertSortOptimized(advanceArray2);
        System.out.println("插入排序优化的,共耗时:" + (System.currentTimeMillis() - l2));
        ArrayDataUtil.show(advanceArray2);

        long l3 = System.currentTimeMillis();
        int[] advanceArray3 = ArrayDataUtil.getAdvanceArray(80000);
        //这个优化反而慢了
        insertSortOptimized2(advanceArray3);
        System.out.println("插入排序优化2的,共耗时:" + (System.currentTimeMillis() - l3));
        ArrayDataUtil.show(advanceArray3);
    }

    /**
     * 插入排序,思想,默认分为两个数组,左边为有序数组,默认只有一个元素,右边为无序,将右边的元素逐一按顺序插入左边的有序数组
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        //从第二个数开始插入左边的数组
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            //往左还有元素,并且当前这个元素小于左边的元素,我们就交换 或者记录位置
            while (j - 1 >= 0 && arr[j] < arr[j - 1]) {
                ArrayDataUtil.swap(arr, j, j - 1);
                j--;
            }
        }
    }

    private static void insertSortOptimized(int[] arr) {
        //从第二个数开始插入左边的数组
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j - 1 >= 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static void insertSortOptimized2(int[] arr) {
        //从第二个数开始插入左边的数组
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j - 1 >= 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (i != j) {
                arr[j] = temp;
            }
        }
    }
}
