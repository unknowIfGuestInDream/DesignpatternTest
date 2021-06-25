package 算法.sort;

import java.util.Random;

public class QuickSort {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] simpleArray = ArrayDataUtil.getSimpleArray(10);

        ArrayDataUtil.show(simpleArray);
//        quickSortFirst(simpleArray, 0, simpleArray.length - 1);
        quickSortOptimized(simpleArray, 0, simpleArray.length - 1);
        ArrayDataUtil.show(simpleArray);

        long l = System.currentTimeMillis();
        int[] advanceArray1 = ArrayDataUtil.getAdvanceArray(8000000);
        quickSortFirst(advanceArray1, 0, advanceArray1.length - 1);
        System.out.println("快速排序交换,共耗时:" + (System.currentTimeMillis() - l));
        ArrayDataUtil.show(advanceArray1);

        long l2 = System.currentTimeMillis();
        int[] advanceArray2 = ArrayDataUtil.getAdvanceArray(8000000);
        partitionSortOptimized(advanceArray2, 0, advanceArray2.length - 1);
        System.out.println("快速排序优化版本,共耗时:" + (System.currentTimeMillis() - l2));
        ArrayDataUtil.show(advanceArray2);
    }

    /**
     * 此方法包含start和end下表
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSortFirst(int[] arr, int start, int end) {
        if (start < end) {
            ArrayDataUtil.swap(arr, start, random.nextInt(end - start + 1) + start);
            int number = partitionSort(arr, start, end);
            //左分区，继续使用快速排序
            quickSortFirst(arr, start, number - 1);
            //右分区，继续使用快速排序
            quickSortFirst(arr, number + 1, end);
        }
    }

    public static void quickSortOptimized(int[] arr, int start, int end) {
        if (start < end) {
            ArrayDataUtil.swap(arr, start, random.nextInt(end - start + 1) + start);
            int number = partitionSortOptimized(arr, start, end);
            //左分区，继续使用快速排序
            quickSortOptimized(arr, start, number - 1);
            //右分区，继续使用快速排序
            quickSortOptimized(arr, number + 1, end);
        }
    }

    public static int partitionSortOptimized(int[] arr, int start, int end) {
        int pivotIndex = start;
        //中心点的值，设置第start个元素是基准值
        int pivotValue = arr[start];
        //如果start不等于end继续循环
        while (start != end) {
            //1.移动右边，如果当前值大于或者等于基准值，不需要交换，继续移动下标
            while (arr[end] >= pivotValue && start != end) {
                end--;
            }

            //中心点所在位置，中心值已使用变量记录
            while (arr[start] <= pivotValue && start != end) {
                start++;
            }
            ArrayDataUtil.swap(arr, start, end);
        }
        //如果相等交换最后一个位置 切记不能忘
        ArrayDataUtil.swap(arr, pivotIndex, start);
        return start;
    }

    private static int partitionSort(int[] arr, int start, int end) {
        //中心点的值，设置第start个元素是基准值
        int pivotValue = arr[start];
        //如果start不等于end继续循环
        while (start != end) {
            //1.移动右边，如果当前值大于或者等于基准值，不需要交换，继续移动下标
            while (arr[end] >= pivotValue) {
                if (start == end) {//如果下标重合，说明基准值左边已经小于基准值，右边大于基准值
                    arr[start] = pivotValue;
                    return end;
                }
                end--;
            }
            arr[start] = arr[end];
            start++;

            //中心点所在位置，中心值已使用变量记录
            while (arr[start] <= pivotValue) {
                if (start == end) {
                    arr[start] = pivotValue;
                    return end;
                }
                start++;
            }
            arr[end] = arr[start];
            end--;
        }
        //如果相等交换最后一个位置 切记不能忘
        arr[start] = pivotValue;
        return start;
    }
}
