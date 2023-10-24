package org.example.mouvement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MouvementTest {

  @Test
  public void getMoveAdvanceTest() {
    Mouvement expected = Mouvement.AVANCER;
    Mouvement actual = Mouvement.getMouvement("A");

    assertEquals(expected, actual);
  }

  @Test
  public void getMoveLeftTest() {
    Mouvement expected = Mouvement.GAUCHE;
    Mouvement actual = Mouvement.getMouvement("G");

    assertEquals(expected, actual);
  }

  @Test
  public void getMoveRightTest() {
    Mouvement expected = Mouvement.DROITE;
    Mouvement actual = Mouvement.getMouvement("D");

    assertEquals(expected, actual);
  }

  @Test
  public void getMoveNullTest() {
    assertNull(Mouvement.getMouvement("X"));
  }
}