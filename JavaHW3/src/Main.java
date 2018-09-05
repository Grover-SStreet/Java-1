import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * The number of options available for user.
     */

    public static final int MAXIMUM_OPTION = 6;

    /**
     * The number that is intially used to compare against when doing user input to ensure valid user input.
     */

    public static final int DEFAULT_MENU_VALUE = -5;

    /**
     * Displays menu options to user which the user eneters the according number to select one of the options.
     * Method will validate user input for the value to be an integer between 0 and 4
     *
     * @return returns the number of the selected option.
     */


    public static int getAndValidateMenu() {
        System.out.print("\n0 - Display Lineup\n1 - Add Player\n2 – Remove Player\n3 - Move Player\n");
        System.out.print("4 - Edit Player Position\n5 - Edit Player Stats\n6 - Exit Program\n Enter your option: ");
        int menuOption = DEFAULT_MENU_VALUE;
        do {
            Scanner reader = new Scanner(System.in);
            if (reader.hasNextInt()) {
                menuOption = reader.nextInt();
                if (menuOption >= 0 && menuOption <= MAXIMUM_OPTION) {
                    return menuOption;
                } else {
                    System.out.print("Please enter a value between 0 and 7.");
                }
            } else {
                System.out.print("Invalid input please enter a number between 0 and 7.");
            }
        } while (menuOption < 0 || menuOption > MAXIMUM_OPTION);
        return menuOption;
    }


    public static void main(String args[]) {
        int selected = getAndValidateMenu();

        System.out.println(selected);
        System.out.println("Was selected");

        List<Player> team = new ArrayList<Player>();


        do {
            switch (selected) {

                case 0: {
                    foreach player: team_

                }
                break;
                case 1: {


                }
                break;
                case 2: {

                }
                break;
                case 3: {

                }
                break;
                case 4: {

                }
                break;
                case 5: {

                }
                break;
                case 6: {

                }
                break;

            }

        } while (selected != 6);
    }
}
