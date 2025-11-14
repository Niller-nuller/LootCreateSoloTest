import Excecptions.NEGATIVEAMOUNTEXCEPTION;
import Excecptions.NOTENOUGHCREDITSEXCEPTION;
import Excecptions.PLAYERNOTFOUNDEXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LootCrateSystem {
    private final Scanner input = new Scanner(System.in);
    private final List<Player> players = new ArrayList<>();
    private List<LootCreate> crates = new ArrayList<>();

    public LootCrateSystem(){}

    public void addPlayer(){
        System.out.println("Enter player name:");

            String playerName = input.nextLine();
            Player player = new Player(playerName);
            players.add(player);
            System.out.println("Player " + playerName + " has been created.");

    }
    public void addCredits() throws NEGATIVEAMOUNTEXCEPTION, PLAYERNOTFOUNDEXCEPTION {
        System.out.println("Enter credit amount:");
        int amount = input.nextInt();
        if (amount <= 0) {
            throw new NEGATIVEAMOUNTEXCEPTION("You can't enter zero or a negative amount of credits.");
        }
        System.out.println("Enter the player you would like to receive " + amount + ": credits");
        String playerName = input.next();
        Player player = findPlayer(playerName);
        player.addCredits(amount);
        System.out.println("Player " + playerName + " has been received " + amount + " credits.");
    }

    public Player findPlayer(String name) throws PLAYERNOTFOUNDEXCEPTION{
        for (Player player : players) {
            if (player.getName().equals(name)){
                return player;
            }
        }throw new PLAYERNOTFOUNDEXCEPTION("Player name not found.");
    }
    public void displayAllPlayers(){
        for (Player player : players) {
            System.out.println(player.getName() + " has " + player.getCredits() + " credits.");
        }
    }
    public void displayOnePlayer() throws PLAYERNOTFOUNDEXCEPTION {
            System.out.println("Enter player name:");
            String playerName = input.nextLine();
            Player player = findPlayer(playerName);
            System.out.println(player.getName() + " has " + player.getCredits() + " credits.");
            player.displayInventory();
    }
    public void openCrate() throws PLAYERNOTFOUNDEXCEPTION, NOTENOUGHCREDITSEXCEPTION {
        System.out.println("Enter player name:");
        String playerName = input.nextLine();
        Player player = findPlayer(playerName);
        if (player.getCredits() <= 199) {
            throw new NOTENOUGHCREDITSEXCEPTION("You don't have enough credits");
        }
        LootCreate crate = new LootCreate();
        crate.openCrate(player);
    }
    public void defaultPlayers(){
        players.add(new Player("default"));
        players.add(new Player("default2"));
    }
}
