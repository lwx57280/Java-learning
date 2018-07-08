package com;

/**
 * 链式存储结构：每个元素只记住它下一个元素是谁（地址）。
 */
public class LinkListDemo {
  /**
   * 结论：
   *
   *    链式存储结构：

   *    优点：插入和删除操作只需改变节点next和prev成员的指向即可，无需移位，无需扩容

   *    缺点：失去了直接存取表中任意位置元素的能力

   *    顺序存储结构和链式存储结构的对比：

   *1、存储分配方式：

   *    顺序存储结构使用一段连续的存储单元依次存储线性表元素

   *            链式存储结构使用任意存储单元存放线性表的元素

   *2、时间性能：

   *    查找：

   *    顺序存储结构O(1)

   *    链式存储结构O(n)

   *    插入和删除：

   *    顺序存储结构O(n)

   *    链式存储结构O(1)

   *3、空间性能：

   *    顺序存储结构：空间分大了浪费，分小了上溢，还得扩容

   *    链式存储结构：有空间就能分配，元素个数不受限制

        言归正传。
   */
    public static void print()throws Exception{
        MyLinkList<String> linkList= new MyLinkList<>();
        linkList.addFirst("张三");
        linkList.addFirst("李四");
        linkList.addLast("张三");
        linkList.addLast("李四");
        linkList.print();
        System.out.println("===========");
        linkList.add(2,"王五");
        linkList.print();
        System.out.println("===========");
        linkList.add(5,"王五");
        System.out.println(linkList.getSize());
        linkList.add(7,"王五");//这里会抛出空指针异常
    }
}
