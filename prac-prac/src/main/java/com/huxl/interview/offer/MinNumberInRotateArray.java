package com.huxl.interview.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数
 * 组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 *
 * @author huxl
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {

        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(of(3,4,5,1,2)));
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(of(1,1,1,0,1)));
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(of(1,0,1,1,1)));
    }

    public static int[] of(int ... arg) {
        return arg;
    }

    public int minNumberInRotateArray(int[] array){
        if (array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            }else if (array[mid] == array[high]) {
                high = high - 1;
            }else {
                high = mid;
            }
        }
        return array[low    ];
    }
}
