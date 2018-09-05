/**
 * @Author Austin Grover
 * @Version 1.3
 * Part of the business logic tier
 */

import java.util.Scanner;

public class Validator {

    /**
     * Static method to validate the string is not null
     * @param command string for validation
     * @return true or false if string is null
     */
    public static boolean validate(String command) {
        if (command == null || command.length() == 0) {
            throw new IllegalArgumentException("Command cannot be null or empty.");
        } else {
            return true;
        }
    }

    /**
     * Validates String is not null
     * @param value string for validation
     * @return true or false if string is null
     */
    public static boolean validateAdd(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("Value cannot be null or empty.");
        } else {
            return true;
        }
    }

    /**
     * Returns a valid integer option for sort
     * @return sort option selected
     * @throws IllegalArgumentException if the value entered is not a number
     */
    public static int validateSort() {
        int option = 0;
        Scanner reader = new Scanner(System.in);

        while (option < 1 || option > 3) {
            try {
                System.out.print("Please enter a valid option between 1 and 3 ");
                option = reader.nextInt();
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid number exiting list");
            }
        }


        return option;
    }

    /**
     * Gets new email address and calls the ValidateAdd method
     * @return valid email
     */

    public static String validateEmail() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the old email: ");
        String email = reader.nextLine();
        boolean validEmail = true;
        do {
            try {
                Validator.validateAdd(email);
                validEmail = true;
            } catch (Exception e) {
                System.out.print(e.getMessage());
                validEmail = false;
            }
        } while (validEmail == false);

        return email;
    }


}

