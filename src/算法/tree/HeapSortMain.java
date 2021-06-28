package 算法.tree;

import 算法.sort.ArrayDataUtil;
import 算法.sort.QuickSort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSortMain {

    public static void main(String[] args) {
        int[] simpleArray = ArrayDataUtil.getSimpleArray(10);

        ArrayDataUtil.show(simpleArray);
        heapSortOptimized(simpleArray);
        ArrayDataUtil.show(simpleArray);

        int[] advanceArray1 = ArrayDataUtil.getAdvanceArray(8000000);
        int[] advanceArray2 = Arrays.copyOf(advanceArray1, advanceArray1.length);
        int[] advanceArray3 = Arrays.copyOf(advanceArray1, advanceArray1.length);
        int[] advanceArray4 = Arrays.copyOf(advanceArray1, advanceArray1.length);
//        long l = System.currentTimeMillis();
//        heapSort(advanceArray1);
//        System.out.println("堆排序,共耗时:" + (System.currentTimeMillis() - l));
//        ArrayDataUtil.show(advanceArray1);

        long l4 = System.currentTimeMillis();
        heapSortOptimized(advanceArray4);
        System.out.println("堆排序优化版本,共耗时:" + (System.currentTimeMillis() - l4));
//        ArrayDataUtil.show(advanceArray4);

//        long l2 = System.currentTimeMillis();
//        QuickSort.quickSortFirst(advanceArray2, 0, advanceArray2.length - 1);
//        System.out.println("快速排序交换,共耗时:" + (System.currentTimeMillis() - l2));
//        ArrayDataUtil.show(advanceArray2);

        long l3 = System.currentTimeMillis();
        QuickSort.partitionSortOptimized(advanceArray3, 0, advanceArray3.length - 1);
        System.out.println("快速排序优化版本,共耗时:" + (System.currentTimeMillis() - l3));
//        ArrayDataUtil.show(advanceArray3);
    }

    private static void heapSortOptimized(int[] arr) {
        //构建一个不完全的大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeapOptimized(arr, i, arr.length);
        }

        //找到最后一个非叶子节点
        for (int i = arr.length - 1; i > 0; i--) {
            //交换第一个节点和最后一个节点，那么此时这个大顶堆的第一个节点就不符合大顶堆规则了
            ArrayDataUtil.swap(arr, 0, i);
            //这里将第一个节点重新进行构建大顶堆，构建完成后还是大顶堆
            adjustHeapOptimized(arr, 0, i);
        }
    }

    private static void heapSort(int[] arr) {
        //构建一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //找到最后一个非叶子节点
        for (int i = arr.length - 1; i > 0; i--) {
            //交换第一个节点和最后一个节点，那么此时这个大顶堆的第一个节点就不符合大顶堆规则了
            ArrayDataUtil.swap(arr, 0, i);
            //这里将第一个节点重新进行构建大顶堆，构建完成后还是大顶堆
            adjustHeap(arr, 0, i);
        }
    }

    //构建大顶堆
    private static void adjustHeap(int[] arr, int i, int length) {

        //k为当前节点的左子节点，一次循环后k指向自己的下一个左子节点
        for (int k = 2 * i + 1; k + 1 < length; k = 2 * k + 1) {
            if (arr[k] > arr[k + 1]) {//如果左子节点小于右子节点，因为是大顶堆，我们需要找到最大的，所以把k执行最大的那个节点
                ArrayDataUtil.swap(arr, k, k + 1);
            }
            if (arr[i] < arr[k + 1]) {//如果当前元素小于其子节点中较大的那个，则交换位置
                //交换节点
                ArrayDataUtil.swap(arr, i, k + 1);
            }
            //两个子节点互相比较，大的靠右
            if (arr[k] > arr[k + 1]) {//如果左子节点小于右子节点，因为是大顶堆，我们需要找到最大的，所以把k执行最大的那个节点
                ArrayDataUtil.swap(arr, k, k + 1);
            }
        }
    }

    //优化版,是一个不完全的大顶堆,因为只是堆的栈顶大于两个子节点,但是左子节点不一定大于右子节点
    private static void adjustHeapOptimized(int[] arr, int i, int length) {
        int temp = arr[i];
        //k为当前节点的左子节点，一次循环后k指向自己的下一个较大的子节点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //如果k+1<length,但是k<length说明该节点只有左子节点,没有右子节点
            //那我们父节点直接和左子节点比较就可以了,跳过这里
            //比较左右子节点,将k指向较大的子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //如果左子节点小于右子节点，我们需要找到最大的，所以把k指向右子节点
                k++;
            }
            //父节点小于子节点中较大者
            if (temp < arr[k]) {
                //父节点和子节点中较大的交换
                // 这里交换时我们没有把k的值填充上
                //而是一直保存在temp,等循环结束再赋值,避免不必要的赋值,提升性能
                arr[i] = arr[k];
                //父子节点发生交换,则子节点也需要重新构建
                //i代表父节点,那么下一轮循环的父节点就是k,我们把父节赋值给i,方便下一次构建赋值
                i = k;
            } else {
                //父子节点没有发生交换,因为我们是从最后一个非叶子节点开始进行构建
                // 所以没有发生交换,代表子节点已经符合堆顶大于子节点的规范,这里就不需要再构建其子节点,直接返回即可
                break;
            }
        }
        //循环结束后,最后一次迭代的且发生父子交换的节点是i,在上面一直没有给i节点赋值,为了避免重复赋值
        //这里填充i的值
        arr[i] = temp;
    }
}
