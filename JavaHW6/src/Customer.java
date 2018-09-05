/**
 * @Author Austin Grover
 * @Version 1.3
 * Business logic tier
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public final class Customer implements Comparable {

    String email = "";
    String fName = "";
    String lName = "";


    /**
     * Constructor for Customer class
     * @param email email of the customer
     * @param fName first name of customer
     * @param lName last name of customer
     */
    Customer(String email, String fName, String lName) {
        setfName(fName);
        setEmail(email);
        setlName(lName);
    }

    /**
     * Gets the customers Email
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the customer email
     * @param email the desired email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the first name of the customer
     * @return fist name
     */
    public String getfName() {
        return this.fName;
    }

    /**
     * Set the fist name of the customer
     * @param fName the desired first name
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Gets the last name of the customer
     * @return last name
     */
    public String getlName() {
        return this.lName;
    }

    /**
     * Sets the last name of the customer
     * @param lName the desired last name
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Declares static instance of customerFNameComparator class.
     */
    public static final customerFNameComparator customerFirstNameComparator = new customerFNameComparator();

    /**
     * Creates a class that implements Comparator
     */
    private static class customerFNameComparator implements Comparator<Customer> {

        /**
         * Defines comparator where name length is compared then the difference in hash code if the name length is equal
         * @param o1 first Customer obj
         * @param o2 second Customer obj
         * @return Integer determining if they are equal or one is greater then the other.
         */
        @Override
        public int compare(Customer o1, Customer o2) {

            if (o1.getfName().length() > o2.getfName().length()) {
                return 1;
            } else if (o1.getfName().length() < o2.getfName().length()) {
                return -1;
            } else {
                return (o1.getfName().hashCode() - o2.getfName().hashCode());
            }
        }
    }

    /**
     * Declares static instance of customerEmailComparator class
     */
    public static final customerEmailComparator CustomerEmailComparator = new customerEmailComparator();

    /**
     * Declares new class customerEmailComparator that implements Comparator
     */
    private static class customerEmailComparator implements Comparator<Customer> {
        /**
         * Defines the difference between Customer email. First comparing length then comparing HashCode values.
         * @param o1 First customer obj
         * @param o2 Second customer obj
         * @return Integer determining if the objects are equal or if one is greater then the other.
         */
        @Override
        public int compare(Customer o1, Customer o2) {

            if (o1.getEmail().length() > o2.getEmail().length()) {
                return 1;
            } else if (o1.getEmail().length() < o2.getEmail().length()) {
                return -1;
            } else {
                if (o1.getEmail().hashCode() == o2.getEmail().hashCode()) {
                    return 0;
                } else if (o1.getEmail().hashCode() > o2.getEmail().hashCode()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    /**
     * Gets a string from the DAO
     * @param sortNumber the desired sort configuration
     * @return string of object toStrings.
     */

    public static String listCustomers(int sortNumber) {
        ArrayList<Customer> customerList = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        try {
            customerList = CustomerDAO.read();
        } catch (Exception e) {
            System.out.append(e.getMessage());
        }

        if (sortNumber == 1) {
            Collections.sort(customerList);
        } else if (sortNumber == 2) {
            customerList.sort(CustomerEmailComparator);
        } else {
            customerList.sort(customerFirstNameComparator);
        }

        for (int index = 0; index < customerList.size(); index++) {
            builder.append(customerList.get(index).toString());
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * Updates a Customer
     * @param email Desired customer email
     * @param changed the new Customer object to replace with updates values.
     */
    public static void update(String email, Customer changed) {

        ArrayList<Customer> customerList = new ArrayList<>();

        try {
            customerList = CustomerDAO.read();
        } catch (Exception e) {
            System.out.append(e.getMessage());
        }
        boolean match = false;

        for (int index = 0; index < customerList.size(); index++) {
            if (customerList.get(index).getEmail().equals(email)) {
                customerList.set(index, changed);
                match = true;
            }
        }

        if (match == false) {
            System.out.printf("There was no match for %s", email);
        }

        for (int index = 0; index < customerList.size(); index++) {
            if (index == 0) {
                CustomerDAO.write(customerList.get(index), false);
            } else {
                CustomerDAO.write(customerList.get(index), true);
            }
        }
    }

    /**
     * Overloaded option of the upd
     * This will delete the Customer that matches the email
     * @param email Takes the desired email of the Customer to delete
     */
    public static void update(String email) {

        ArrayList<Customer> customerList = new ArrayList<>();

        try {
            customerList = CustomerDAO.read();
        } catch (Exception e) {
            System.out.append(e.getMessage());
        }
        boolean match = false;

        for (int index = 0; index < customerList.size(); index++) {
            if (customerList.get(index).getEmail().equals(email)) {
                if (customerList.get(index).getEmail().equals(email)) {
                    customerList.remove(index);
                    match = true;
                }
            }

        }
        if (match == false) {
            System.out.printf("There was no match for %s", email);
        }

        for (int index = 0; index < customerList.size(); index++) {
            if (index == 0) {
                CustomerDAO.write(customerList.get(index), false);
            } else {
                CustomerDAO.write(customerList.get(index), true);
            }
        }
    }

    /**
     * The default sort for this class
     * @param temp Customer object comparing against
     * @return An integer that determines if the Customers are equal or if one is greater then the other.
     */
    @Override
    public int compareTo(Object temp) {
        Customer tempCustomer = (Customer) temp;

        if (this.getlName().length() > tempCustomer.getlName().length()) {
            return 1;
        } else if (this.getlName().length() < tempCustomer.getlName().length()) {
            return -1;
        } else {
            return (this.getlName().hashCode() - tempCustomer.getlName().hashCode());
        }
    }


    /**
     * Desired output for each object
     * @return A formatted string with object attributes.
     */
    @Override
    public String toString() {
        return String.format("%-40s %-15s %-15s", this.email, this.fName, this.lName);

    }

    /**
     * Compares objects to see if they are equal
     * @param o object to determine if it is equal to this one.
     * @return true or false if the object is equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (fName != null ? !fName.equals(customer.fName) : customer.fName != null) return false;
        return lName != null ? lName.equals(customer.lName) : customer.lName == null;
    }

    /**
     * Hash code to allow for proper sorting
     * @return hashcode value of object.
     */

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        return result;
    }

}
