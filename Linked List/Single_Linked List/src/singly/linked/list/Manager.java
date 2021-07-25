/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singly.linked.list;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Manager {

    Scanner ip = new Scanner(System.in);

    MyList list = new MyList();
    Node node = new Node();

    Person inputPersonInfo() {
        System.out.print("\nEnter ID: ");
        int id = ip.nextInt();
        System.out.print("\nnEnter Name: ");
        String name = ip.next();
        System.out.print("\nEnter age: ");
        int age = ip.nextInt();
        System.out.print("\nEnter Gender: ");
        String gender = ip.next();
        return new Person(id, name, age, gender);
    }

    void addMany() {
        System.out.print("\nEnter amount of Person (1-10): ");
        int amount = ip.nextInt();
        for (int i = 0; i < amount; i++) {
            list.addLast(inputPersonInfo());
        }
    }

    void addFunction() {
        int functionAdd;
        do {
            System.out.println("\n========== ADD ==========");
            System.out.println("1.1 Add first.");
            System.out.println("1.2 Add last.");
            System.out.println("1.3 Add many.");
            System.out.println("1.4 Return manin menu.");
            System.out.print("Enter number: ");
            functionAdd = ip.nextInt();
            switch (functionAdd) {
                case 1:
                    list.addFirst(inputPersonInfo());
                    break;
                case 2:
                    list.addLast(inputPersonInfo());
                    break;
                case 3:
                    addMany();
                    break;
                default:
                    System.out.println("This function does not exist!");
                    break;
            }
        } while (functionAdd != 4);
    }

    private void searchByName() {
        System.out.print("\nEnter Name: ");
        String name = ip.nextLine();
        list.searchName(name);
    }

    private void searchByAge() {
        System.out.print("\nEnter age: ");
        int age = ip.nextInt();
        list.searchAge(age);
    }

    private void searchByGender() {
        System.out.println("1. List all female.");
        System.out.println("2. List all male.");
        System.out.print("Enter (1-2): ");
        int temp = ip.nextInt();
        if (temp == 1) {
            list.searchGender("female");
        } else {
            list.searchGender("male");
        }
    }

    void searchFunction() {
        int functionSearch;
        do {
            System.out.println("========== SEARCH ==========");
            System.out.println("3.1. Search person by name.");
            System.out.println("3.2. Search person by age.");
            System.out.println("3.3. Search person by gender.");
            System.out.println("3.4. Return main menu.");
            System.out.print("Enter number (1-4): ");
            functionSearch = ip.nextInt();
            ip.nextLine();
            switch (functionSearch) {
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchByAge();
                    break;
                case 3:
                    searchByGender();
                    break;
                default:
                    System.out.println("\nThis function does not exist!");
                    break;
            }

        } while (functionSearch != 4);
    }

    void sortFunction() {
        int sortFunction;
        do {
            System.out.println("========== SORT ==========");
            System.out.println("3.1. Sort by ID.");
            System.out.println("3.2. Sort by Name.");
            System.out.println("3.3. Sort by age.");
            System.out.println("4. Exit.");
            System.out.print("Enter number (1-3)");
            sortFunction = ip.nextInt();
            switch(sortFunction){
                case 1:
                    sortByID();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }

        } while (sortFunction != 4);
    }

    public void menu() {
        int function;
        list.addLast(new Person(1, " Le Thanh Nhan", 20, "male"));
        list.addLast(new Person(2, " Nguyen Le Nhu Quynh", 20, "female"));
        list.addLast(new Person(3, " Vo Tue Nam", 20, "male"));
        list.addLast(new Person(4, " Pham Hong Sang", 20, "male"));
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add.");
            System.out.println("2. Insert.");
            System.out.println("3. Search.");
            System.out.println("4. Sort");
            System.out.println("5. Delete.");
            System.out.println("6. List all.");
            System.out.println("7. Exit");
            System.out.print("Enter function: ");
            function = ip.nextInt();
            switch (function) {
                case 1:
                    addFunction();
                    break;
                case 2:
                    break;
                case 3:
                    searchFunction();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    list.traversal();
                    break;
                case 7:
                    System.out.println("GOOD BYE");
                    break;
                default:
                    break;
            }
        } while (function != 7);

    }

    private void sortByID() {
        System.out.println("Enter ID: ");
        int sortID = ip.nextInt();
        list.sortID();
    }
    

}
