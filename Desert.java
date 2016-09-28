import java.util.Scanner;

public class Desert {
    private Scanner scan = new Scanner(System.in);

    public int findTreasure() {
        int treasure = (int) (500 * Math.random() + 1);
        int lostChance = (int) (10 * Math.random());

        if (lostChance == 9) {
            boolean ifLost = true;
            while (ifLost) {
                if (lost()) {
                    continue;
                } else {
                    ifLost = false;
                }
            }
        }
        return treasure;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}