public class Player {

    private String firstName = "";
    private String lastName = "";
    private String Position = "";
    private int atBats = 0;
    private int playerHits = 0;


    public String getPlayerName() {
        String builder = new StringBuilder()
                .append(firstName)
                .append(" ")
                .append(lastName)
                .toString();

        return builder;
    }

    public float getBattingAverage() {
        float average = playerHits / atBats;
        return average;
    }

}
