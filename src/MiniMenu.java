import Excecptions.NEGATIVEAMOUNTEXCEPTION;
import Excecptions.NOTENOUGHCREDITSEXCEPTION;
import Excecptions.PLAYERNOTFOUNDEXCEPTION;

import java.lang.System;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MiniMenu {

    private final LootCrateSystem interact = new LootCrateSystem();

    public MiniMenu() {}

    public void userMenu() {
        Scanner input = new Scanner(System.in);
        interact.defaultPlayers();
        menuInitialInfo();
        while (true) {
            try {
                menuInfo();
                switch (input.nextInt()) {
                    case 1 -> interact.addPlayer();
                    case 2 -> interact.displayAllPlayers();
                    case 3 -> interact.displayOnePlayer();
                    case 4 -> interact.openCrate();
                    case 5 -> interact.addCredits();
                    case 6 -> System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 1 and 6");
                input.nextLine();
            } catch (NEGATIVEAMOUNTEXCEPTION e) {
                System.out.println("You cannot add zero or a negative amount to credits");
                input.nextLine();
            } catch (NOTENOUGHCREDITSEXCEPTION e) {
                System.out.println("You don't have enough credits");
                input.nextLine();
            } catch (PLAYERNOTFOUNDEXCEPTION e) {
                System.out.println("A Player of that name could not be found");
                input.nextLine();
            }
        }
    }
    public void menuInfo(){
        System.out.println();
        System.out.println("Press 1. To create a new player.");
        System.out.println("Press 2. To display all players.");
        System.out.println("Press 3. To display a specific player's credits.");
        System.out.println("Press 4. To buy a loot create");
        System.out.println("Press 5. To add more credits to a specific player");
        System.out.println("Press 6. To end");
        System.out.println("Please enter your choice");
    }
    public void menuInitialInfo(){
        System.out.println("Hello and welcome");
        System.out.println("You can choose different options with the use of the keyboards number pads.");
        System.out.println("You can see the options below");
    }
}
