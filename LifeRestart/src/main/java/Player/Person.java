package Player;

import Stage.*;

public class Person {

    private final long INCREASEBY = 2;
    private String eventId;
    private PlayerStats stats;
    private Stage currStage;
    private long hobby;

    public Person(long health, long wealth, long charm, long IQ, long happiness) {
        this.stats = new PlayerStats(IQ, charm, wealth, health, happiness);
        this.currStage = new ChildStage();
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

    public void changeStage(long yearCount) {
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
                stats.increaseIQ(INCREASEBY);
            case 3:
                stats.increaseCharm(INCREASEBY);
            default:
        }
    }

    public long getHobby() {
        return this.hobby;
    }

}