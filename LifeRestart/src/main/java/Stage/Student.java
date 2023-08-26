package Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Player.Person;
import Player.PlayerStats;
import Reader.AttributeReader;
import Reader.ScenarioReader;

public class Student {

    private ScenarioReader scenarios;
    private final String attributePath = "src/main/resources/attributes.json";

    public void create(String path){
        this.scenarios = new ScenarioReader(path);
        this.scenarios.parse();

    }

    public String pickScenarios(){

        HashMap<Integer, String> descriptions = scenarios.getDescription();
        HashMap<Integer, ArrayList<Integer>> attributes = scenarios.getAttribute();
        Random random = new Random();

        int randomId = random.nextInt(descriptions.size()) + 1;

        String randomDescription = descriptions.get(randomId);

        ArrayList<Integer> value = new ArrayList<Integer>();
        value = attributes.get(randomId);

        AttributeReader attributeReader = new AttributeReader(attributePath);
        attributeReader.parse();
        PlayerStats playerStats = attributeReader.getPlayerStats();

        int health = playerStats.getHealth() + value.get(0);
        int wealth = playerStats.getWealth() + value.get(1);
        int charm = playerStats.getCharm() + value.get(2);
        int IQ = playerStats.getiQ() + value.get(3);
        int happiness = playerStats.getHappiness() + value.get(4);


        return randomDescription;

    }



}
