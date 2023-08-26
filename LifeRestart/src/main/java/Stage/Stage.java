package Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import Player.PlayerStats;
import Reader.AttributeReader;
import Reader.ScenarioReader;
public abstract class Stage {
    public static final double PROBABILITY = 0.1;
    private final String attributePath = "src/main/resources/attributes.json";
    private ScenarioReader scenarios;
    private ArrayList<Integer> value = new ArrayList<Integer>();;
    public abstract Stage changeStage();
    public String pickScenarios(String path){
        this.scenarios = new ScenarioReader(path);
        this.scenarios.parse();
        HashMap<Integer, String> descriptions = scenarios.getDescription();
        HashMap<Integer, ArrayList<Integer>> attributes = scenarios.getAttribute();

        Random random = new Random();
        int randomId = random.nextInt(descriptions.size()) + 1;

        String randomDescription = descriptions.get(randomId);


        value = attributes.get(randomId);

        return randomDescription;
    }
    public void updateAttribute(){

        AttributeReader attributeReader = new AttributeReader(attributePath);
        attributeReader.parse();
        PlayerStats playerStats = attributeReader.getPlayerStats();

//        int health = playerStats.getHealth() + value.get(0);
//        int wealth = playerStats.getWealth() + value.get(1);
//        int charm = playerStats.getCharm() + value.get(2);
//        int IQ = playerStats.getIQ() + value.get(3);
//        int happiness = playerStats.getHappiness() + value.get(4);
        playerStats.increaseHealth(value.get(0));
        playerStats.increaseWealth(value.get(1));
        playerStats.increaseCharm(value.get(2));
        playerStats.increaseIQ(value.get(3));
        playerStats.increaseHappiness(value.get(4));
        System.out.println("health: "+playerStats.getHealth() );
        System.out.println("wealth: " + playerStats.getWealth());
        System.out.println("charm:" + playerStats.getWealth());
        System.out.println("IQ:"+playerStats.getIQ());
        System.out.println("hap: " + playerStats.getHappiness());

    }

//    public String event() {
//        if (trigger()) {
//            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//            System.out.println(pickScenarios(getPath()));
//
//            String userOption = myObj.nextLine();  // Read user input
//            if (userOption.startsWith("y")) {
//                //update attributes(not implemented)
//            }
//        }
//    }

    boolean trigger() {
        double random = Math.random();
        return (random < PROBABILITY);
    }
    public abstract String getPath();
}