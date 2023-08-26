package Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Player.Person;
import Player.PlayerStats;
import Reader.AttributeReader;
import Reader.ScenarioReader;

public class Student extends Stage{

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

        long health = playerStats.getHealth() + value.get(0);
        long wealth = playerStats.getWealth() + value.get(1);
        long charm = playerStats.getCharm() + value.get(2);
        long IQ = playerStats.getIQ() + value.get(3);
        long happiness = playerStats.getHappiness() + value.get(4);


        return randomDescription;

    }


    @Override
    public Stage changeStage() {
        return null;
    }

    @Override
    public String getPath() {
        return null;
    }
}
