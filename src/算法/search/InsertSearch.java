package 算法.search;

import 算法.sort.ArrayDataUtil;
import 算法.sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入查找
 */
public class InsertSearch {
    public static int times = 0;

    public static void main(String[] args) {
        int[] arr = {-12, -7, -3, -2, 1, 3, 5, 9, 12, 16};
//        insertSearchMain(arr, -12);

        int[] advanceArray = ArrayDataUtil.getAdvanceArray(80000);
        QuickSort.quickSortOptimized(advanceArray, 0, advanceArray.length - 1);

        insertSearchMain(advanceArray, 10086);
        BinarySearch.binarySearchMain(advanceArray, 10086);
    }

    public static void insertSearchMain(int[] arr, int val) {
        times = 0;
        int start = 0;
        int end = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        insertSearch(arr, start, end, val, res);
        System.out.printf("insertSearchMain:times[%d],index" + res.toString() + "\t\n", times);
    }

    private static void insertSearch(int[] arr, int start, int end, int val, List<Integer> res) {
        times++;
        if (val < arr[start] || val > arr[end]) {
            return;
        }
        //插入排序
        int middle = start + (int) ((Double.valueOf(val - arr[start]) / Double.valueOf(arr[end] - arr[start])) * (end - start));
        if (arr[middle] == val) {
            searchSameValueIndex(arr, val, res, middle);
            return;
        }
        if (arr[middle] > val) {
            insertSearch(arr, start, middle - 1, val, res);
        }
        insertSearch(arr, middle + 1, end, val, res);
    }

    public static void searchSameValueIndex(int[] arr, int val, List<Integer> res, int middle) {
        res.add(middle);
        int temp = middle - 1;
        while (temp >= 0 && arr[temp] == val) {
            res.add(temp--);
        }

        temp = middle + 1;
        while (temp >= 0 && arr[temp] == val) {
            res.add(temp++);
        }
    }
}
