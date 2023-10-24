package org.example.mouvement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrientationTest {

  @Test
  public void getOrientationNordTest() {
    Orientation expected = Orientation.NORD;
    Orientation actual = Orientation.getOrientation("N");

    assertEquals(expected, actual);
  }

  @Test
  public void getOrientationEstTest() {
    Orientation expected = Orientation.EST;
    Orientation actual = Orientation.getOrientation("E");

    assertEquals(expected, actual);
  }

  @Test
  public void getOrientationOuestTest() {
    Orientation expected = Orientation.OUEST;
    Orientation actual = Orientation.getOrientation("W");

    assertEquals(expected, actual);
  }

  @Test
  public void getOrientationSudTest() {
    Orientation expected = Orientation.SUD;
    Orientation actual = Orientation.getOrientation("S");

    assertEquals(expected, actual);
  }
}