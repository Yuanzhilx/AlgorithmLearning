package org.example.栈;

import com.sun.org.apache.xerces.internal.impl.dv.xs.FullDVFactory;

/***********************************
 *@Desc TODO
 *@ClassName ArrayStackDemo
 *@Author DLX
 *@Data 2022/4/19 21:31
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        System.out.println("此时栈为：");
        arrayStack.list();
        System.out.println("依次弹出：");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;//top表示栈顶初始为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈已满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    public int showTop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return stack[top];
    }

    public void list(){
        int temp = top;
        while (temp != -1){
            System.out.println("stack["+temp+"]="+stack[temp]);
            temp--;
        }
    }

    public int size(){
        return top+1;
    }
}