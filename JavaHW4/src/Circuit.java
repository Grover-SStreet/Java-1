import java.util.ArrayList;

/**
 * Represents a general Circuit
 * 10/25/17
 * V 1.0
 */
public class Circuit {

    /**
     * value of the calculated resistance.
     */
    double resistance = 0;

    /**
     * General resistance calculation method
     *
     * @return resistance amount
     */
    public double getResistanceAmount() {
        return resistance;
    }


    /**
     * returns resistance
     *
     * @return resistance value
     */
    public double getResistanceVal() {
        return resistance;
    }

    /**
     * Allows for Circuit objects to convert to a string.
     *
     * @return calculated resistance
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getResistanceAmount());
        return builder.toString();
    }
}
