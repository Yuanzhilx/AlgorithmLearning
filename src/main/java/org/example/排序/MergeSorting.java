package org.example.排序;


import java.lang.reflect.Array;
import java.util.Arrays;

/***********************************
 *@Desc TODO
 *@ClassName MergeSorting
 *@Author DLX
 *@Data 2022/6/14 20:05
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
//        int[] arr = {7,1,3};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid+1,right,temp);
            //合并：执行到这里说明左右递归都已完成
            merge(arr,left,mid,right,temp);
        }

    }
    /**
     * 合并的方法
     * @param arr 待排序的数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param rihgt 右边索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr,int left,int mid,int rihgt,int[] temp){
        int i = left;//左边的初始索引
        int j = mid +1;//右边的初始索引
        int t = 0;//指向temp数组的当前索引
        while (i <= mid && j <= rihgt){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= rihgt){
            temp[t] = arr[j];
            t++;
            j++;
        }
        int tempRingt = rihgt;
        while (tempRingt >= left){
            arr[tempRingt] = temp[--t];
            tempRingt--;
        }

    }
}
