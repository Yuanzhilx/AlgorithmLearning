package org.example.排序;

import java.util.Arrays;

/***********************************
 *@Desc TODO
 *@ClassName InsertSorting
 *@Author DLX
 *@Data 2022/5/30 20:15
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class InsertSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,9,8,6,7,-1};
//        int[] arr = new int[80000];
//        for (int i = 0;i<arr.length;i++){
//            arr[i] = (int)(Math.random()*arr.length*10);
//        }
        System.out.println("原始数组为：");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        insertSort(arr);//O(n^2)
        long endTime = System.currentTimeMillis();
        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序消耗时间为："+(endTime-startTime)+"ms");
    }
    public static void insertSort(int[] arr){
        int insertVal;
        int insertIndex;
        for (int i = 1;i < arr.length ;i++){
            insertVal = arr[i];
            insertIndex = i-1;
           while (insertIndex >= 0 && insertVal < arr[insertIndex]){
               arr[insertIndex+1] = arr[insertIndex];
               insertIndex--;
           }
           arr[insertIndex+1] = insertVal;
        }
    }
    public static void insertSort2(int[] arr){
        int temp;
        int j;
        for (int i = 1;i < arr.length;i++){
            temp = arr[i];
            for (j = i-1;j >= 0;j--){
                if (arr[j] > temp){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
}
