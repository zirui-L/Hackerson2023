package Player;

import Stage.Stage;

public class PlayerStats {
    private long IQ;
    private long charm;
    private long wealth;
    private long health;
    private Stage currStage;
    private long happiness;

    public PlayerStats(long health, long wealth, long charm, long IQ, long happiness) {
        this.IQ = IQ;
        this.charm = charm;
        this.wealth = wealth;
        this.health = health;
        this.happiness = happiness;
    }

    public long getIQ() {
        return IQ;
    }
    public void setIQ(long IQ) {
        this.IQ = IQ;
    }
    public long getCharm() {
        return charm;
    }

    public void setCharm(long charm) {
        this.charm = charm;
    }
    public long getWealth() {
        return wealth;
    }
    public void setWealth(long wealth) {
        this.wealth = wealth;
    }
    public long getHealth() {
        return health;
    }
    public void setHealth(long health) {
        this.health = health;
    }
    public Stage getCurrStage() {
        return currStage;
    }
    public void setCurrStage(Stage currStage) {
        this.currStage = currStage;
    }
    public long getHappiness() {
        return happiness;
    }
    public void setHappiness(long happiness) {
        this.happiness = happiness;
    }

    public void increaseHealth(long number) {
        this.health = this.health + number;
    }

    public void increaseIQ(long number) {
        this.IQ = this.IQ + number;
    }

    public void increaseCharm(long number) {
        this.charm = this.charm + number;
    }

    public void increaseWealth(long number){ this.wealth += number; }
    public void increaseHappiness(long number){ this.happiness += number; }

}
