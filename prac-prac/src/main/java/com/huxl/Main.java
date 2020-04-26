package com.huxl;

/**
 * 华图算法题
 * 有序列表找出出现次数最多的数
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,2,3,3,3,3,6,6,6};
        //出现次数
        int count = 1;
        int maxCount = 1;
        //出现次数最多数字第一次出现时的索引
        int maxIndex = 0;
        int curNumIndex = 0;
        for (int i =0;i < arr.length;i++) {
            if (arr[curNumIndex] == arr[i]) {
                count ++;
            }else {

                if (maxCount < count) {
                    maxCount = count;
                    maxIndex = curNumIndex;
                }
                curNumIndex = i;
                count = 1;
            }
            if (maxIndex == arr.length -1 ) {
                maxIndex++;
            }
        }
        System.out.println("数字" + arr[maxIndex] + "出现次数最多，共出现了" + maxCount +"次");
        //记录所有出现次数的解法
/*
        int[] countArr = new int[arr.length -1];
        for (int i=0;i < arr.length;i++) {
            //处理逻辑 遍历数组，记录每个数出现的次数，
            if (cur == arr[i]) {
                countArr[cur]++;
            }else {
                cur = arr[i];
            }
        }
        System.out.println(Arrays.toString(countArr));

        int index = 0;
        for (int j = 0; j < countArr.length; j++) {
            if (countArr[j] > countArr[index]) {

                index = j;
            }
        }
        System.out.println("出现次数最多的数字为" + (index) + ",出现了" + (countArr[index]+1) + "次");
*/
/*        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }else {
                list.add(i);
            }
        }
        int max = 0;
        int maxK = 0;
        for (Integer i : map.keySet()) {
            if (max < map.get(i).size()){
                max = map.get(i).size();
                maxK= i;
            }
        }
        System.out.println(maxK);
        System.out.println(map.get(maxK).size());*/
    }
}
