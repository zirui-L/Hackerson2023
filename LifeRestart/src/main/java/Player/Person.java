package Player;

public class Person {

    private final int INCREASEBY = 2;
    private String eventId;
    private PlayerStats stats;
    private Stage currStage;
    private int hobby;

    public Person(int health, int wealth, int charm, int IQ, int happiness) {
        this.stats = new PlayerStats(IQ, charm, wealth, health, happiness);
    }

    public Stage getStage() {
        return this.currStage;
    }

    public void setStage(Stage stage) {
        this.currStage = stage;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public PlayerStats getStats() {
        return stats;
    }

    public void setStats(PlayerStats stats) {
        this.stats = stats;
    }

    public Stage getCurrStage() {
        return currStage;
    }

    public void setCurrStage(Stage currStage) {
        this.currStage = currStage;
    }

    public void changeStage(int yearCount) {
         if (yearCount == 1 || yearCount == 2 || yearCount == 3) {
            this.currStage.changeStage();

        }
    }


    public void setHobby(int hobbyType) {
        this.hobby = hobbyType;
        switch(hobbyType) {
            case 1:
                stats.increaseHealth(INCREASEBY);
            case 2:
                stats.increaseIq(INCREASEBY);
            case 3:
                stats.increaseCharm(INCREASEBY);
            default:
        }
    }

    public int getHobby() {
        return this.hobby;
    }

}