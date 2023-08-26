package Stage;

import java.util.Scanner;

public class ChildStage extends Stage{

    private final String scenarioPath = "src/main/resources/childhood.txt";

    @Override
    public Stage changeStage() {
        return new Student();
    }

//    @Override
//    public String event(int yearCount) {
//        if (trigger()) {
//            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//            System.out.println(pickScenarios(getPath()));
//
//            String userOption = myObj.nextLine();  // Read user input
//            if (userOption.toLowerCase().startsWith("y")) {
//                //update attributes(not implemented)
//            }
//        }
//        return null;
//    }

    @Override
    public String getPath() {
        return scenarioPath;
    }
    
}
