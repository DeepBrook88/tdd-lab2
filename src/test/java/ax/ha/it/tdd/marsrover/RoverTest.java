package ax.ha.it.tdd.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover();
    }

    @Test
    void getRoverPos() {
        assertEquals("(0,0)(N)",rover.getPos());
    }
    @Test
    void inputCommands() {
        assertEquals("f,l,f,l,f,l,f,l",rover.inputCommands("f,l,f,l,f,l,f,l"));
    }
    @Test
    void moveForwardsAndBackwards() {
        rover.inputCommands("f,f,b");
        assertEquals("(0,1)(N)", rover.getPos());
    }
    @Test
    void rotateLeft() {
        rover.inputCommands("l,l");
        assertEquals("(0,0)(S)", rover.getPos());
    }
    @Test
    void rotateRight() {
        rover.inputCommands("r");
        assertEquals("(0,0)(E)", rover.getPos());
    }
    @Test
    void wrapXAxis() {
        rover.inputCommands("l,f,f");
        assertEquals("(4,0)(W)",rover.getPos());
    }
    @Test
    void wrapYAxis() {
        rover.inputCommands("f,f,f,f,f,f,f");
        assertEquals("(0,1)(N)",rover.getPos());
    }
}
