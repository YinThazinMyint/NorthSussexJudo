package CostCalculation;

import java.util.HashMap;
import java.util.Map;

public class Competition extends Person implements costFee {
    private static final Map<String, Integer> weightClass = new HashMap<>();
    Person athlete;
    int competitionFee;

    public Competition(Person athlete) {
        this.athlete = athlete;
    }

    // define weight class and weight in kg
    static {
        weightClass.put("HeavyWeight - over 100kg", 50);
        weightClass.put("LightHeavyWeight - 100kg", 50);
        weightClass.put("MiddleWeight - 90kg", 50);
        weightClass.put("LightMiddleWeight - 81kg", 50);
        weightClass.put("LightWeight - 73kg", 50);
        weightClass.put("FlyWeight - 66kg", 50);
    }
    private int noOfCompetition;

    public int getCompetitionFee() {
        return competitionFee;
    }

    public void setCompetitionFee(int competitionFee) {
        this.competitionFee = competitionFee;
    }

    public int getNoOfCompetition() {
        return noOfCompetition;
    }

    boolean eligible() {
        if (athlete.getChosenPlan() > 1) {
            return true;
        }
        return false;
    }

    public void getWeightClass() {
        if (eligible()) {
            System.out.print("You are eligible for competition. Choose your weight class (y/n): ");
            if (scanner.next().equals("y")) {
                int index = 1;
                // ANSI escape code for yellow color
                String yellowColor = "\u001B[33m";

                // Print table header and label
                System.out.println(yellowColor + "----------------------------------");
                System.out.println("| Index | Weight Class            |");
                System.out.println("----------------------------------");
                for (String wClass : weightClass.keySet()) {
                    System.out.printf("| %-6d| %-24s|\n", index, wClass);
                    index++;
                }
                System.out.println("----------------------------------");
                // ANSI escape code to reset color
                System.out.print("\u001B[0m");

                athlete.setChosenWeightClass(getValidIndex(weightClass.size(), scanner));
                System.out.print("How many times would you like to compete: ");
                noOfCompetition = getValidIndex(2, scanner);
            }

        } else {
            System.out.println("Only premium & elite members are eligible for competition");
        }
    }

    public String getWeightAtIndex(int index) {
        int currentIndex = 0;
        for (Map.Entry<String, Integer> wClass : weightClass.entrySet()) {
            if (currentIndex == (index - 1)) {
                return wClass.getKey();
            }
            currentIndex++;
        }
        return null; // Return null if index is out of bounds
    }

    //calculate fee
    @Override
    public void calculateFee() {
        competitionFee = noOfCompetition * 22;
    }
}
