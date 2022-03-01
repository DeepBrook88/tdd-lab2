package ax.ha.it.tdd.marsrover;

import java.util.Arrays;

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
        return commands;
    }
}
