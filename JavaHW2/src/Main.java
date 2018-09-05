import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {


    /**
     * The number of options available for user.
     */
    public static final int MAXIMUM_OPTION = 4;

    /**
     * Displays menu options to user which the user eneters the according number to select one of the options.
     * Method will validate user input for the value to be an integer between 0 and 4
     *
     * @return returns the number of the selected option.
     */

    public static int getAndValidateMenu() {
        System.out.print("\n1 - List entries\n2 - Add entry\n3 – Delete entry\n4 - Exit\nEnter your option: ");
        int menuOption = 0;
        do {
            Scanner reader = new Scanner(System.in);
            if (reader.hasNextInt()) {
                menuOption = reader.nextInt();
                if (menuOption >= 0 && menuOption <= MAXIMUM_OPTION) {
                    return menuOption;
                } else {
                    System.out.print("Please enter a value between 0 and 4.");
                }
            } else {
                System.out.print("Invalid input please enter a number between 0 and 4.");
            }
        } while (menuOption < 0 || menuOption > MAXIMUM_OPTION);
        return menuOption;
    }


    public static void main(String args[]) {
        int selected = getAndValidateMenu();
        //initializes an instance of AddressBook
        AddressBook phoneBook = new AddressBook();
        //Some initial records because phone books should have records
        phoneBook.addRecord("Austin", "4562");
        phoneBook.addRecord("Dylan", "234234");
        phoneBook.addRecord("Garret", "345345");

        do {
            switch (selected) {
                case 1: {
                    //Displays phoneBook information
                    phoneBook.DisplayInformation();
                    //reprompts User
                    selected = getAndValidateMenu();
                }
                break;
                case 2: {
                    //Scanner to take input
                    Scanner reader = new Scanner(System.in);
                    //Prompts user for name
                    System.out.println("Enter Name");
                    String name = reader.nextLine();
                    //Prompts user for phone number
                    System.out.println("Enter Phone Number");
                    String phNumber = reader.nextLine();
                    //adds record to phoneBook
                    phoneBook.addRecord(name, phNumber);
                    System.out.printf("%s was added.", name);
                    //Reprompts user
                    selected = getAndValidateMenu();
                }
                break;
                case 3: {
                    // Scanner to take input
                    Scanner reader = new Scanner(System.in);
                    //prompts user for name of record to delete
                    System.out.println("Enter the name to delete :");
                    String nameDelete = reader.nextLine();
                    //Deletes record
                    phoneBook.deleteRecord(nameDelete);
                    //Reprompts user
                    System.out.printf("%s was deleted", nameDelete);
                    selected = getAndValidateMenu();
                }
                break;
            }
        } while (selected != 4); // if 4 program completes
    }
}
