package ax.ha.it.tdd.marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rover {
    private int xPos;
    private int yPos;
    private String heading;

    public Rover() {
        this.xPos = 0;
        this.yPos = 0;
        this.heading = "N";
    }

    public String getPos() {
        return "(" + xPos + "," + yPos + ")" + "(" + heading + ")";
    }

    public String inputCommands(String commands) {
        String[] list = commands.split(",");
        for (String c : list) {
            switch (c) {
                case "f" -> move(true);
                case "b" -> move(false);
                case "l" -> rotate(true);
                case "r" -> rotate(false);
                default -> System.out.println("Error");
            }
        }
        return commands;
    }
    private void move(boolean forwards) {
        int move = forwards ? 1 : -1;
        switch (heading) {
            case "N" -> yPos += move;
            case "S" -> yPos -= move;
            case "W" -> xPos -= move;
            case "E" -> xPos += move;
            default -> System.out.println("Error");
        }
    }
    private void rotate(boolean left) {
        int rotation = left ? -1 : 1;
        List<String> headings = new ArrayList<>(Arrays.asList("N","E","S","W"));
        heading = headings.get(mod(headings.indexOf(heading) + rotation,headings.size()));
    }
    private int mod(int a, int b) {
        return (((a%b)+b)%b);
    }
}
