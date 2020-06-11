package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {

    //-----------------Fields-----------------//

    private final ArrayList<Item> grocery_list;

    //-----------------Methods----------------//

    //initialize grocery list [array_list]
    public GroceryList(){
        this.grocery_list = new ArrayList<>();
    }

    //add item to grocery list
    public void addItem(Item itm){
        this.grocery_list.add(itm);
    }

    //find an item in the list and update it's qty
    public void updateItem(String item){
        if(this.grocery_list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        //find this item
        for(Item itm : grocery_list){
            if(itm.itemName.equals(item)){
                System.out.println("Increment or decrement? [+ / -]");
                Scanner scan = new Scanner(System.in);
                String choice = scan.nextLine();
                if(choice.equals("+")){
                    System.out.printf("How many more %s's would you like to add?",itm.itemName);
                    itm.QTY += scan.nextInt();
                }else{
                    System.out.printf("How many more %s's would you like to remove?",itm.itemName);
                    itm.QTY -= scan.nextInt();
                }
            }
            else{
                System.out.println("Could not find item");
            }
            return;
        }
    }

    //delete item by given item name to find
    public void deleteItem(String itm){
        if(this.grocery_list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        //find this item
        for(Item itm_ : grocery_list){
            if(itm_.itemName.equals(itm)){
                int ind = this.grocery_list.indexOf(itm_);
                System.out.println("Item deleted");
                this.grocery_list.remove(ind);
            }
            else{
                System.out.println("Could not find item");
            }
            return;
        }
    }

    //clear list
    public void clearAll(){
        this.grocery_list.clear();
    }

    //Get the current list
    public void getList(){
        if(this.grocery_list.isEmpty()){
            System.out.println("No list contents");
            return;
        }

        System.out.println("#-----------------------------------#");
        System.out.println("\n\t\t\t\tGrocery List");
        for(Item i : grocery_list){
            System.out.printf("Item name: %s\n" +
                    "Quantity: %d\n" +
                    "Description: %s\n" +
                    "\n\n",i.itemName,i.QTY,i.desc);
        }
        System.out.println("#-----------------------------------#");
    }


}
