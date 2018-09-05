import com.sun.org.apache.regexp.internal.RE;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Austin Grover
 * @author agrover1@nwacc.edu
 * @version 1.0
 * @since 1.0
 */
public class AddressBook {

    //TreeMap for storing names and phone numbers.
    private static Map<String, String> records = new TreeMap<String, String>();

    /**
     * Method adds a user the record to be stored.
     *
     * @param name        Name of a person
     * @param phoneNumber Phone number of a person
     */
    public void addRecord(String name, String phoneNumber) {
        records.put(name, phoneNumber);
    }

    /**
     * Method loops through map pulling name and number for each record.
     * Displays record to user.
     */
    public void DisplayInformation() {
        System.out.println("\n\nName  \t\t\t Number");
        System.out.println("--------  \t\t ----------");
        for (Map.Entry<String, String> entry : records.entrySet()) {
            System.out.printf("%5s %20s \n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Will take a name from a user and will delete that record.
     *
     * @param name key in map to be deleted.
     */
    public void deleteRecord(String name) {
        records.remove(name);
    }


}