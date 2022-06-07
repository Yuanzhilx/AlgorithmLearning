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
        int[] arr = new int[]{5,7,3,4,8,7,9};
//        int[] arr = new int[80000];
//        for (int i = 0;i<arr.length;i++){
//            arr[i] = (int)(Math.random()*arr.length*10);
//        }
        System.out.println("原始数组为：");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);//O(n^2)
        long endTime = System.currentTimeMillis();
        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序消耗时间为："+(endTime-startTime)+"ms");
        for (int i = 0;i<arr.length-1;i++){
            if (arr[i] > arr[i+1]){
                System.out.println("=========ERROR!========="+i+":"+arr[i]+"_"+arr[i+1]);
                break;
            }
        }
    }
    public static void quickSort(int[] arr,int left,int reight){
        int l = left;//数组左侧(起始)下标
        int r = reight;//数组右侧(结束)下标
        int pivot = arr[(left+reight)/2];//默认数组中值大小（从数组中间位置取值）
        int temp;
        //判断l < r 说明此时左右都没有遍历完成，指针没有交叉
        while (l < r){
            //当左侧数据小于中间值时说明该数据处于正确位置，指针向后移动
            while (arr[l] < pivot){
                l++;
            }
            //当右侧数据小于中间值时说明该数据处于正确位置，指针向前移动
            while (pivot < arr[r]){
                r--;
            }
            //当指针移动后出现相等和交叉的情况时说明数据已经都遍历完成，没有需要交换的情况，跳过下方逻辑
            if (l >= r){
                break;
            }
            System.out.println(Arrays.toString(arr)+" "+l+" "+r);
            //交换左右数据
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //数据交换后判断是否交换到了中值，因为指针指向中值后无法再进行移动，所以手动将指针向中心移动，跳过中值。
            if (arr[r] == pivot){
                l++;

            }
            if (arr[l] == pivot){
                r--;
            }
            System.out.println(Arrays.toString(arr)+" "+l+" "+r);
        }
        //当l == r时说明指针处于相同元素，这时直接执行递归调用会导致该元素出现在两次递归中，中值本身位置固定已经不需要排序，所以我们移动下标跳过中值
        if (l == r){
            l++;
            r--;
        }
        //对中值左右的数据进行递归排序
        if (left < r){
            quickSort(arr,left,r);
        }
        if (l<reight){
            quickSort(arr,l,reight);
        }
    }
}
