package org.example.链表;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/***********************************
 *@Desc TODO
 *@ClassName SingleLinkedList
 *@Author DLX
 *@Data 2022/3/9 23:48
 *@Since JDK1.8
 *@Version 1.0
 ***********************************/
public class SingleLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1, "aaa");
        Node node2 = new Node(2, "bbb");
        Node node3 = new Node(3, "ccc");
        Node node4 = new Node(4, "ccc");

        SingleLinked singleLinked1 = new SingleLinked();
        singleLinked1.addNode(node1);
        singleLinked1.addNode(node4);
        singleLinked1.addNode(node2);
        singleLinked1.addNode(node3);
        singleLinked1.showLinkedList();

        SingleLinked singleLinked2 = new SingleLinked();
        singleLinked2.addNodeByOrder(node1);
        singleLinked2.addNodeByOrder(node4);
        singleLinked2.addNodeByOrder(node4);
        singleLinked2.addNodeByOrder(node3);
        singleLinked2.addNodeByOrder(node2);
        singleLinked2.showLinkedList();

    }
}
//定义链表管理节点
class SingleLinked{
    //初始化一个头节点，头节点不要动,不存放具体数据
    private Node headNode = new Node(0,"");
    //添加节点到单向链表
    //1.找到当前链表的最后节点
    //2.将最后节点的next指向新的节点
    public void addNode(Node node){
        //因为head节点不能同我们新建一个辅助节点
        Node temp = headNode;
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
    }

    public void addNodeByOrder(Node node){
        //因为头节点不能动，我们使用一个辅助指针来找到添加的位置、
        Node temp = headNode;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }else if (temp.next.no > node.no){
                break;
            }else if (temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断falg
        if (flag){
            //说明编号存在不能添加
            System.out.printf("准备插入的节点编号 %d 已经存在！\n",node.no);
        }else {
            //插入到链表中
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void showLinkedList(){

        //判断是否为空
        if (headNode.next == null){
            System.out.println("链表为空！");
            return;
        }
        Node temp = headNode.next;
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
class Node{
    public int no;
    public String name;
    public Node next;
    //构造器
    public Node(int no, String name) {
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