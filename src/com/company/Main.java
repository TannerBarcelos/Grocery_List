package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {

    //class level scanner field
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        //define new instance of grocery list
        GroceryList groceryList = new GroceryList();

        boolean cont = true;
        //Menu
        while(cont){
            System.out.println("Enter an action:\n" +
                    "1)Add an item\n" +
                    "2)Update an item's quantity\n" +
                    "3)Delete an item\n" +
                    "4)Clear grocery list\n" +
                    "5)See current list\n" +
                    "6)Quit and see summary");
            switch (scan.nextInt()) {
                //enhanced for syntax using lambda ->
                case 1 -> {
                    Item itm = getItem();
                    groceryList.addItem(itm);
                }
                case 2 -> {
                    System.out.println("What item do you wish to update?");
                    scan.nextLine();
                    String item = scan.nextLine();
                    groceryList.updateItem(item);
                }
                case 3 -> {
                    scan.nextLine();
                    System.out.println("Enter the item you wish to delete:");
                    String itm = scan.nextLine();
                    groceryList.deleteItem(itm);
                }
                case 4 -> {
                    groceryList.clearAll();
                }
                case 5 ->{
                    groceryList.getList();
                }
                case 6 -> cont = false;
                default -> System.out.println("Please only enter 1-6");
            }
        }
        System.out.println("Thank you");

    }

    public static @NotNull
    Item getItem(){
        Item itm = new Item();
        scan.nextLine();
        System.out.println("What item are you adding to the list?");
        itm.itemName = scan.nextLine();
        System.out.printf("What is the quantity of %s's you are adding?\n",itm.itemName);
        itm.QTY = scan.nextInt();
        scan.nextLine();
        System.out.println("Please provide a description: ");
        itm.desc = scan.nextLine();
        return itm;
    }
}
