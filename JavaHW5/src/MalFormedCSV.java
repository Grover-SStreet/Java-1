/**
 * Simple exception class to handle mal formatted CSV
 * @author Austin Grover
 * @version 1.0
 *
 */
public class MalFormedCSV  extends Exception{

    /**
     * Exception to be handled with message body.
     */
    public MalFormedCSV(){
        super("MalFormatted CSV File");
    }
}
