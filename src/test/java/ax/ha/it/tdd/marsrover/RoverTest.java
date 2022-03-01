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
}
