package Reader;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Data {
    private static JSONObject data;
    private final static String DATABASE_PATH = "src/main/resources/attributes.json";

    public static Object getData() {
        try {
            Object obj = new JSONParser().parse(new FileReader(DATABASE_PATH));
            JSONObject jsonObj = (JSONObject) obj;
            data = jsonObj;

        } catch (Exception e) {
            System.err.println("The exchange database cannot be loaded.");
        }
        return data.get("Attribute");
    }

    public static void setData(Object obj) {
        data.put("Attributes", obj);
    }
}