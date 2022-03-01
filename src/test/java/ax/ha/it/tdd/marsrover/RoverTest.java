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
}
