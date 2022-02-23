package org.example.稀疏数组;

/***********************************
 *@Desc TODO
 *@ClassName SparseArray
 *@Author DLX
 *@Data 2022/2/24 0:07
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11(模拟棋盘)
        int chessArr1[][] = new int[11][11];
        //创建棋盘上的两颗棋子
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        System.out.println("原始二维数组：");
        for (int[] row :chessArr1){
            for(int data :row){
                System.out.print(data+"  ");
            }
            System.out.println();
        }
        //遍历二维数组得到非零个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++){
            for (int j = 0; j < chessArr1[i].length; j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        //-----------------------------------------------------------------
        //创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历数组，将非零数组放到sparseArr中
        int count = 0;//记录当前是第几个非零数字
        for (int i = 0; i < chessArr1.length; i++){
            for (int j = 0; j < chessArr1[i].length; j++){
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("生成的稀疏数组：");
        for (int[] row :sparseArr){
            for(int data :row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //-----------------------------------------------------------------
        //将稀疏数组还原为原始二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("还原后的二维数组：");
        for (int[] row :chessArr2){
            for(int data :row){
                System.out.printf("%d  ",data);
            }
            System.out.println();
        }
        //-----------------------------------------------------------------
    }
}
