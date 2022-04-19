package org.example.栈;

import com.sun.org.apache.bcel.internal.generic.NEW;

/***********************************
 *@Desc TODO
 *@ClassName Calculator
 *@Author DLX
 *@Data 2022/4/19 22:08
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class Calculator {
    public static void main(String[] args) {
        //运算式
//        String expression = "2+2*3-2*2-1";
        String expression = "2+6-4-1";
        //创建两个栈，一个存放数字，一个存放符号
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        //用于扫描运算式
        int index = 0;
        //用于存放每次扫描的结果
        char ch = ' ';
        //用于处理多位数
        String keepNum = "";
        //遍历表达式进行入栈操作
        while (index != expression.length()){
            ch = expression.charAt(index);
            //判断是否为操作符
            if (isOper(ch)){
                //当符号栈为空的时候直接放入
                if (operStack.isEmpty()){
                    operStack.push(ch);
                }else if (priority(ch) >= priority((char)operStack.showTop())){
                    //当两个减号同时计算的时候存在bug，例如：2+6-4-1=5 会先计算4-1再计算2+6-3
                    //当符号栈中符号优先级小于等于当前符号时直接放入
                    operStack.push(ch);
                }else {
                    //当符号栈中符号优先级大于当前符号时，取出符号和数字进行计算
                    numStack.push(cal(numStack.pop(),numStack.pop(),(char)operStack.pop()));
                    operStack.push(ch);
                }
            }else {
                keepNum = keepNum + ch;
                if (index == (expression.length() - 1) || isOper(expression.charAt(index+1))) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }
            index++;
        }
        numStack.list();
        System.out.println("=============");
        operStack.list();
        //对之前入栈的数据进行计算，一直计算到只有数栈一位数字，代表已经计算完毕
        while (numStack.size() != 1){
            numStack.push(cal(numStack.pop(),numStack.pop(),(char)operStack.pop()));
        }
        System.out.println(expression+"="+numStack.pop());
    }

    /**
     * 判断运算符优先级，以数字表示，数字越大优先级越高，-1表示输入有问题
     * @param oper 运算符
     * @return 优先级
     */
    public static int priority(char oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     * @param val 字段
     * @return 是否
     */
    public static boolean isOper(char val){
        return val == '+' || val == '-' ||val == '*' ||val == '/' ;
    }

    /**
     * 进行运算
     * @param num1 数字1
     * @param num2 数字2
     * @param oper 运算符
     * @return 结果
     */
    public static int cal(int num1,int num2,char oper){
        switch (oper){
            case '+':
                return num2+num1;
            case '-':
                return num2-num1;
            case '*':
                return num2*num1;
            case '/':
                return num2/num1;
        }
        throw new RuntimeException("运算符异常");
    }

}
