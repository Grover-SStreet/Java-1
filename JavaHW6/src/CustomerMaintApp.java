/**
 * @author Austin Grover
 * @version 1.3
 * <p>
 * This class is the presentation tier of the application.
 * Class role is to provide interface for user to interact with application.
 */

import java.util.Scanner;

public class CustomerMaintApp {

    public static void main(String args[]) {
        //Calls display method and initializes command
        String command = "";
        displayOption();
        //Continuously prompts user for commands
        do {
            Scanner reader = new Scanner(System.in);
            System.out.print("\nEnter a Command: ");
            command = reader.nextLine().toLowerCase().trim();
            try {
                Validator.validate(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (command.equals("list")) {

                //Gets the sort option and then lists the customers based on the sort.
                int sortChoice = sortOptions();
                if (sortChoice != 0) {
                    System.out.println(Customer.listCustomers(sortChoice));
                }
            } else if (command.equals("add")) {
                //Creates customer object and writes to customer.txt
                CustomerDAO.write(createCustomer(), true);
            } else if (command.equals("del")) {
                //Gets email and deletes object in file with matching email.
                String email = Validator.validateEmail();
                System.out.println("Update with your new values");
                Customer.update(email);
            } else if (command.equals("upd")) {
                //Validates email and updates all attributes of the customer/
                String email = Validator.validateEmail();
                System.out.println("Update with your new values");
                Customer.update(email, createCustomer());
            } else if (command.equals("help")) {
                //displays the list of commands and descriptions
                displayOption();
            } else if (command.equals("exit")) {
                //exits the program
                System.out.println("Goodbye");
            } else {
                //run if the command is not found
                System.out.print("Command not found");
            }
        } while (command.equals("exit") == false);
    }

    /**
     * The main display option for the commands.
     */
    public static void displayOption() {

        System.out.printf("%-5s %s\n", "list", " - List all customers");
        System.out.printf("%-5s %s\n", "add", " - Add a customer");
        System.out.printf("%-5s %s\n", "del", " - Delete a customer");
        System.out.printf("%-5s %s\n", "upd", " - Update a customer");
        System.out.printf("%-5s %s\n", "help", " - Show this menu");
        System.out.printf("%-5s %s\n", "exit", " - Exit this application");

    }

    /**
     * Provides the sort options to the user
     *
     * @return the sort option selected.
     */
    public static int sortOptions() {
        System.out.println("\nEnter the number of the sort you wish to have");
        System.out.println("1 - Sort by last name");
        System.out.println("2 - Sort by email");
        System.out.println("3 - Sort by first name\n");

        int option = 0;
        try {
            option = Validator.validateSort();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    /**
     * Prompts user for Customer attributes for initialization
     *
     * @return Customer object
     */
    public static Customer createCustomer() {
        boolean validInput = true;
        String email = "";
        String fName = "";
        String lName = "";
        do {
            Scanner addinput = new Scanner(System.in);
            System.out.print("\nEnter a email address: ");
            email = addinput.nextLine().toLowerCase().trim();
            System.out.print("\nEnter first name: ");
            fName = addinput.nextLine().toLowerCase().trim();
            System.out.print("\nEnter a last name: ");
            lName = addinput.nextLine().toLowerCase().trim();

            try {
                Validator.validateAdd(email);
                Validator.validateAdd(fName);
                Validator.validateAdd(lName);
                validInput = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                validInput = false;
            }
        } while (validInput == false);

        return new Customer(email, fName, lName);
    }
}
