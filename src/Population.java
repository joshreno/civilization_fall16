import java.util.Random;

public class Population {
    private Random rand = new Random();
    private int warriors = 50;
    private int civilians = 50;
    private int happiness = 200;

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public void increaseHappiness(int increase) {
        happiness = happiness + increase;
    }

    public boolean decreaseHappiness(int decrease) {
        if (happiness - decrease > 0) {
            happiness = happiness - decrease;
            return true;
        } else {
            return false;
        }
    }

    public boolean canWork(int workersNeeded) {
        if (workersNeeded > civilians) {
            civilians = civilians - workersNeeded;
            return true;
        } else {
            return false;
        }
    }

    public Game hunt(Hills hill) {
        return hill.hunt();
    }

    public Fish fish(River river) {
        return river.getFish();
    }

    public boolean canCook(Game game, CoalMine coalMine) {
        int amountCoalBefore = coalMine.getCoal();
        boolean burn1 = coalMine.burn();
        boolean burn2 = coalMine.burn();
        boolean burn3 = coalMine.burn();
        boolean burn4 = coalMine.burn();
        if (burn1 && burn2 && burn3 && burn4) {
            warriors = warriors + 40;
            civilians = civilians + 60;
            return true;
        } else {
            int amountCoalAfter = coalMine.getCoal();
            int difference = amountCoalBefore - amountCoalAfter;
            if (difference != 0) {
                coalMine.increaseCoal(difference);
            }
            return false;
        }
    }

    public boolean canCook(Fish fish, CoalMine  coalMine) {
        int amountCoalBefore = coalMine.getCoal();
        boolean burn1 = coalMine.burn();
        boolean burn2 = coalMine.burn();
        boolean burn3 = coalMine.burn();
        boolean burn4 = coalMine.burn();
        if (burn1 && burn2 && burn3 && burn4) {
            warriors = warriors + 10;
            civilians = civilians + 15;
            return true;
        } else {
            int amountCoalAfter = coalMine.getCoal();
            int difference = amountCoalBefore - amountCoalAfter;
            if (difference != 0) {
                coalMine.increaseCoal(difference);
            }
            return false;
        }
    }

    public int getWarriors() {
        return warriors;
    }

    public int getCivilians() {
        return civilians;
    }

    public void setWarriors(int numWarriors) {
        warriors = numWarriors;
    }
}