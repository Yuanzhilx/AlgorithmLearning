package org.example.排序;

import java.util.Arrays;

/***********************************
 *@Desc TODO
 *@ClassName ShellSorting
 *@Author DLX
 *@Data 2022/6/1 16:58
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class ShellSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
//        int[] arr = new int[80000];
//        for (int i = 0;i<arr.length;i++){
//            arr[i] = (int)(Math.random()*arr.length*10);
//        }
        System.out.println("原始数组为：");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        shellSort(arr);//O(nlogn)
        long endTime = System.currentTimeMillis();
        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序消耗时间为："+(endTime-startTime)+"ms");
    }
    //交换法
    public static void shellSort(int[] arr){
        int temp;
        //计算总共需要按多少次不同的步长进行排序
        for (int length = arr.length/2;length >= 1;length/=2){
            //从步长位开始依次向后遍历，根据有多少数据限制循环次数
            for (int i = length;i < arr.length;i++){
                //第j位开始遍历，每次向后移动步长个单位，依次比较两个数据大小（冒泡）
                for (int j = i-length;j >= 0;j -= length){
                    //每轮遍历只向后判断一次大小
                    if (arr[j] > arr[j+length]){
                        temp = arr[j];
                        arr[j] = arr[j+length];
                        arr[j+length] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    //移位法
    public static void shellSort1(int[] arr){
        int temp;
        int j;
        //计算总共需要按多少次不同的步长进行排序
        for (int length = arr.length/2;length >= 1;length/=2){
            //从步长位开始依次向后遍历，根据有多少数据限制循环次数
            for (int i = length;i < arr.length;i++){
                //第j位开始遍历，每次向后移动步长个单位，依次比较两个数据大小（冒泡）
                temp = arr[i];
                for (j = i-length;j >= 0;j -= length){
                    if (temp < arr[j]){
                        arr[j+length] = arr[j];
                    }else break;
                }
                arr[j+length] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
