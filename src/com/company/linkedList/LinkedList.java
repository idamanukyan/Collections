package com.company.linkedList;


import com.company.GenericIterator;

public class LinkedList implements GenericIterator<Node> {

    Node head;
    Node tail;
    int size;

    public void addFirst(int element) {
        Node node = new Node(element);

        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
        size++;

    }

    public void addLast(int element) {
        Node node = new Node(element);

        if (head == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void add(int position, int element) {
        Node newNode = new Node(element);
        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        Node nextNode = current.next;
        current.next = newNode;
        newNode.prev = current;
        nextNode.prev = newNode;
        newNode.next = nextNode;

        size++;

    }

    public Node get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public Node getFirst() {
        return head;
    }

    public Node getLast() {
        return tail;
    }

    public void print() {
        while (hasNext()) {
            System.out.println(next());
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public void removeElementOfIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node prevNode = current.prev;
        Node nextNode = current.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

    public void removeElement(int element) {

        Node node = head;
        int index = 0;

        while (node != null) {
            if (node.value == element) {
                removeElementOfIndex(index);
            }
            node = node.next;
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        Node current = head;
        return current != null;
    }

    @Override
    public Node next() {
        Node current = head;
        if (hasNext()) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void remove() {
        Node current = head;
        Node prevNode = current.prev;
        Node nextNode = current.next;

        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
        }

        current = prevNode;
        size--;
    }

}
