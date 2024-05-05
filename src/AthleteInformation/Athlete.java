package AthleteInformation;

import CostCalculation.Competition;
import CostCalculation.TrainingPlan;

import java.util.Scanner;

public class Athlete {
    
    private TrainingPlan trainingPlan;
    private Competition competition;
    private int planFee;
    private int coachFee;
    private int competitionFee;
    private int totalFee;
    private static Scanner scanner = new Scanner(System.in);
    
    public Athlete() {
        //get user name
        trainingPlan = new TrainingPlan();      
        System.out.println("Enter your name");
        trainingPlan.setName(scanner.nextLine());

        //get training plan
        trainingPlan.getPlan();

        //get current weight class
        System.out.println("Enter your current weight in kg");
        trainingPlan.setWeight(getIntInput(scanner));
        scanner.nextLine();

        //get competition weight class
        competition = new Competition(trainingPlan);
        competition.getWeightClass();

        //get private coaching hour
        trainingPlan.getPrivateCoach();


        trainingPlan.calculateFee();
        planFee = trainingPlan.getPlanFee();
        coachFee = trainingPlan.getCoachFee();
        
        competition.calculateFee();
        competitionFee = competition.getCompetitionFee();
        totalFee = (planFee*4) + coachFee + competitionFee;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
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

    public int getCompetitionFee() {
        return competitionFee;
    }

    public void setCompetitionFee(int competitionFee) {
        this.competitionFee = competitionFee;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Athlete.scanner = scanner;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getIntInput(Scanner scanner) {
        int input;

        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        return input;
    }
}
