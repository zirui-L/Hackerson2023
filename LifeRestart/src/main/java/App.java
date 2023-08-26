import Player.Person;
import Player.PlayerStats;
import Stage.*;

import java.util.Scanner;

public class App {

    private static PlayerStats stats;
    private static Person player;
    public static void startInfo(){
        System.out.println("\n-------------------------------------------------\n" +
                "Welcome to Our LifeRestart Game: ");
        System.out.println("Now! Give Birth to yourself!");
        System.out.println("Please enter the value in the following order (i.e. 5,5,5,5)\n" +
                "1. Health\n" +
                "2. Wealth\n" +
                "3. Charm\n" +
                "4. IQ" +
                "\n-------------------------------------------------\n");
    }

    public static void initialisedPlayer(){
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()){
            String[] line = sc.nextLine().split(",");
            long health = Long.parseLong(line[0]);
            long wealth = Long.parseLong(line[1]);
            long charm = Long.parseLong(line[2]);
            long iq = Long.parseLong(line[3]);
            player = new Person(health, wealth, charm, iq, 20);
            stats = player.getStats();

        }
    }

    public static void displayAttribute(){
        System.out.println("\n-------------------------------------------------\n" +
                "[Health: " + stats.getHealth() +
                " Wealth: " + stats.getWealth() +
                " Charm: " + stats.getCharm() +
                " IQ: " + stats.getIQ()
                + " Happiness: " + stats.getHappiness() + "]" +
                "\n-------------------------------------------------\n");
    }

    public static void gameStart(){
        System.out.println("\n-------------------------------------------------\n"+
                "Congrats! A star is born, enjoy your new life!");
        System.out.println("Initially, Your attribute value are\n" +
                "Health: " + stats.getHealth() + "\n" +
                "Wealth: " + stats.getWealth() + "\n" +
                "Charm: " + stats.getCharm() + "\n" +
                "IQ: " + stats.getIQ() +  "\n" +
                "Happiness: 20 (Default)" +
                "\n-------------------------------------------------\n");
    }

    public static void ChilhoodStage(){

        System.out.println("\n-------------------------------------------------\n"+
                "Welcome to your first level: ChildHood\n" +
                "Date: 5/12/2050\n" +
                "Summer vacation is coming...");
        displayAttribute();
        System.out.println("Please select one of as your hobbit that you want to be developed during your childhood\n" +
                "1. Sport [Health + 2]\n" +
                "2. Study [IQ + 2]\n" +
                "3. Art [Charm + 2]\n" +
                "4. I don't want any of them" +
                "\n-------------------------------------------------\n");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        if (sc.hasNext()){
            choice = sc.nextInt();
        }

        if (choice == 1){
            stats.increaseHealth(2);
        } else if (choice == 2){
            stats.increaseIQ(2);
        } else if (choice == 3){
            stats.increaseCharm(2);
        } else if (choice == 4){
            System.out.println("Not good enough XD");
        }
        displayAttribute();

        System.out.println(player.getCurrStage().pickScenarios(player.getCurrStage().getPath()));
        player.getCurrStage().updateAttribute();
        displayAttribute();
    }

    public static void main(String[] args){
        startInfo();
        initialisedPlayer();
        gameStart();
        ChilhoodStage();
    }
}
