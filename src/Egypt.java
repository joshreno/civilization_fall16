public class Egypt {

    private Treasury treasury;
    private Population population;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlements;
    private Desert desert;

    private int numSettlements;

    public Egypt() {
        treasury = new Treasury();
        population = new Population();
        coalMine = new CoalMine();
        river = new River("Nile River");
        technology = new Technology();
        strategy = new Strategy();
        settlements = new Settlement[10];
        desert = new Desert();

    }

    public boolean settle(Settlement s) {
        boolean filled = false;
        int index = 0;
        for (int i = 0; i < settlements.length; i++) {
            if (settlements[i] == null) {
                index = i;
                filled = false;
                break;
            }
        }

        if (!filled) {
            numSettlements++;
            settlements[index] = s;
            return true;
        } else {
            return false;
        }
    }

    public int getNumSettlements() {
        return numSettlements;
    }

    public boolean buildPyramid(Settlement needsPyramid) {
        int money = treasury.getCoins();
        boolean built = needsPyramid.build(money, population, 1000, 100);
        technology.increaseExperience(10);
        return built;
    }

    public void practiceHieroglyphics() {
        technology.improveWriting();
        population.increaseHappiness(10);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Technology getTechnology() {
        return technology;
    }

    public Population getPopulation() {
        return population;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public Settlement[] getSettlements() {
        return settlements;
    }

    public Desert getDesert() {
        return desert;
    }

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public River getRiver() {
        return river;
    }
}