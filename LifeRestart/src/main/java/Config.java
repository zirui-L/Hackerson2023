import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Config {

    public static void main(String[] args){
        try{
            File f = new File("childhood.txt");
            Scanner sc = new Scanner(f);

            HashMap<Integer, String> childhood = new HashMap<Integer, String>();


            while(sc.hasNextLine()){
                String[] line = sc.nextLine().split(";");
                int id = Integer.parseInt(line[0]);
                String desc = line[1];

                childhood.put(id, desc);
            }

            for (Integer key: childhood.keySet()){
                System.out.println(key + " " + childhood.get(key));
            }


        } catch (FileNotFoundException e){
            System.out.println("File is not found!");
            e.printStackTrace();
        }
    }
}
