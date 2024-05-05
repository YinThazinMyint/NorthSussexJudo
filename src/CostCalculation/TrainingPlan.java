package CostCalculation;

import java.util.HashMap;
import java.util.Map;

public class TrainingPlan extends Person implements costFee {
    static Map<String, Integer> trainingPlans = new HashMap<>();
    private int planFee;
    private int coachFee;
    //define plans and fees
    static{
        trainingPlans.put("Beginner", 25);
        trainingPlans.put("Intermediate", 30);
        trainingPlans.put("Elite", 35);
    }
    public int getPlanFee() {
        return planFee;
    }

    public void setPlanFee(int planFee) {
        this.planFee = planFee;
    }

    public int getCoachFee() {
        return coachFee;
    }

    public void setCoachFee(int coachFee) {
        this.coachFee = coachFee;
    }

    public void getPlan() {
        System.out.println("Choose your plan from the following:");
        int index = 1;
        // ANSI escape code for yellow color
        String yellowColor = "\u001B[33m";

        // Print table header
        System.out.println(yellowColor + "-------------------------------------");
        System.out.println("| Index | Plan             | Fees |");
        System.out.println("-------------------------------------");
        for (Map.Entry<String, Integer> plan : trainingPlans.entrySet()) {
            System.out.printf("| %-6d| %-16s| %-9d|\n", index, plan.getKey(), plan.getValue());
            index++;
        }
        System.out.println("-------------------------------------");
        // ANSI escape code to reset color
        System.out.print("\u001B[0m");

        setChosenPlan(getValidIndex(trainingPlans.size(), scanner));
    }

    public void getPrivateCoach() {
        System.out.println("Do you want to take private coach y/n");
        String yes = scanner.next();
        if (yes.trim().toLowerCase().charAt(0) == 'y'){
            System.out.println("How many hours of private coaching would you like to take 1 to 5 hours");
            setCoachingHour(getValidIndex(5, scanner));
        }

    }

    public Integer getFeeAtIndex(int index) {
        int currentIndex = 0;
        for (Map.Entry<String, Integer> fee : trainingPlans.entrySet()) {
            if (currentIndex == (index-1)) {
                return fee.getValue();
            }
            currentIndex++;
        }
        return null; // Return null if index is out of bounds
    }

    public String getChosenPlanAtIndex(int index) {
        int currentIndex = 0;
        for (Map.Entry<String, Integer> plan : trainingPlans.entrySet()) {
            if (currentIndex == (index-1)) {
                return plan.getKey();
            }
            currentIndex++;
        }
        return null;
    }

    public int getChosenPlanWeightAtIndex(int index) {
        int currentIndex = 0;
        for (Map.Entry<String, Integer> plan : trainingPlans.entrySet()) {
            if (currentIndex == (index-1)) {
                return plan.getValue();
            }
            currentIndex++;
        }
        return 0;
    }

    @Override
    public void calculateFee() {
        planFee = getFeeAtIndex(getChosenPlan());
        coachFee = (getCoachingHour() * 22);
    }
}
