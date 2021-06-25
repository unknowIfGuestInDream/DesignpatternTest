package 算法.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static int times = 0;

    public static void main(String[] args) {
        int[] arr = {-12, -7, -3, -2, 1, 3, 5, 9, 12, 16};
        binarySearchMain(arr, -12);
    }

    public static void binarySearchMain(int[] arr, int val) {
        times = 0;
        int start = 0;
        int end = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        binarySearch(arr, start, end, val, res);
        System.out.printf("binarySearchMain:times[%d],index" + res.toString() + "\t\n", times);
    }

    private static void binarySearch(int[] arr, int start, int end, int val, List<Integer> res) {
        times++;
        if (val < arr[start] || val > arr[end]) {
            return;
        }

        int middle = (start + end) / 2;
        if (arr[middle] == val) {
            InsertSearch.searchSameValueIndex(arr, val, res, middle);
            return;
        }
        if (arr[middle] > val) {
            binarySearch(arr, start, middle - 1, val, res);
        }
        binarySearch(arr, middle + 1, end, val, res);
    }
}
