import java.util.ArrayList;
import java.util.List;

public class Serial extends Circuit {

    /**
     * List of circuits
     */
    List<Circuit> circuits = new ArrayList<Circuit>();


    /**
     * Adds Circuits to the list
     *
     * @param resistor the circuit piece
     */
    public void add(Circuit resistor) {
        circuits.add(resistor);
    }

    /**
     * calculates resistance using Serial formula
     *
     * @return calculated resistance
     */
    @Override
    public double getResistanceAmount() {
        double calcResistance = 0;
        for (int count = 0; count < circuits.size(); count++) {
            calcResistance += (circuits.get(count).getResistanceAmount());
        }
        return (calcResistance);
    }
}