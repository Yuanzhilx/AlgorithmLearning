package org.example.队列;

/***********************************
 *@Desc TODO
 *@ClassName CircleArrayQueue
 *@Author DLX
 *@Data 2022/3/2 23:17
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(4);
        circleQueue.addQueue(1);
        circleQueue.addQueue(2);
        circleQueue.addQueue(3);
        System.out.println(circleQueue.headQueue());
        System.out.printf("%d\n", circleQueue.getQueue());
        System.out.println(circleQueue.headQueue());
        circleQueue.showQueue();
        circleQueue.addQueue(4);
        System.out.println();
        circleQueue.showQueue();
    }
}
//使用数组模拟队列
class CircleQueue{
    private int maxSize;//数组最大值
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;
    //创建队列的构造器
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头的第一个元素下标
        rear = 0;//指向队列尾最后一个元素的下标+1
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        //当前rear带表的就是新增元素所处的位置
        arr[rear] = n;
        //将rear后移
        rear = (rear + 1) % maxSize;
    }
    //从队列中移出数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        int temp = arr[front];
        //将front后移
        front = (front + 1) % maxSize;
        return temp;
    }
    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空！");
        }
        //从front开始遍历，考虑遍历多少个
        for (int i = front; i < front+size(); i++){
            System.out.print(arr[i % maxSize]+" ");
        }
    }
    //判断队列中有多少数据
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列的头部数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front];
    }
}