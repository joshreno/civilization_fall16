public class Settlement {
    private String name;
    private Building[] buildings;

    public Settlement(String name) {
        this.name = name;
        buildings = new Building[1];
    }

    public void addBuilding(Building building) {
        for (int i = 0; i < buildings.length; i++) {
            if (buildings[i] == null) {
                buildings[i] = building;
            } else {
                int originalLength = buildings.length;
                expandSettlement();
                buildings[originalLength] = building;
            }
        }
    }

    public boolean build(int allottedMoney, Population population, int cost, int workersRequired) {
        boolean built;
        if (allottedMoney >= cost && population.canWork(workersRequired)) {
            Building newBuilding = new Building(cost, workersRequired);
            addBuilding(newBuilding);
            return true;
        } else {
            return false;
        }
    }

    public void expandSettlement() {
        Building[] temp = new Building[buildings.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = buildings[i];
        }
        buildings = new Building[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            buildings[i] = temp[i];
        }
    }

    public String getName() {
        return name;
    }


}