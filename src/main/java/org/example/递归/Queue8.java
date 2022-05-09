package org.example.递归;

/***********************************
 *@Desc TODO
 *@ClassName Queue8
 *@Author DLX
 *@Data 2022/5/9 22:50
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class Queue8 {
    //最大有多少个皇后
    int max = 8;
    //结果集数组
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("共有"+count+"种解法！");
    }

    /**
     * 放置皇后的方法
     * @param n 放置第n个皇后（0-7）
     */
    public void check(int n){
        if (n == max){//n的最大值为7，当n==max时说明已经放好了
            print();
            return;
        }
        //一次放入皇后判断是否冲突
        for (int i = 0;i < max;i++){
            //想把这个皇后放到当前行的第一列
            array[n] = i;
            //判断是否冲突
            if (judge(n)){
                //不冲突就放下一个皇后
                check(n + 1);
            }
            //冲突就在当前行的下一列放置皇后一直到所有列都尝试过
        }
    }

    /**
     * 查看我们防止第n个皇后后就去检查与之前放置的皇后是否冲突
     * @param n 第几个皇后（0-7）
     * @return 判断结果
     */
    public boolean judge(int n){
        for (int i = 0;i < n;i++){
            //判断皇后是否在同一列 || 判断是否在同意斜线（斜率）
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 输出当前结果
     */
    public void print(){
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i]+" ");
        }
        count++;
        System.out.println();
    }
}
