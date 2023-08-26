package Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Player.*;

public class AttributeReader implements Reader{

    private String path;
    private PlayerStats stats;

    public AttributeReader(String path) {
        this.path = path;

    }
    public void parse(){
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(path));

            // convert Object to JSONObject
            JSONObject jsonObject = (JSONObject) object;
            JSONObject jsonAttribute = (JSONObject) jsonObject.get("Attribute");

            int health = (Integer) jsonAttribute.get("Health");
            int wealth = (Integer) jsonAttribute.get("Wealth");
            int charm = (Integer) jsonAttribute.get("Charm");
            int IQ = (Integer) jsonAttribute.get("IQ");
            int happiness = (Integer) jsonAttribute.get("Happiness");

            this.stats = new PlayerStats(health, wealth, charm, IQ, happiness);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public PlayerStats getPlayerStats(){
        return this.stats;
    }

}
