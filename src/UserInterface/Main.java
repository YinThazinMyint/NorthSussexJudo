package UserInterface;

import AthleteInformation.Athlete;
import CostCalculation.Receipt;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Athlete> athletes = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        //creating atheletes and putting into arrayList
        addUser();

        //showing the athelets information
            for (Athlete athlete: athletes) {
                Receipt receipt = new Receipt(athlete);
                receipt.showReceipt();
            }
    }

    private static void addUser() {
        System.out.println("Do you want to add client y/n");
        String yes;
        boolean validInputYes = false;
    
        while (!validInputYes) {
            yes = scanner.next();
    
            if (yes.equals("y")) {
                Athlete athlete = new Athlete();
                athletes.add(athlete);
                validInputYes = true;
            } else if (yes.equals("n")) {
                validInputYes = true;
            } else {
                System.out.println("Please enter only 'y' or 'n'.");
            }
        }
    
        System.out.println("Do you want to add more user y/n");
        String more;
        boolean validInputMore = false;
    
        while (!validInputMore) {
            more = scanner.next();
    
            if (more.equals("y")) {
                validInputMore = true;
                addUser(); // Call addUser() recursively to continue adding users
            } else if (more.equals("n")) {
                validInputMore = true;
            } else {
                System.out.println("Please enter only 'y' or 'n'.");
            }
        }
    }
}


