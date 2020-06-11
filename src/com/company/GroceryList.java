package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {

    //-----------------Fields-----------------//

    private ArrayList<Item> grocery_list;

    //-----------------Methods----------------//

    public GroceryList(){
        this.grocery_list = new ArrayList<>();
    }

    public void addItem(Item itm){
        this.grocery_list.add(itm);
    }

    //find an item in the list and update it's qty
    //TODO: ABSTRACT OUT THE QUESTIONS AND LOGIC TO MAIN, AND USE ARRAY LIST METHODS TO SIMPLY FIND THE ITEM AND RETURN IT BACK
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
                    scan.nextInt();
                    itm.QTY +=1;
                }else{
                    System.out.printf("How many more %s's would you like to remove?",itm.itemName);
                    scan.nextInt();
                    itm.QTY -= 1;
                }
            }
            else{
                System.out.println("Could not find item");
            }
            return;
        }
    }

    //Get the current list
    public void getList(){
        System.out.println("Grocery List");
        for(Item i : grocery_list){
            System.out.printf("Item name: %s\n" +
                    "Quantity: %d\n" +
                    "Description: %s\n" +
                    "\n\n",i.itemName,i.QTY,i.desc);
        }
    }


}
