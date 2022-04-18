package org.example.链表;

/***********************************
 *@Desc TODO
 *@ClassName Josephu
 *@Author DLX
 *@Data 2022/4/18 22:03
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        System.out.println("死亡顺序：");
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
//创建一个环形单向链表
class CircleSingleLinkedList{
    public Boy first;
    //添加小孩节点构建环形链表
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("输入的值不正确");
            return;
        }
        Boy curboy = null;
        for (int i = 1; i <= nums; i++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if ( i == 1){
                first = boy;
                first.setNext(first);
                curboy = first;
            }else {
                curboy.setNext(boy);
                boy.setNext(first);
                curboy = boy;
            }
        }
    }
    //遍历当前环形链表
    public void showBoy(){
        if (first == null){
            System.out.println("链表为空！");
            return;
        }
        Boy curBoy = first;
        do{
            System.out.println(curBoy);
            curBoy = curBoy.getNext();
        }while(curBoy != first);
    }

    /**
     * 根据用户的输入，计算小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始
     * @param coutnNum 表示数几个数
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int coutnNum,int nums){
        if (first == null || startNo < 1 || startNo >nums){
            System.out.println("参数输入不正确！");
            return;
        }
        //helper移动到first前一个位置,first指向第一个报数的小孩
        Boy helper = first;
        while (true){
            helper = helper.getNext();
            first = helper.getNext();
            if (first.getNo() == startNo){
                break;
            }
        }
        //记录数字数到哪里
        int run = 1;
        while (true){
            //当两个指针指向同一个节点时，证明该节点为最后节点，直接输出即可
            if (helper == first){
                System.out.println(first);
                break;
            }
            if (run < coutnNum){
                //当数字小于间隔时，指针向前移动
                helper = helper.getNext();
                first = first.getNext();
                run ++;
            }else {
                //当数字等于间隔时，删除节点并重置记录
                System.out.println(first);
                first = first.getNext();
                helper.setNext(first);
                run = 1;
            }
        }

    }
}

class Boy{
    private int no;//编号
    private Boy next;//next域

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{ no = " + no + " }";
    }
}

