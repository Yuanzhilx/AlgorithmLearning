package org.example.递归;

public class RecursionTest {
    public static void main(String[] args) {
        //回顾递归的调用机制
        test(4);
        System.out.println("res = "+factorial(1));
    }
    public static void test(int n){
        if (n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }
}
