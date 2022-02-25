package org.example.队列;

import java.util.Scanner;

/***********************************
 *@Desc TODO
 *@ClassName ArrayQueue
 *@Author DLX
 *@Data 2022/2/26 0:15
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class ArrayQueue {
    public static void main(String[] args) {
        ArrQueue arrQueue = new ArrQueue(3);
//        Scanner scanner = new Scanner(System.in);
//        char key = scanner.next().charAt(0);
//        scanner.close();
        arrQueue.addQueue(1);
        arrQueue.addQueue(2);
        arrQueue.addQueue(3);
        System.out.println(arrQueue.headQueue());
        System.out.printf("%d\n", arrQueue.getQueue());
        System.out.println(arrQueue.headQueue());
        arrQueue.showQueue();

    }
}
//使用数组模拟队列
class ArrQueue{
    private int maxSize;//数组最大值
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;
    //创建队列的构造器
    public ArrQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一位
        rear = -1;//指向队列尾
    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }
    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满！");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    //从队列中移出数据
    public int getQueue(){
       if (isEmpty()){
           throw new RuntimeException("队列为空！");
       }
       front++;
       return arr[front];
    }
    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空！");
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    //显示队列的头部数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front+1];
    }
}