/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_3;

/**
 *
 * @author Admin
 */
public class Stack {

    class Node {

        int data;

        public Node(int data) {
            this.data = data;
        }

    }
    Node arrayNode[];
    int capacity;
    int lastIndex;

    public Stack(int capacity) {
        this.arrayNode = new Node[capacity];
        this.capacity = capacity;
        this.lastIndex = -1;
    }

    public Stack() {
        this(5);
    }

    public boolean isEmpty() {
        return lastIndex == - 1;
    }

    public boolean isfull() {
        return lastIndex == capacity - 1;
    }

    public void resize() {
        int newCapacity = capacity * 2;
        Node[] newArrNode = new Node[newCapacity];
        for (int i = 0; i <= lastIndex; i++) {
            newArrNode[i] = arrayNode[i];
        }
        capacity = newCapacity;
        arrayNode = newArrNode;
    }

    public void push(int data) {
        if (isfull()) {
            resize();

        }
        arrayNode[++lastIndex] = new Node(data);

    }

    public Node pop() {
        if (isEmpty()) {
            System.out.println("The list is empty!");
            return null;
        }
        return arrayNode[lastIndex--];
    }

    public int get() {
        if (isEmpty()) {
            System.err.println("The list is empty!");
            return -1;
        } else {
           return arrayNode[lastIndex].data;

        }

    }

    public void display() {
        for (int i = 0; i <= lastIndex; i++) {
            System.out.print(arrayNode[i].data + " ");
        }
        System.out.println();
    }



}
