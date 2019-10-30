package com.huxl.atguigu;

import jdk.management.resource.internal.inst.FileInputStreamRMHooks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏数组
 * (n+1)*3 的数组 三列分别是 行坐标 列坐标 值，其中第一行 分别表示总行数，总列数 和非0个数,n表示原始
 * 数组中非0元素个数
 * @author huxl
 */
public class SparseArray {

    public static void main(String[] args) {
        //定义原始二维数组
        int[][] chessArr = new int[10][10];
        chessArr[3][2] = 1;
        chessArr[4][3] = 2;
        printf(chessArr);
        int[][] sparseArr = toSparseArr(chessArr);
        printf(sparseArr);
        toFile(chessArr);
        int[][] chessArr2 = toChessArr(sparseArr);
        printf(chessArr2);
        System.out.println();
        printf(readFile());

    }

    private static int[][] toSparseArr(int[][] chessArr) {
        //非0个数
        int count = 0;
        //列数
        int colNum = 0;
        //行数
        int rowNum = 0;
        for (int[] item : chessArr) {
            rowNum++;
            for (int var : item) {
                if (var != 0) {
                    count++;
                }
                colNum++;
            }
        }
        colNum = colNum/rowNum;
        //定义稀疏数组的为
        int[][] sparseArr = new int[count+1][3];
        sparseArr[0][0] = colNum;
        sparseArr[0][1] = rowNum;
        sparseArr[0][2] = count;
        int i = 1;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col< colNum;col++) {
                if (chessArr[row][col] != 0) {
                    sparseArr[i][0] = row;
                    sparseArr[i][1] = col;
                    sparseArr[i][2] = chessArr[row][col];
                    i++;
                }
            }
        }
        return sparseArr;
    }

    private static int[][] toChessArr(int[][] sparseArr) {
        int rows = sparseArr[0][0];
        int cols = sparseArr[0][1];
        int[][] chessArr = new int[rows][cols];

        for (int i = 1; i <= sparseArr[0][2];i++) {
            int row = sparseArr[i][0];
            int col = sparseArr[i][1];
            int val = sparseArr[i][2];
            chessArr[row][col] = val;
        }
        return chessArr;
    }

    private static void printf(int[][] arr) {
        for (int i =0; i< arr.length;i++) {
            for (int j=0;j< arr[i].length; j++) {
                System.out.printf("%d\t",arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void toFile(int[][] arr){
        File file = new File("F:\\test\\chess.data");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            for (int[] item : arr) {
                StringBuilder sb = new StringBuilder();
                for (int val : item) {
                    sb.append(val).append("|");
                }
                writer.append(sb.toString()).append("\n");
            }
            writer.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int[][] readFile(){
        File file = new File("F:\\test\\chess.data");
        List<String> list = new ArrayList<>();
        try {
            FileInputStream ins = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(ins);
            BufferedReader reader = new BufferedReader(isr);
            String str = "";
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int row = list.size();
        int[][] arr = new int[row][list.get(0).split("|").length/2];
        int i=0;
        for (String str : list) {

            String[] strArr = str.split("|");
            int j=0;
            for (String val : strArr) {
                if ((val != null || !val.equals(""))) {
                    if (!"|".equals(val)) {
                        arr[i][j] = Integer.parseInt(val);
                        j++;
                    }

                }
            }
            i++;
        }
        return arr;
    }
}
