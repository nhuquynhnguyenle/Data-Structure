/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singly.linked.list;

/**
 *
 * @author Admin
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }

    //return true if Mylist is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Person person) {
        Node node = new Node(person);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
            this.size++;
        }
    }

    public void addLast(Person person) {
        Node node = new Node(person);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
            this.size++;
        }
    }

    public void traversal() {
        Node node = head;
        while (node != null) {
            System.out.println(node.person.toString() + "  ");
            node = node.next;
        }
        System.out.println("");
    }

    /*Node searchName(String name) {
        Node node = head;
        while (!name.equalsIgnoreCase(node.person.getName()) && node != null) {
            System.out.println(node.person.toString() + "  ");
            node = node.next;
        }
        return node;
    }*/
    void searchID(int id) {
        /*Node p = head;
        while (p != null && p.person.getID() != id) {
            p = p.next;
        }
        return p;*/
        Node node = head;
        while (node != null) {
            if (node.person.getID() == id) {
                System.out.println(node.person.toString() + "  ");
            }
            node = node.next;
        }
        System.out.println("");
    }

    void searchName(String name) {
        Node node = head;
        while (node != null) {
            if (node.person.getName().contains(name)) {
                System.out.println(node.person.toString() + "  ");
            }
            node = node.next;
        }
        System.out.println("");
    }

    void searchAge(int age) {
        Node node = head;
        while (node != null) {
            if (node.person.getAge() == age) {
                System.out.println(node.person.toString() + "  ");
            }
            node = node.next;
        }
        System.out.println("");
    }

    void searchGender(String gender) {
        Node node = head;
        while (node != null) {
            if (node.person.getGender().equalsIgnoreCase(gender)) {
                System.out.println(node.person.toString() + "  ");
            }
            node = node.next;
        }
        System.out.println("");
    }

    void sortID() {
    }
}
