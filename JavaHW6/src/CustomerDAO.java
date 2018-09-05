/**
 * @Author Austin Grover
 * @Version 1.3
 * The data access tier
 */

import com.sun.nio.sctp.IllegalReceiveException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDAO {

    /**
     * Reads from customer.txt and creates an array of Customer objs
     *
     * @return An array of customer objs
     * @throws IOException Will throw if the file is not formatted properly
     */
    public static ArrayList<Customer> read() throws IOException {
        String fileName = "customer.txt";
        try (Scanner reader =
                     new Scanner(
                             new BufferedReader(
                                     new FileReader(fileName)))) {

            ArrayList<Customer> customerList = new ArrayList<>();

            if (reader.hasNext()) {
                //do nothing
            } else {
                throw new IllegalReceiveException("Invalid format");
            }

            while (reader.hasNext()) {
                String email = reader.nextLine();
                String fName = reader.nextLine();
                String lname = reader.nextLine();
                customerList.add(new Customer(email, fName, lname));
            }
            if (reader.hasNext()) {
                reader.nextLine();
            }
            return customerList;
        }
    }

    /**
     * Writes Customer objects tp file
     *
     * @param Customer Customer object
     * @param append   Determines if file should be appened
     * @return boolean if file could be written.
     */
    public static boolean write(Customer Customer, Boolean append) {

        if (Customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        } // else Customer is not null, doNothing();

        String fileName = String.format("customer.txt");

        try (PrintWriter out =
                     new PrintWriter(
                             new BufferedWriter(
                                     new FileWriter(fileName, append)))) {
            out.append(toFileString(Customer));
            return true;
        } catch (IOException iOEx) {
            return false;
        }
    }


    /**
     * Format the file will get written to
     *
     * @param temp Customer obj s
     * @return formatted string for writing to file.
     */
    private static String toFileString(Customer temp) {
        StringBuilder builder = new StringBuilder();
        builder.append(temp.getEmail()).append("\n");
        builder.append(temp.getfName()).append("\n");
        builder.append(temp.getlName()).append("\n");
        return builder.toString();
    }


}
