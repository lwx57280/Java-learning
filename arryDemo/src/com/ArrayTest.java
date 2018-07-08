package com;

/**
 * 数组顺序存储结构:</br>
 * <p>
 * 顺序存储结构：
 * <p>
 * 优点: 1、无需为表示表中元素之间的逻辑关系而添加空间
 * <p>
 * 　　　2、可以快速地存取表中任意位置的元素
 * <p>
 * 缺点: 1、插入和删除操作需要移动大量元素
 * <p>
 * 　　  2、需要考虑索引越界问题
 * <p>
 * 　    3、扩容空间可能会造成空间浪费，缩小空间又可能会索引越界
 * <p>
 * 　    4、null值会造成空间“碎片”
 */
public class ArrayTest {
    public static void main(String[] args) {
        try {
            LinkListDemo.print();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //printArray();
    }

    private static void printArray() {
        Integer[] array = new Integer[10];
        // 向数组中插入元素
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        // 将其中一个元素变为null;
        array[3] = null;
        // 出现碎片
        for (Integer temp : array) {
            System.out.println("temp=:" + temp);
        }
        System.out.println("===========");
        array[3] = 12;//存取方便，可直接赋值或取值

        // 删除第X个元素，但要避免碎片产生:
        int x = 2;
        /// array[x - 1] = null;//第二个元素引用变为null，该步骤可以省略，因为下面又更改了arr[x-1]的引用。写上仅为便于理解
        // 第X个元素之后的元素前移，代码表现为把后面的值依次赋给前面，从第X个开始
        for (int i = x - 1; i < array.length - 1; i++) {
            // i=1,
            System.out.println("array[" + i + "]=" + array[i + 1]);
            array[i] = array[i + 1];
            // array[i] == 2,array[i] == 2

        }
        // length -1，需要新建数组来保存原数组
        Integer[] newArr = new Integer[array.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = array[i];
        }
        System.out.println("newArr ============");
        // 第Y个位置插入一个元素
        int y = 5;

        // 需要后移，所以先创建数组length+1
        Integer[] newArr2 = new Integer[newArr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr2[i] = newArr[i];
        }
        // 后移
        for (int i = newArr2.length - 1; i > y - 1; i--) {
            newArr2[i] = newArr2[i - 1];
        }
        // 插入
        newArr2[y - 1] = 22;
        // 遍历输出
        for (int i = 0; i < newArr2.length; i++) {
            System.out.println("newArr2=:" + newArr2[i]);
        }
    }
}
