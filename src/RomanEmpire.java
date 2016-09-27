public class RomanEmpire {
    private Treasury treasury;
    private Population population;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlements;
    private Hills hills;

    private int numSettlements;

    public RomanEmpire() {
        treasury = new Treasury();
        population = new Population();
        coalMine = new CoalMine();
        river = new River("Tiber River");
        technology = new Technology();
        strategy = new Strategy();
        settlements = new Settlement[10];
        hills = new Hills();

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

    public boolean buildAqueduct(Settlement s) {
        boolean built = s.build(treasury.getCoins(), population, 250, 130);
        technology.increaseExperience(10);
        return built;
    }

    public boolean buildBathHouse(Settlement s) {
        boolean built = s.build(treasury.getCoins(), population, 110, 20);
        technology.increaseExperience(10);
        return built;
    }

    public boolean buildVilla(Settlement s) {
        boolean built = s.build(treasury.getCoins(), population, 80, 15);
        technology.increaseExperience(5);
        return built;
    }

    public void studyPhilosophy() {
        boolean happened = population.decreaseHappiness(10);
        if (happened) {
            technology.philosophize();
        }
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

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public River getRiver() {
        return river;
    }

    public Hills getHills() {
        return hills;
    }
}