package ax.ha.it.tdd.marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rover {
    private int xPos;
    private int yPos;
    private String heading;
    private int[][] world;

    public Rover() {
        this.xPos = 0;
        this.yPos = 0;
        this.heading = "N";
        world = new int[6][6];
    }

    public String getPos() {
        return "(" + xPos + "," + yPos + ")" + "(" + heading + ")";
    }

    public String inputCommands(String commands) {
        String[] list = commands.split(",");
        try {
            for (String c : list) {
                switch (c) {
                    case "f" -> move(true);
                    case "b" -> move(false);
                    case "l" -> rotate(true);
                    case "r" -> rotate(false);
                    default -> System.out.println("Error");
                }
            }
        } catch (InvalidMovementException e) {
            System.out.println(e.getMessage());
        }
        return commands;
    }

    public void setWorld(int[][] world) {
        this.world = world;
    }

    private void move(boolean forwards) throws InvalidMovementException {
        int move = forwards ? 1 : -1;
        switch (heading) {
            case "N" -> {
                detectObstacle(xPos,mod(yPos + move,6));
                yPos += move;
            }
            case "S" -> {
                detectObstacle(xPos,mod(yPos - move,6));
                yPos -= move;
            }
            case "W" -> {
                detectObstacle(mod(xPos - move,6),yPos);
                xPos -= move;
            }
            case "E" -> {
                detectObstacle(mod(xPos + move,6),yPos);
                xPos += move;
            }
            default -> System.out.println("Error");
        }
        xPos = mod(xPos, 6);
        yPos = mod(yPos, 6);
    }

    private void rotate(boolean left) {
        int rotation = left ? -1 : 1;
        List<String> headings = new ArrayList<>(Arrays.asList("N","E","S","W"));
        heading = headings.get(mod(headings.indexOf(heading) + rotation,headings.size()));
    }

    private int mod(int a, int b) {
        return (((a%b)+b)%b);
    }

    private void detectObstacle(int xMove, int yMove) throws InvalidMovementException{
        if (world[mod(xMove+5,6)][yMove] == 1) {
            throw new InvalidMovementException("Warning obstacle found at pos ("+xMove+","+yMove+")");
        }
    }
}
