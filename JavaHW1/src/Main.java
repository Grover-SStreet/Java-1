import java.util.Scanner;

public class Main {
    //validates input for doubles
    public static double validateInput(Scanner reader, double tempNumber) {
        while (tempNumber <= 0) {
                reader.nextLine();
                System.out.println("Please enter a valid number greater then 0.");
                if (reader.hasNextDouble() == true) {
                    tempNumber = reader.nextDouble();
                }
            }
        return tempNumber;
    }
    //validates input for ints
    public static int validateInput(Scanner reader, int tempNumber) {
        reader.nextLine();

        while (tempNumber <= 0) {
            reader.nextLine();
            System.out.println("Please enter a valid number greater then 0.");
            if (reader.hasNextInt() == true) {
                tempNumber = reader.nextInt();
            }
        }
        return tempNumber;
    }

    //validates input for strings
    public static String validateInput(Scanner reader, String tempString) {

        while (!tempString.matches("y") && !tempString.matches("n")) {

            System.out.println("Please enter y or n.");
            tempString = reader.next();
            System.out.print(tempString);
        }
        return tempString;
    }

    //constant used in program
    public static final double Format_Divide = 100.0;
    public static final double NUMBER_MONTHS = 12;

    public static void main(String[] args) {
        String answer = "";
        do {

            System.out.println("Please enter loan amount: ");

            //establishes scanner for user input
            Scanner input = new Scanner(System.in);

            //User input for loan Amount
            double loanAmount = 0;

            if (input.hasNextDouble() == true) {
                loanAmount = validateInput(input, input.nextDouble());
            } else {
                loanAmount = validateInput(input, loanAmount);
            }

            //User input for interest
            System.out.println("Please enter interest rate: ");

            double interestRate = 0;
            if (input.hasNextDouble() == true) {
                interestRate = validateInput(input, input.nextDouble());
            } else {
                interestRate = validateInput(input, interestRate);
            }

            //User inputs for years
            System.out.println("Please enter number of years: ");

            int numberYears = 0;

            if (input.hasNextInt() == true) {
                numberYears = validateInput(input, input.nextInt());
            } else {
                numberYears = validateInput(input, numberYears);
            }

            //calculations
            double calcInterest = (interestRate / Format_Divide) / NUMBER_MONTHS;
            double numberOfPayments = NUMBER_MONTHS * numberYears;
            double bottomHalfFormula = 1 - Math.pow(1 + calcInterest, -numberOfPayments);
            double monthlyPayment = (calcInterest / bottomHalfFormula) * loanAmount;
            monthlyPayment = Math.round(monthlyPayment * Format_Divide) / Format_Divide;

            //formats user output
            System.out.printf("%nLoan amount: %.2f%nYearly interest rate: %.2f%nNumber of years: %d%nMonthly payment: %.2f%n"
                    , loanAmount, interestRate, numberYears, monthlyPayment);

            //prompt to continue program
            System.out.printf("Would you like to continue?%n");
            answer = validateInput(input, input.next());

        } while (answer.matches("y"));

    }
}
