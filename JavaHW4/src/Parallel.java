import java.util.ArrayList;
import java.util.List;

public class Parallel extends Circuit {

    /**
     * List of circuits
     */
    List<Circuit> circuits = new ArrayList<>();

    /**
     * Adds Circuits to the list
     *
     * @param resistor the circuit piece
     */
    public void add(Circuit resistor) {
        circuits.add(resistor);
    }

    /**
     * Calculates resistance using parallel formula
     *
     * @return calculated resistance
     */
    @Override
    public double getResistanceAmount() {
        double calcResistance = 0;
        for (int count = 0; count < circuits.size(); count++) {
            calcResistance += (1 / circuits.get(count).getResistanceAmount());
        }
        return (1 / calcResistance);
    }
}

