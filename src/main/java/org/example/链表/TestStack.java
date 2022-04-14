package org.example.链表;


import java.util.Stack;

/***********************************
 *@Desc TODO
 *@ClassName TestStack
 *@Author DLX
 *@Data 2022/4/14 22:12
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("aaa");
        stack.add("bbb");
        stack.add("ccc");
        stack.add("ddd");
        //出栈
        while (stack.size()>0){
            System.out.println(stack.pop());//将栈顶的数据弹出
        }
    }
}
