public class River {
    private String name;
    private Fish[] fish = new Fish[5];

    public River(String riverName) {
        this.name = riverName;
        for (int i = 0; i < fish.length; i++) {
            fish[i] = new Fish((int) (5 * Math.random()));
        }
    }

    public Fish getFish() {
        for (int i = 0; i < fish.length; i++) {
            if (!(fish[i] == null)) {
                Fish returnedFish = fish[i];
                fish[i] = null;
                return returnedFish;
            }
        }
        return null;
    }

    public boolean replenishFish() {
        boolean empty = false;
        for (int i = 0; i < fish.length; i++) {
            if (fish[i] == null) {
                empty = true;
            } else {
                empty = false;
                return empty;
            }
        }

        fish = new Fish[5];
        for (int i = 0; i < fish.length; i++) {
            fish[i] = new Fish((int) (5 * Math.random()));
        }
        return empty;
    }

    public String getName() {
        return name;
    }
}