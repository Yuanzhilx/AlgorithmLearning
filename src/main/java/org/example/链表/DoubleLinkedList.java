package org.example.链表;

import java.util.Stack;

/***********************************
 *@Desc TODO
 *@ClassName DoubleLinkedList
 *@Author DLX
 *@Data 2022/4/14 22:34
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class DoubleLinkedList {
    public static void main(String[] args) {
        Node2 node1 = new Node2(1,"aaa");
        Node2 node2 = new Node2(2,"bbb");
        Node2 node3 = new Node2(3,"ccc");
        Node2 node4 = new Node2(4,"ddd");
        Node2 node5 = new Node2(3,"sss");
        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.addNode(node1);
        doubleLinked.addNode(node2);
        doubleLinked.addNode(node3);
        doubleLinked.addNode(node4);

        System.out.println("输出链表内容：");
        doubleLinked.showLinkedList();

        System.out.println("修改节点内容：");
        doubleLinked.update(node5);
        doubleLinked.showLinkedList();

        System.out.println("反向输出双向链表");
        reversPrint(doubleLinked.getHeadNode());

        System.out.println("删除节点后链表：");
        doubleLinked.deleteNode(4);
        doubleLinked.deleteNode(1);
        doubleLinked.showLinkedList();



    }
    /**
     * 逆序打印双向链表
     * @param head
     */
    public static void reversPrint(Node2 head){
        if (head.next == null){
            System.out.println("空链表无法打印！");
        }
        //将数据一个个压入栈中
        Node2 temp = head.next;
        while (temp.next != null){
            temp = temp.next;
        }
        while (temp.pre != null){
            System.out.println(temp.toString());
            temp = temp.pre;
        }
    }
}
class DoubleLinked{
    private Node2 headNode = new Node2(0,"");
    public void addNode(Node2 node){
        //因为head节点不能同我们新建一个辅助节点
        Node2 temp = headNode;
        //遍历链表找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有到最后就继续向下查找
            temp = temp.next;
        }
        //跳出循环代表temp已经指向最后节点了
        temp.next = node;
        node.pre = temp;
    }
    //根据编号修改节点
    public void update(Node2 node){
        if (headNode.next == null){
            System.out.println("链表为空！");
            return;
        }
        Node2 temp = headNode.next;
        boolean falg = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == node.no){
                //找到元素
                falg = true;
                break;
            }
            temp = temp.next;
        }
        if (falg){
            temp.name = node.name;
        }else {
            System.out.printf("没有找到编号%d的节点\n",node.no);
        }
    }
    //根据编号删除节点
    public void deleteNode(int no){
        if (headNode.next == null){
            System.out.println("链表为空！");
            return;
        }
        Node2 temp = headNode.next;
        while (temp != null){
            if (temp.no == no){
                temp.pre.next = temp.next;
                if (temp.next != null){
                    temp.next.pre = temp.pre;
                }
            }
            temp = temp.next;
        }
    }
    public Node2 getHeadNode() {
        return headNode;
    }
    public void showLinkedList(){
        //判断是否为空
        if (headNode.next == null){
            System.out.println("链表为空！");
            return;
        }
        Node2 temp = headNode.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

}
//定义node节点
class Node2{
    public int no;
    public String name;
    public Node2 pre;//指向前一个节点
    public Node2 next;//指向后一个节点
    //构造器
    public Node2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}