import Excecptions.NOTENOUGHCREDITSEXCEPTION;

import java.lang.System;
import java.util.Random;

public class LootCreate {

    private final int price;
    private String contents = LootCreateContents();

    public LootCreate(){
        this.price = 200;
        this.contents = LootCreateContents();
    }

    public String LootCreateContents(){
        Random rand = new Random();
        int number = rand.nextInt(5) + 1;
        return switch (number){
            case 1 -> "A golden box";
            case 2 -> "A brown reward";
            case 3 -> "A shiny tin coin";
            case 4 -> "A silver coin";
            case 5 -> "A platinum coin";
            default -> "Something went wrong with the random generation";
        };
    }
    public void openCrate(Player player)throws NOTENOUGHCREDITSEXCEPTION {
        if(player.getCredits() >= getCratePrice()){
            player.deductCredits(getCratePrice());
            System.out.println("You got + "+ contents);
            player.addItem(contents);
        }
        else {
            throw new NOTENOUGHCREDITSEXCEPTION("You don't have enough credit to do this.");
        }
    }
    public int getCratePrice(){
        return this.price;
    }
}
