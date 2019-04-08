package com.huxl.interview.offer;

/**
 * 剑指offer ： 二维数组中的查找
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数
 * ，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 二维数组
 * {{1,6},{2,7},{3,8},{4,9},{5,10}}
 *
 * [1,2,3,4,5]
 * [6,7,8,9,10]
 *
 * 解题思路：
 * 从左下角或者右上角分析，有序的，向右递增，向上递减
 * 与左下角的值比较，则比他大在右，比他小在上
 *
 * @author huxl
 */
public class FindFromArr2Question {

    public static void main(String[] args) {

        int[][] array = {{1,6},{2,7},{3,8},{4,9},{5,10}};
        System.out.println(array[4].length);

    }


    public boolean Find(int target, int [][] array) {


        int len = array.length - 1;

        int i = 0;
        while (len >= 0 && (i < array[0].length)) {
            if (array[len][i] > target) {
                len--;
            } else if (array[len][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

}
