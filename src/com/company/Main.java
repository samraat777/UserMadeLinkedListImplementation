package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        String str = "3 4 6 2 3 5 6 2 2 4 52 4 54 2";
        String[] arr = str.split(" ");
        for(String s: arr){
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());

        list.removeItem(new Node("3"));
        list.traverse(list.getRoot());
    }
}
