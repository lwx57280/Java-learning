package com;

public class MyLinkList<E> {
    Node<E> first;
    Node<E> last;

    public void addFirst(E e) {
        if (first == null) {
            // 第一次加入数据，为first,last赋初值
            final Node<E> newNode = new Node<>(null, e, null);
            first = newNode;
            last = newNode;
        } else {
            // 否则把first的prev指向newNode，把newNode的next指向first，最后把newNode变为first
            final Node<E> newNode = new Node<>(null, e, first);
            first.prev = newNode;
            first = newNode;
        }
    }

    public void addLast(E e) {
        if (last == null) {
            // 第一次加入数据，为first,last赋初值
            final Node<E> newNode = new Node<>(null, e, null);
            first = newNode;
            last = newNode;
        } else {
            // 否则把last的next指向newNode，把newNode的prev指向last，最后把newNode变为last
            final Node<E> newNode = new Node<>(last, e, null);
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * 下标超出链表长度会空指针，因为超出长度的部分prev和next都是null
     *
     * @param index
     * @param e
     * @throws Exception
     */
    public void add(int index, E e) throws Exception {
        if (index == 0) {
            addFirst(e);
        } else if (index == getSize()) {
            addLast(e);
        } else {
            // 这里画张图想一下，我要在1处插入x，就要把x的prev指向0，next指向1，把0的next指向x，把1的prev指向x
            // 这里的1和0就是index和index-1，通过循环Node.next获取index对应的Node
            // 先拿到0和1
            Node<E> tempNodeNext = first;
            for (int i = 0; i < index; i++) {
                tempNodeNext = tempNodeNext.next;
            }
            Node<E> tempNodePrev = tempNodeNext.prev;
            // 这里改指向
            final Node<E> newNode = new Node<>(tempNodePrev, e, tempNodeNext);
            tempNodeNext.prev = newNode;
            tempNodePrev.next = newNode;
        }
    }

    //由于不实现Iterable，只能提供打印方法
    public void print() {
        Node<E> temp = first;
        while (temp != null) {
            System.out.println("temp=:" + temp);
            temp = temp.next;
        }
    }

    public int getSize() {
        Node<E> temp = first;
        int i = 0;
        while (temp != null) {
            temp = temp.next;
            i++;
        }
        return i;
    }

    private static class Node<E> {
        E item;
        /**
         * 下一个
         */
        Node<E> next;
        /**
         * 前一个
         */
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            super();
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
