package org.example.排序;

import java.util.Arrays;

/***********************************
 *@Desc TODO
 *@ClassName RadixSort
 *@Author DLX
 *@Data 2022/6/16 20:23
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
//https://code.i-harness.com/zh-CN/q/e98fa9
public class RadixSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr){
        //先找到数组中最大的位数，确认最大数字有几位（要循环几次）
        int max = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        //算出最大数字都多少位
        int maxLength = (max+"").length();
        //定义一个二维数组，表示10个桶，每个一维数组就是一个桶
        int[][] bucket = new int[10][arr.length];
        //创建下标记录每个桶中实际存放的数据
        int[] bucketIndex = new int[10];
        for (int k = 0;k < maxLength;k++){
            for (int i = 0;i < arr.length;i++){
                //取出数字个位
                int digitOfElement = arr[i]/((int)Math.pow(10,k))%10;
                //放入桶中的对应下标
                bucket[digitOfElement][bucketIndex[digitOfElement]] = arr[i];
                //下标后移
                bucketIndex[digitOfElement]++;
            }
            //向原数组中插回数据，记录下标
            int index = 0;
            for (int i = 0;i < bucket.length;i++){
                for (int j = 0;j < bucketIndex[i];j++){
                    arr[index++] = bucket[i][j];
                }
                bucketIndex[i] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
