package CostCalculation;

import AthleteInformation.Athlete;

public class Receipt {
    Athlete athelete;
    Competition competition;
    TrainingPlan trainingPlan; // Removed initialization here


    public Receipt(Athlete athelete) {
        this.athelete = athelete;
        this.competition = athelete.getCompetition();
        this.trainingPlan = athelete.getTrainingPlan(); // Set trainingPlan with the provided parameter

    }

    public void showReceipt() {
        System.out.println("\u001B[32mReceipt:\u001B[0m");
        System.out.println("\u001B[32m+--------------------------+\u001B[0m");

        System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Name: " + this.trainingPlan.getName());
        System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Weight: " + this.trainingPlan.getWeight() + "kg");
        System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Chosen Plan: " + this.trainingPlan.getChosenPlanAtIndex(this.trainingPlan.getChosenPlan()) + " - $" + this.trainingPlan.getChosenPlanWeightAtIndex(this.trainingPlan.getChosenPlan()) + " - x 4 weeks $" + this.trainingPlan.getChosenPlanWeightAtIndex(this.trainingPlan.getChosenPlan()) * 4);

        if (athelete.getCoachFee() > 0) {
            System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Coaching Fee: " + this.trainingPlan.getCoachingHour() + " x $22 - $" + athelete.getCoachFee());
        } else {
            System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Coaching Hour: 0");
        }

        if (this.competition.eligible()) {
            System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Competition Fee: " + this.competition.getNoOfCompetition() + " x 22 -$" + athelete.getCompetitionFee());
            System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Weight Difference: current weight - " + this.trainingPlan.getWeight() + "kg - Competition weight - " + this.competition.getWeightAtIndex(this.trainingPlan.getChosenWeightClass()));
        }

        System.out.format("\u001B[32m| %-26s |\u001B[0m\n", "Total Cost: " + athelete.getTotalFee());
        System.out.println("\u001B[32m+--------------------------+\u001B[0m");
    }


}
