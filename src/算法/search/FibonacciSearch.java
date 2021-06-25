package 算法.search;

import 算法.sort.ArrayDataUtil;
import 算法.sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciSearch {
    public static int times = 0;

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 12, 16};
        fibonacciSearchMain(arr, 3);

        int searchVal = 10086;
        int[] advanceArray = ArrayDataUtil.getAdvanceArray(800000);
        QuickSort.quickSortOptimized(advanceArray, 0, advanceArray.length - 1);
        InsertSearch.insertSearchMain(advanceArray, searchVal);
        BinarySearch.binarySearchMain(advanceArray, searchVal);
        FibonacciSearch.fibonacciSearchMain(advanceArray, searchVal);
        System.out.println("----------------------------------------");
    }

    public static void fibonacciSearchMain(int[] arr, int val) {
        //根据数组长度获取斐波那契数
        int[] f = getFib(arr.length);
//        System.out.println("获取到的斐波那契数组:" + Arrays.toString(f));
        //根据原数组,获取一个值刚好等于斐波那契最大长度值的数组,方便获取mid
        int[] tempArr = getTempArr(arr, f[f.length - 1]);
//        System.out.println("-------------原数组:\t" + Arrays.toString(arr));
//        System.out.println("获取到的方便查询的数组:\t" + Arrays.toString(tempArr));
        times = 0;
        List<Integer> res = new ArrayList<>();
        fibonacciSearch(f, tempArr, val, arr.length - 1, res);
        System.out.printf("fibonacciSearchMain:times[%d],index" + res.toString() + "\t\n", times);

    }

    private static void fibonacciSearch(int[] f, int[] tempArr, int val, int len, List<Integer> res) {
        int start = 0;
        int end = tempArr.length - 1;
        int k = f.length - 1;//最后一个元素13的下标,13是tempArr的长度
        while (start <= end) {//切记要包含等于
            times++;
            int mid = start + f[k - 1] - 1;
            if (val == tempArr[mid]) {
                //后面一部分元素是我们填充的
                if (mid > len) {
                    mid = len;
                }
                res.add(mid);
                int temp = mid - 1;
                while (temp >= 0 && tempArr[temp] == val) {
                    res.add(temp--);
                }

                temp = mid + 1;
                while (temp >= 0 && tempArr[temp] == val && temp <= len) {
                    res.add(temp++);
                }
                return;
            } else if (val > tempArr[mid]) {
                start = mid + 1;
                k -= 2;
            } else {
                end = mid - 1;
                k -= 1;
            }
        }
    }

    private static int[] getTempArr(int[] arr, int len) {
        //将原数组复制到一个新数组中,长度为len
        int[] res = Arrays.copyOf(arr, len);
        //让没有元素的位置的值都等于最后一个元素
        for (int i = arr.length; i < len; i++) {
            res[i] = res[arr.length - 1];
        }
        return res;
    }

    private static int[] getFib(int length) {
        int before = 1, cur = 1, count = 2, temp;
        while (cur < length) {
            temp = cur;
            cur += before;
            before = temp;
            count++;
        }
        int[] fib = new int[count];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < count; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

}
