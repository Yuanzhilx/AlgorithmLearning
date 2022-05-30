package org.example.排序;

import java.util.Arrays;

/***********************************
 *@Desc TODO
 *@ClassName SelectSorting
 *@Author DLX
 *@Data 2022/5/30 19:24
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class SelectSorting {
    public static void main(String[] args) {
//        int[] arr = new int[]{3,1,4,9,8,6,7,-1};
        int[] arr = new int[80000];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*arr.length*10);
        }
        System.out.println("原始数组为：");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        selectSort(arr);//O(n^2)
        long endTime = System.currentTimeMillis();
        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序消耗时间为："+(endTime-startTime)+"ms");
    }
    public static void selectSort(int[] arr){
        int temp;//记录每轮最小值
        int minIndex;//记录最小值下标
        for (int i = 0;i < (arr.length - 1);i++){
            minIndex = i;//默认当前循环的起始值为最小值
            for (int j = i + 1;j < arr.length;j++){
                //找到新的最小值记录最小值坐标
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //判断最小值于起始值是否在同一位置，如果不在则发生交换
            if (i != minIndex){
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
