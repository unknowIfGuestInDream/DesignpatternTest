package 算法.sort;

/**
 * 希尔排序,对2取余,然后再进行插入排序,解决当小的数在数组最后时,我们需要移动很多次才能排序完成
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] simpleArray = ArrayDataUtil.getSimpleArray(10);
        ArrayDataUtil.show(simpleArray);
//        shellSortSwap(simpleArray);
        shellSortMove(simpleArray);
        ArrayDataUtil.show(simpleArray);

        long l = System.currentTimeMillis();
        int[] advanceArray1 = ArrayDataUtil.getAdvanceArray(80000);
        shellSortSwap(advanceArray1);
        System.out.println("希尔排序交换,共耗时:" + (System.currentTimeMillis() - l));
        ArrayDataUtil.show(advanceArray1);

        long l2 = System.currentTimeMillis();
        int[] advanceArray2 = ArrayDataUtil.getAdvanceArray(80000);
        shellSortMove(advanceArray2);
        System.out.println("希尔排序移动,共耗时:" + (System.currentTimeMillis() - l2));
        ArrayDataUtil.show(advanceArray2);

        long l3 = System.currentTimeMillis();
        int[] advanceArray3 = ArrayDataUtil.getAdvanceArray(80000);
        shellSortMove2(advanceArray3);
        System.out.println("希尔排序移动,共耗时:" + (System.currentTimeMillis() - l3));
        ArrayDataUtil.show(advanceArray3);

    }

    private static void shellSortSwap(int[] arr) {
        for (int gap = arr.length / 2; gap != 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j > gap - 1 && arr[j] < arr[j - gap]) {
                    ArrayDataUtil.swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    private static void shellSortMove(int[] arr) {
        for (int gap = arr.length / 2; gap != 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j > gap - 1 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
//                if (i != j) { 此处判断优化极小,可以忽略
                arr[j] = temp;
//                }
            }
        }
    }

    private static void shellSortMove2(int[] arr) {
        for (int gap = arr.length / 2; gap != 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j > gap - 1 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                if (i != j) { //此处判断优化极小,可以忽略
                    arr[j] = temp;
                }
            }
        }
    }
}
