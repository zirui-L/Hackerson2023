package Player;

public class PlayerStats {
    private int iQ;
    private int charm;
    private int wealth;
    private int health;
    private Stage currStage;
    private int happiness;

    public PlayerStats(int health, int wealth, int charm, int IQ, int happiness) {
        this.iQ = iQ;
        this.charm = charm;
        this.wealth = wealth;
        this.health = health;
        this.happiness = happiness;
    }

    public int getiQ() {
        return iQ;
    }
    public void setiQ(int iQ) {
        this.iQ = iQ;
    }
    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }
    public int getWealth() {
        return wealth;
    }
    public void setWealth(int wealth) {
        this.wealth = wealth;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public Stage getCurrStage() {
        return currStage;
    }
    public void setCurrStage(Stage currStage) {
        this.currStage = currStage;
    }
    public int getHappiness() {
        return happiness;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void increaseHealth(int number) {
        this.health = this.health + number;
    }

    public void increaseIq(int number) {
        this.iQ = this.iQ + number;
    }

    public void increaseCharm(int number) {
        this.charm = this.charm + number;
    }
}
