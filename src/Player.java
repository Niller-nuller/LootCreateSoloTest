import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private int credits;
    private final List<String> inventory;

    public Player(String name){
        this.name = name;
        this.credits = 500;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public void addCredits(int amount){
        this.credits += amount;
    }
    public void deductCredits(int amount){
        this.credits -= amount;
    }

    //Print
    public void printPlayerInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Credits: " + getCredits());
        System.out.println("You " + getName() + " own the following items");
        for (String s : inventory) {
            System.out.println("Item: "+s);
        }
    }
    //Add credits

    public void addItem(String item){
        this.inventory.add(item);
    }
    public void displayInventory(){
        for(String item : inventory){
            System.out.println(item);
        }
    }
}
