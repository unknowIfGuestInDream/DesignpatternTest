package 算法.recursive;

/**
 * 8皇后问题
 */
public class Queen8 {
    static int max = 8;
    static int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {

        setQueen(0);
        System.out.println(count);

    }

    private static void setQueen(int n) {
        if (n == max) {//下标到max说明放完了,因为最后一个是max-1
            show(arr);
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i; //尝试设置
            if (check(n)) {//检查通过
                setQueen(n + 1);
            }
        }
    }

    private static void show(int[] arr) {
        count++;
        for (int item : arr) {
            System.out.print(" " + item + " ");
        }
        System.out.println();
    }

    /**
     * @param n 需要检查行的第几列
     * @return
     */
    private static boolean check(int n) {
        for (int i = 0; i < n; i++) {
            //如果两个位置的 行距离差 和列距离差相等,说明在一个斜线上,考虑反斜线,加上绝对值
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
