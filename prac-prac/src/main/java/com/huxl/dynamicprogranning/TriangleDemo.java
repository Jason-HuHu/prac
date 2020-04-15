package com.huxl.dynamicprogranning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TriangleDemo {

    private static int[][] triangle = {
            {2, 0, 0, 0},
            {3, 4, 0, 0},
            {6, 5, 7, 0},
            {4, 1, 8, 4}
    };

    //记录中间状态的mao
    private static Map<String,Integer> map = new HashMap<>();

    public static int traverse(int i,int j){
        int totalRow = triangle.length;
        if (i >= totalRow -1) {
            return 0;
        }
        //往左下结点走
        int leftSum = traverse(i+1,j) + triangle[i+1][j];
        //往右下结点走
        int rightSum = traverse(i+1,j+1) + triangle[i+1][j+1];

        return Math.min(leftSum,rightSum);
    }

    public static int traverse(){
        int ROW = triangle.length;
        int[] mini = triangle[ROW-1];
        //从倒数第二行起，因为最后一行的值本身就是固定的
        for (int i = ROW - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (triangle[i][j] == 0) {
                    continue;
                }
                mini[j] = triangle[i][j] + Math.min(mini[j],mini[j+1]);
            }
        }
        System.out.println(Arrays.toString(mini));
        return mini[0];
    }

    public static void main(String[] args) {
        int result = triangle[0][0] + traverse(0,0);
        System.out.println(result);
        System.out.println(traverse());
    }

}
