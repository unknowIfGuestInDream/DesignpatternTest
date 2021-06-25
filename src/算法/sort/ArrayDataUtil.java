package 算法.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayDataUtil {
    static Random random = new Random();

    public static int[] getSimpleArray(int length) {
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = (int) (random.nextDouble() * 100);
        }
        return res;
    }

    public static int[] getAdvanceArray(int length) {
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = (int) (random.nextDouble() * 8000000);
        }
        return res;
    }

    public static void show(int[] arr) {
        if (arr.length < 10000) {
            Arrays.stream(arr).forEach((x) -> {
                System.out.print(" " + x + " ");
            });
            System.out.println();
        } else {
            Set<Integer> set = new HashSet();
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
            System.out.println("去重后还剩余:" + set.size() + "个元素");
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
