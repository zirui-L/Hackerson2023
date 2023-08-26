package Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class ScenarioReader implements Reader{

    private String path;
    private HashMap<Integer, String> descriptions;
    private ArrayList<Integer> attributeValues;
    private HashMap<Integer, ArrayList<Integer>> attributes;

    public ScenarioReader(String path) {
        this.path = path;
        this.descriptions = new HashMap<Integer, String>();
        this.attributeValues = new ArrayList<Integer>();
        this.attributes = new HashMap<Integer, ArrayList<Integer>>();
    }

    public void parse(){
        try{
            File f = new File(this.path);
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine()){
                String[] line = sc.nextLine().split(";");
                int id = Integer.parseInt(line[0]);
                String desc = line[1];


                this.attributeValues.add(Integer.parseInt(line[2]));
                this.attributeValues.add(Integer.parseInt(line[3]));
                this.attributeValues.add(Integer.parseInt(line[4]));
                this.attributeValues.add(Integer.parseInt(line[5]));
                this.attributeValues.add(Integer.parseInt(line[6]));

                this.descriptions.put(id, desc);
                this.attributes.put(id, this.attributeValues);
            }

        } catch (FileNotFoundException e){
            System.out.println("File is not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, String> getDescription(){ return this.descriptions; }

    public HashMap<Integer, ArrayList<Integer>> getAttribute(){ return this.attributes; }
}
