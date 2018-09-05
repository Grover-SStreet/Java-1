import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Defines CSV Reader functionality
 *
 * @author Austin Grover
 * @version 1.0
 */
public class CSVReader extends MalFormedCSV {


    ArrayList<ArrayList<String>> formattedData = new ArrayList<ArrayList<String>>();
    private String filePath = "";

    /**
     * Checks for malformed CSB
     *
     * @param test Parsed File
     * @throws MalFormedCSV throws exception if row 1 and 2 do not have the same number of values stored.
     */
    public void malformed(ArrayList<ArrayList<String>> test) throws MalFormedCSV {

        if (test.get(0).size() != test.get(1).size()) {
            throw new MalFormedCSV();
        }
    }

    /**
     * Parses CSV
     *
     * @param tempString CSV Line
     * @return ArrayList of the parsed elements of the string.
     * @throws IOException If the file is does not exist or issues indexing string.
     */
    private ArrayList<String> parse(String tempString) throws IOException {
        boolean inDoubleQuotes = false;
        int counter = 0;
        ArrayList<String> columnRecords = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < tempString.length(); x++) {
            if (counter != 0) {
                if (tempString.charAt(x) == '"') {
                    inDoubleQuotes = true;
                    if (counter < 4) {
                        counter++;
                    }
                    if (counter == 4) {
                        inDoubleQuotes = false;
                        counter = 0;
                    }
                }
                if (counter != 0) {
                    builder.append(tempString.charAt(x));
                }

            } else if (tempString.charAt(x) == '"' && tempString.charAt(x + 1) == '"') {
                counter++;
                inDoubleQuotes = true;
            } else if (tempString.charAt(x) == '"' && tempString.charAt(x + 1) != '"') {
                inDoubleQuotes = true;
                counter = 3;

            } else if (tempString.charAt(x) == ',' && inDoubleQuotes == false) {
                columnRecords.add(builder.toString().trim());
                builder.setLength(0);
            } else {
                builder.append(tempString.charAt(x));
            }
        }
        columnRecords.add(builder.toString().trim());
        return columnRecords;
    }


    /**
     * Reads the file checks the format and loads the data.
     *
     * @throws IOException If file is not available or unable to index.
     */
    public void read() throws IOException {
        String fileName = filePath;
        try (Scanner in =
                     new Scanner(
                             new BufferedReader(
                                     new FileReader(fileName)))) {
            while (in.hasNextLine() == true) {
                String data = in.nextLine();
                ArrayList<String> parsedSentence = parse(data);
                formattedData.add(parsedSentence);
            }

        }
        try {
            malformed(formattedData);
        } catch (MalFormedCSV ex) {
            System.out.println(ex.getMessage());
        }

    }


    /**
     * gets the number of rows int he CSV
     *
     * @return number of rows
     */
    public int numberOfRows() {
        return formattedData.size();

    }


    /**
     * gets the number of fields in the csv.
     *
     * @return number of Fields
     */
    public int numberOfFields() {
        return formattedData.get(0).size();
    }


    /**
     * Index an element of the table
     *
     * @param row    row wanted
     * @param column column wanted
     * @return cell where the row and column index.
     */
    public String field(int row, int column) {
        String answer = "";
        if (row > 0 && column > 0) {
            answer = formattedData.get(column - 1).get(row - 1);
        } else {
            System.out.println("Please Enter a row and column greater then 0.");
        }

        if (answer == null || answer.length() == 0) {
            answer = " record was null";

        }
        return answer;
    }


    /**
     * Returns file path
     *
     * @return
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path
     *
     * @param filePath User defined file path.
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
