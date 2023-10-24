package org.example.mouvement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Mouvement {
  GAUCHE("G"),
  DROITE("D"),
  AVANCER("A");

  private static final Map<String, Mouvement> BY_LETTER = new HashMap<>();

  static {
    for (Mouvement e : values()) {
      BY_LETTER.put(e.letter, e);
    }
  }

  private final String letter;

  Mouvement(String letter) {
    this.letter = letter;
  }

  public static Mouvement getMouvement(String name) {
    return BY_LETTER.get(name);
  }
}
