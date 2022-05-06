package org.example.递归;

/***********************************
 *@Desc TODO
 *@ClassName MiGong
 *@Author DLX
 *@Data 2022/5/6 23:00
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class MiGong {
    public static void main(String[] args) {
        //使用二维数组构建迷宫
        //使用1表示墙,填充迷宫周围
        int[][] map = new int[8][7];
        for (int i = 0;i < map[0].length;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0;i < map.length;i++){
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("当前地图情况：");
        for (int i = 0;i < map.length;i++){
            for (int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("是否找到终点："+setWay(map, 1, 1, 6, 5));
        System.out.println("走过并标识后的路径：");
        for (int i = 0;i < map.length;i++){
            for (int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

    /**
     * 查找路径，走迷宫时按照下右上左的策略来前进
     * @param map 表示地图 0代表没有走过，1代表墙，2代表可以走，3代表可以走但是走不通
     * @param i 出发点横坐标
     * @param j 出发点纵坐标
     * @param k 终点横坐标
     * @param l 终点纵坐标
     * @return 找到了就返回true
     */
    public static boolean setWay(int[][] map ,int i,int j,int k,int l){
        if (map[k][l] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;//先假定可以走通
                //向下走
                if (setWay(map,i+1,j,k,l)){
                    return true;
                }else if (setWay(map,i,j+1,k,l)){
                    return true;
                }else if (setWay(map,i-1,j,k,l)){
                    return true;
                }else if (setWay(map,i,j-1,k,l)){
                    return true;
                }else {
                    //说明该点走不通是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
    //修改策略为上右下左
    public static boolean setWay2(int[][] map ,int i,int j,int k,int l){
        if (map[k][l] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;//先假定可以走通
                if (setWay2(map,i-1,j,k,l)){
                    return true;
                }else if (setWay2(map,i,j+1,k,l)){
                    return true;
                }else if (setWay2(map,i+1,j,k,l)){
                    return true;
                }else if (setWay2(map,i,j-1,k,l)){
                    return true;
                }else {
                    //说明该点走不通是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
