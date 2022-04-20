package org.example.栈;

import java.util.*;

/***********************************
 *@Desc TODO
 *@ClassName PolandNotation
 *@Author DLX
 *@Data 2022/4/20 21:25
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class PolandNotation {
    public static void main(String[] args) {
        //(3+4)*5-6 ->  3 4 + 5 * 6 -
        //为了方便数字和符号用空格隔开
//        String str = "(3+4)*5-6";
        String str = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(str);
        List<String> suffixExpression = parseSuffixExpressionList(infixExpressionList);
        System.out.println(str+" -> "+suffixExpression+"="+calculate(suffixExpression));
    }

    /**
     * 将得到的一个中缀表达式集合转为后缀表达式集合
     * @param infixExpressionList 中缀表达式结合
     * @return 后缀表达式集合
     */
    public static List<String> parseSuffixExpressionList(List<String> infixExpressionList){
        Stack<String> s1 = new Stack<>();//符号栈
        ArrayList<String> s2 = new ArrayList<>();//存储结果
        for (String item : infixExpressionList){
            //如果是数字直接进入结果集合
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //当item优先级<s1栈顶的优先级
                while (s1.size() != 0 && priority(s1.peek()) >= priority(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入s1
                s1.push(item);
            }
        }
        //将s1中剩余运算符加入s2中
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    /**
     * 将一个中缀表达式拆分并写入集合
     * @param str 中缀表达式
     * @return 拆分后的集合
     */
    public static List<String> toInfixExpressionList(String str){
        ArrayList<String> arrayList = new ArrayList<>();
        //对多位数拼接
        String temp = "";
        for (int i = 0;i < str.length();i++){
            temp = temp + str.charAt(i);
            if (i+1 < str.length() && (str.charAt(i+1)+"").matches("[+|\\-|*|/|(|)]") || (str.charAt(i)+"").matches("[+|\\-|*|/|(|)]")){
                arrayList.add(temp);
                temp = "";
            }else if (i == str.length()-1){
                arrayList.add(temp);
            }
        }
        return arrayList;
    }

    /**
     * 将字符串按空格拆分并返回list
     * @param suffixExpression 逆波兰字符串
     * @return list
     */
    public static List<String> getListSting(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, split);
        return list;
    }

    /**
     * 计算表达式：从左向右扫描数字入栈，操作符就弹出两个数字进行运算
     * @param list 表达式集合
     * @return 计算结果
     */
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String item:list){
            //判断是否是数字
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                stack.push(cal(Integer.parseInt(stack.pop()),Integer.parseInt(stack.pop()),item)+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static int cal(int num1,int num2,String oper){
        switch (oper){
            case "+":
                return num2+num1;
            case "-":
                return num2-num1;
            case "*":
                return num2*num1;
            case "/":
                return num2/num1;
        }
        throw new RuntimeException("运算符异常");
    }
    /**
     * 判断运算符优先级，以数字表示，数字越大优先级越高，-1表示输入有问题
     * @param oper 运算符
     * @return 优先级
     */
    public static int priority(String oper){
        if (oper.equals("*") || oper.equals("/")){
            return 2;
        }else if (oper.equals("+") || oper.equals("-")){
            return 1;
        }else {
            return 0;
        }
    }
}
