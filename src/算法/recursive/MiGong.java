package 算法.recursive;

/**
 * 迷宫问题
 * 起点 (1,1)
 * 终点(6,5)
 * 1-是墙
 * 2-是走过的路
 * 3-是不通的路
 * 0-是没有走过的路
 * 1  1  1  1  1  1  1
 * 1  0  0  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  1  1  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  1  1  1  1  1  1
 */
public class MiGong {
    static int startX = 1;
    static int startY = 1;
    static int endX = 6;
    static int endY = 5;

    public static void main(String[] args) {
        int[][] miGong = initMiGong();
        show(miGong);
        go(miGong, startX, startY);
        miGong[startX][startY] = 2;
        show(miGong);
    }

    /**
     * 4-是起点
     * 1-是墙
     * 2-是走过的路
     * 3-是不通的路
     * 0-是没有走过的路
     */
    private static boolean go(int[][] miGong, int startX, int startY) {
        //如果终点已经被修改成2,说明已经走通不需要继续往下走了
        if (miGong[endX][endY] == 2) {
            return true;
        }
        //当前节点必须没走过,且不是墙,也不是不通的点
        if (miGong[startX][startY] != 0) {
            return false;
        }

        //尝试设置当前节点可以走通
        miGong[startX][startY] = 2;

        if (go(miGong, startX + 1, startY)) {//下
            return true;
        } else if (go(miGong, startX, startY + 1)) {//右
            return true;
        } else if (go(miGong, startX - 1, startY)) {//上
            return true;
        } else if (go(miGong, startX, startY - 1)) {//左
            return true;
        } else {
            //回溯,修改当前节点走不通
            miGong[startX][startY] = 3;
            return false;
        }

    }

    private static void show(int[][] arr) {
        System.out.println("------------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    /**
     * 定义1是墙,2是走过的路,3是不通的路,0是没有走过的路
     *
     * @return
     */
    private static int[][] initMiGong() {
        int[][] miGong = new int[8][7];

        for (int i = 0; i < 7; i++) {
            miGong[0][i] = 1;
            miGong[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            miGong[i][0] = 1;
            miGong[i][6] = 1;
        }

        miGong[3][1] = 1;
        miGong[3][2] = 1;
        return miGong;
    }
}
