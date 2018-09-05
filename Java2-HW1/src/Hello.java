/**
 * @author Austin Grover
 * @version Java Programming II – Homework 1
 * Class modeled after messages
 */
public class Hello {

    /**
     * Variable that will hold the value of message.
     */
    private String message;

    /**
     * Default constructor that initializes message to an empty value
     */
    public Hello() {
        this.message = "";
    }

    /**
     * Construcutor for class
     *
     * @param message custom message
     *                Will call setMessage to initialize the new message
     */
    public Hello(String message) {

        this.setMessage(message);
    }

    /**
     * Method to change the message variable
     *
     * @param message desired message
     * @throws IllegalArgumentException if the message is null
     */
    private void setMessage(String message) {
        try {
            this.message = message;
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to return custom message
     *
     * @return custom message
     */
    public String getMessage() {

        return this.message;
    }

    /**
     * String representation of an object
     * calls the getMessage method
     *
     * @return message in all caps
     */
    @Override
    public String toString() {
        return getMessage().toUpperCase();
    }
}

