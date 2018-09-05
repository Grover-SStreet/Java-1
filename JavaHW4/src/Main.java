public class Main {
    public static void main(String[] args) {


        //Refer to document for models and calculations

        //Test case 1
        Parallel circuit1 = new Parallel();
        circuit1.add(new Resistor(100.0));
        Serial circuit2 = new Serial();
        circuit2.add(new Resistor(100.0));
        circuit2.add(new Resistor(200.0));
        circuit1.add(circuit2);
        System.out.printf("Combined resistance for circuit 1: %s\n", circuit1);


        //Test case 2
        Serial circuit3 = new Serial();
        circuit3.add(new Resistor(100.0));
        circuit3.add(new Resistor(200.0));
        System.out.printf("Combined resistance for circuit 3: %s\n", circuit3);


        // Test Case 3
        Parallel circuit4 = new Parallel();
        circuit4.add(new Resistor(200));
        circuit4.add(new Resistor(300.0));
        System.out.printf("Combined resistance for circuit 4: %s\n", circuit4);


        // Test Case 4
        Serial circuit5 = new Serial();
        Parallel circuit6 = new Parallel();
        Serial circuit7 = new Serial();


        circuit5.add(new Resistor(100));
        circuit5.add(new Resistor(100));
        circuit5.add(new Resistor(100));
        circuit6.add(new Resistor(100));
        circuit6.add(new Resistor(100));
        circuit7.add(new Resistor(100));
        circuit7.add(new Resistor(100));

        circuit5.add(circuit6);
        circuit5.add(circuit7);

        System.out.printf("Combined resistance for circuit 5: %s\n", circuit5);
    }

}
