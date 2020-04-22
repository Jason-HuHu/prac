package com.huxl.sort;

public interface IArraySort {
    /**
     * 对给定的数组升序排序
     * @param array 原数组
     * @return 返回排序后的数组
     */
    default int[] sort(int[] array){
        return sort(array,true);
    }

    /**
     * 对给定的数组排序
     * @param array 原数组
     * @param asc 是否升序
     * @return
     */
    int[] sort(int[] array,boolean asc);
}
