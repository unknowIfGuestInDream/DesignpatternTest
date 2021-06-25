package 算法.sort;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] simpleArray = ArrayDataUtil.getSimpleArray(10);
        selectSort(simpleArray);
        ArrayDataUtil.show(simpleArray);

        long l = System.currentTimeMillis();
        int[] advanceArray = ArrayDataUtil.getAdvanceArray(80000);
        selectSort(advanceArray);
        System.out.println("选择排序,共耗时:" + (System.currentTimeMillis() - l));
        ArrayDataUtil.show(advanceArray);
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = minValue;
        }
    }
}
