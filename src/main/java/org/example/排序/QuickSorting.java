package org.example.排序;

import java.util.Arrays;

/***********************************
 *@Desc TODO
 *@ClassName QuickSort
 *@Author DLX
 *@Data 2022/6/6 20:03
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class QuickSorting {
    public static void main(String[] args) {
//        int[] arr = new int[]{0,7,2,4,4,7,0};
        int[] arr = new int[80000];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*arr.length*10);
        }
        System.out.println("原始数组为：");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);//O(n^2)
        long endTime = System.currentTimeMillis();
        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序消耗时间为："+(endTime-startTime)+"ms");
    }
    public static void quickSort(int[] arr,int left,int reight){
        int l = left;
        int r = reight;
        int pivot = arr[(left+reight)/2];
        int temp;
        int i = 4;
        while (l < r){
            while (arr[l] < pivot){
                l++;
            }
            while (pivot < arr[r]){
                r--;
            }
            if (l >= r){
                break;
            }
//            System.out.println(Arrays.toString(arr)+" "+l+" "+r);
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[r] == pivot){
                r--;
            }
            if (arr[l] == pivot){
                l++;
            }
//            System.out.println(Arrays.toString(arr)+" "+l+" "+r);
        }
        if (l == r){
            l++;
            r--;
        }
        if (left < r){
            quickSort(arr,left,r);
        }
        if (l<reight){
            quickSort(arr,l,reight);
        }

    }
}
