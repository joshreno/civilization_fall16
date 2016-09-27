public class Strategy {
    private int strategyLevel;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;
    private boolean conqueredTheWorld = false;

    public void battle() {
        strategyLevel = strategyLevel + BATTLE_INCREASE;
        victory();
    }

    public void siege() {
        strategyLevel = strategyLevel + SIEGE_INCREASE;
        victory();
    }

    public boolean victory() {
        if (strategyLevel > 180) {
            conqueredTheWorld = true;
        }
        return conqueredTheWorld;
    }

    public boolean conqueredTheWorld() {
        return conqueredTheWorld;
    }

    public int getStrategyLevel() {
        return strategyLevel;
    }
}