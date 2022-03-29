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
        Node node5 = new Node(4, "ddd");

        System.out.println("无序插入:");
        SingleLinked singleLinked1 = new SingleLinked();
        singleLinked1.addNode(node1);
        singleLinked1.addNode(node4);
        singleLinked1.addNode(node2);
        singleLinked1.addNode(node3);
        singleLinked1.showLinkedList();

        System.out.println("有序插入：");
        SingleLinked singleLinked2 = new SingleLinked();
        singleLinked2.addNodeByOrder(node1);
        singleLinked2.addNodeByOrder(node4);
        singleLinked2.addNodeByOrder(node5);
        singleLinked2.addNodeByOrder(node3);
        singleLinked2.addNodeByOrder(node2);
        singleLinked2.showLinkedList();

        System.out.println("以下例子以有序链表为基础");

        System.out.println("修改链表的值：");
        singleLinked2.update(node5);
        singleLinked2.showLinkedList();

        int index = 3;
        System.out.println("链表倒数第"+index+"位置值为:");
        try {
            System.out.println(getReverseOrderNode(singleLinked2.getHeadNode(),index).toString());
        }catch (Exception e){
            System.out.println("输入的下标不合规。");
        }

        System.out.println("链表倒序为：");
        reversetList(singleLinked2.getHeadNode());
        singleLinked2.showLinkedList();

        System.out.println("删除节点：");
        singleLinked2.deleteNode(3);
        singleLinked2.deleteNode(4);
        singleLinked2.deleteNode(2);
        singleLinked2.showLinkedList();

        System.out.println("链表节点个数为：");
        System.out.println(getLength(singleLinked2.getHeadNode()));

    }

    /**
     * 反转单向链表
     * @param head
     */
    public static void reversetList(Node head){
        if (head.next == null || head.next.next == null){
            return;
        }
        //辅助指针帮助我们遍历原来的链表
        Node temp = head.next;
        Node next = null;//指向当前[temp]节点的下一个节点
        Node reverseHead = new Node(0,"");
        //每遍历一个节点就将当前节点放在 reverseHead 节点的下一个
        while (temp != null){
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中倒数第index个节点
     * @param head
     * @param index
     * @return
     */
    public static Node getReverseOrderNode(Node head,int index){
        int size = getLength(head);
        if (head.next == null || index < 0){
            return null;
        }
        int difference = size - index;
        Node temp = head.next;
        if (difference < 0){
            return null;
        }else {
            for (int i = 0;i < difference;i++){
                temp = temp.next;
            }
        }
        return temp;
    }

    /**
     *
     * @param head 链表的头节点
     * @return 单链表中有效节点的个数（如果是带头节点的需要把头节点去掉）
     */
    public static int getLength(Node head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        Node temp = head.next;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
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
    //根据编号修改节点
    public void update(Node node){
        if (headNode.next == null){
            System.out.println("链表为空！");
            return;
        }
        Node temp = headNode.next;
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
        Node temp = headNode;
        while (temp.next != null){
            if (temp.next.no == no){
                temp.next = temp.next.next;
                if (temp.next == null){
                    break;
                }
            }
            temp = temp.next;
        }
    }

    public Node getHeadNode() {
        return headNode;
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