import java.util.Scanner;
public class Civilization {
    private static boolean playing = true;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String text1 = "Choose a civilization by entering a number: 1. Ameri";
        String text2 = "can (George Washington), 2. Zulu (Shaka), 3. English ";
        String text3 = "(Queen Elizabeth I), or 4. Chinese (Wu Zetian)";
        System.out.println(text1 + text2 + text3);
        int civChoice = reader.nextInt();
        String leader;
        String civilization;
        if (civChoice == 1) {
            leader = "George Washington";
            civilization = "American";
        } else if (civChoice == 2) {
            leader = "Shaka";
            civilization = "Zulu";
        } else if (civChoice == 3) {
            leader = "Queen Elizabeth I";
            civilization = "English";
        } else {
            leader = "Wu Zetian";
            civilization = "Chinese";
        }
        System.out.println("Choose your first city name");
        reader.nextLine();
        String firstCity = reader.nextLine();
        String[] cities = new String[5];
        cities[0] = firstCity;
        int numAttacks = 0;
        double gold = 20.50;
        double resources = 30.00;
        int happiness = 10;
        int militaryUnits = 0;
        int techPoints = 0;
        int countNull;
        while (playing) {
            resources++;
            if (happiness > 20) {
                resources += 5 * cities.length;
            }
            gold += 3 * cities.length;

            if (resources % 2 == 0) {
                happiness++;
            } else {
                happiness += -3;
            }
            System.out.println("Number of attacks on enemy: " + numAttacks);
            System.out.println("Amount of Gold: " + gold);
            System.out.println("Amount of resources: " + resources);
            System.out.println("Happiness: " + happiness);
            System.out.println("Military Units: " + militaryUnits);
            System.out.println("Technology points: " + techPoints);

            String text4 = "Choose from the following options(case sensitive):\n";
            String text5 = " 1. Settle a city (cost: 15.5 gold) \n";
            String text6 = "2. Demolish a city (Gain: 1.5 resources) \n";
            String text7 = "3. Build militia (Cost: 5 gold, 3 resources) \n";
            String text8 = "4. Research technology (Cost: 50 gold, 3 resources) \n";
            String text9 = "5. Attack Enemy City (Cost: 6 military units, 3 happiness,";
            String text10 = " Gain: 10 gold \n6. End turn";
            System.out.println(text4 + text5 + text6 + text7 + text8 + text9 + text10);
            int decision = reader.nextInt();
            String printed = "";
            switch (decision) {
            case 1:
                boolean filled = false;
                countNull = 0;
                for (int i = 0; i < cities.length; i++) {
                    if (cities[i] == null) {
                        countNull++;
                    }
                }
                if (countNull == 0) {
                    filled = true; // check if thiasflkajflkjasdlkjhfadslkfhjksdlajhlkjhsdfkahsdkjhjdkshafjkjkjhjhgjhgjk
                }
                if (!filled) {
                    for (int i = 0; i < cities.length; i++) {
                        if (cities[i] != null) {
                            System.out.println("Current city: " + cities[i]);
                        }
                    }
                    if (gold > 15.5) {
                        for (int i = 0; i < cities.length; i++) {
                            if (cities[i] == null) {
                                System.out.println("Enter a name for a new city");
                                reader.nextLine();
                                String x = reader.nextLine();
                                cities [i] = x;
                                gold = gold - 15.5;
                                break;
                            }
                        }
                    } else {
                        System.out.println("Not enough gold");
                    }
                }
                break;
            case 2:
                countNull = 0;
                for (int i = 0; i < cities.length; i++) {
                    if (cities[i] == null) {
                        countNull++;
                    }
                }
                if (countNull == 4) {
                    System.out.println("You only have one city left");
                } else {
                    printed = "Current cities: ";
                    for (int i = 0; i < cities.length; i++) {
                        if (cities[i] != null) {
                            printed += cities[i] + " ";
                        }
                    }
                    System.out.println("Which city by index would you like to demolish\n" + printed);
                    int choice = reader.nextInt();
                    cities [choice] = null;
                    resources = resources + 1.5;
                    reader.nextLine();
                }
                break;
            case 3:
                if (gold < 5 || resources < 3) {
                    System.out.println("You either don't have the resources or you don't have the gold");
                } else {
                    gold = gold - 5;
                    resources = resources - 3;
                    militaryUnits++;
                }
                break;
            case 4:
                if (gold < 50 || resources < 2) {
                    System.out.println("You either don't have enough gold or you don't have enough resources");
                } else {
                    gold = gold - 50;
                    resources = resources - 2;
                    techPoints += 1;
                }
                break;
            case 5:
                if (militaryUnits - 6 < 0) {
                    System.out.println("You do not have enough military units to attack an enemy city");
                } else {
                    militaryUnits = militaryUnits - 6;
                    happiness = happiness - 3;
                    numAttacks++;
                    gold += 10;
                }
                break;
            case 6:
                break;
            default:
                System.out.println("You need to enter a valid decision");
                break;
            }
            if (numAttacks >= 10 || techPoints >= 10) {
                System.out.println("Congradulations, " + leader + ". " + civilization + "'s have won!");
                playing = false;
            }
        }
    }
}