package org.example.objet;

import static org.junit.jupiter.api.Assertions.*;

import org.example.mouvement.Orientation;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TondeuseTest {

    @Test
    public void rotateLeftTest() {
        Tondeuse actual = new Tondeuse(0, 0, Orientation.NORD, List.of());
        Tondeuse expected = new Tondeuse(0, 0, Orientation.OUEST, List.of());

        actual.rotateLeft();

        assertEquals(expected, actual);
    }

    @Test
    public void rotateRightTest() {
        Tondeuse actual = new Tondeuse(0, 0, Orientation.NORD, List.of());
        Tondeuse expected = new Tondeuse(0, 0, Orientation.EST, List.of());

        actual.rotateRight();

        assertEquals(expected, actual);
    }

    @Test
    public void advanceTest() {
        Tondeuse actual = new Tondeuse(0, 0, Orientation.NORD, List.of());
        Tondeuse expected = new Tondeuse(0, 1, Orientation.NORD, List.of());

        actual.advance();

        assertEquals(expected, actual);
    }

    @Test
    public void isOutsideTrueTest() {
        Tondeuse tondeuse = new Tondeuse(10, 10, Orientation.NORD, List.of());

        assertFalse(tondeuse.isInside(5, 5));
    }

    @Test
    public void isOutsideFalseTest() {
        Tondeuse tondeuse = new Tondeuse(4, 0, Orientation.NORD, List.of());

        assertTrue(tondeuse.isInside(5, 5));
    }
}
