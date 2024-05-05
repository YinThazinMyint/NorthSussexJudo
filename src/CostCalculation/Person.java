package CostCalculation;

import java.util.Scanner;

public class Person {
    private String name;
    private int weight;
    private int chosenPlan;
    private int coachingHour = 0;
    private int chosenWeightClass;
    public static Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getChosenPlan() {
        return chosenPlan;
    }
    public void setChosenPlan(int chosenPlan) {
        this.chosenPlan = chosenPlan;
    }
    public int getCoachingHour() {
        return coachingHour;
    }
    public void setCoachingHour(int coachingHour) {
        this.coachingHour = coachingHour;
    }
    public int getChosenWeightClass() {
        return chosenWeightClass;
    }
    public void setChosenWeightClass(int chosenWeightClass) {
        this.chosenWeightClass = chosenWeightClass;
    }
    
    public static int getValidIndex(int maxLength, Scanner scanner) {
        int index;
        while (true) {
            System.out.print("Enter index (not more than " + maxLength + "): ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                if (index >= 1 && index <= maxLength) {
                    break; // Exit the loop if the index is valid
                } else {
                    System.out.println("Invalid index. Please enter a valid index.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        return index;
    }
}
