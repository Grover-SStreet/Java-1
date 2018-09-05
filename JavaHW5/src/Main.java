import java.io.IOException;
import java.util.Scanner;

/**
 * Main method where CSVReader class is instantiated and used.
 *
 * @author Austin Grover
 * @version 1.0
 */
public class Main {
    public static void main(String args[]) {

        boolean error = false;
        CSVReader reader = new CSVReader();

        do {
            reader.setFilePath(prompt());
            try {
                reader.read();
                error = false;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                error = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (error == true);


        System.out.println("Number of Fields " + reader.numberOfFields());
        System.out.println("Number of Fields " + reader.numberOfFields());
        System.out.println("Number of Fields " + reader.numberOfFields());
        System.out.println("Number of Fields " + reader.numberOfFields());



        System.out.println("Number of Rows " + reader.numberOfRows());
        System.out.println("Number of Rows " + reader.numberOfRows());


        System.out.println("Number of Rows " + reader.numberOfRows());
        System.out.println("Number of Rows " + reader.numberOfRows());


        System.out.println("I want row field 8 row 33 " + reader.field(8, 33));
        System.out.println("I want row field 4 row 23 " + reader.field(4, 23));
        System.out.println("I want row field 4 row 1 " + reader.field(4, 1));
        System.out.println("I want row field 5 row 25 " + reader.field(5, 25));




    }

    /**
     * Prompts user for file path
     *
     * @return path of file
     */


    public static String prompt() {
        System.out.println("Please give the full path of the desired file.");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        return path;
    }
}
