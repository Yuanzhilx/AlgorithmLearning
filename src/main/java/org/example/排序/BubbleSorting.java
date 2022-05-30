package org.example.排序;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/***********************************
 *@Desc TODO
 *@ClassName BubbleSorting
 *@Author DLX
 *@Data 2022/5/12 22:43
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class BubbleSorting {
    public static void main(String[] args) {
//        int[] arr = new int[]{3,9,-1,10,-2};
//        int[] arr = new int[]{5,4,2,1,6,7};
//        int[] arr = new int[]{1,2,3,4,5,6,7};
        int[] arr = new int[80000];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*arr.length*10);
        }
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(date));

        System.out.println("原始数组为：");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);//O(n^2)
        long endTime = System.currentTimeMillis();
        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序消耗时间为："+(endTime-startTime)+"ms");
    }
    private static void bubbleSort(int[] arr){
        int temp;
        boolean flag;//判断本次循环中是否有数字交换，没有交换代表已经排序成功，可以直接结束
        for (int j = 1;j < arr.length;j++){
            flag = true;
            for (int i = 0;i < arr.length-j;i++){
                if (arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = false;
                }
            }
//            System.out.println("第"+j+"次排序后数组为：");
//            System.out.println(Arrays.toString(arr));
            if (flag){
                break;
            }
        }
    }
}
