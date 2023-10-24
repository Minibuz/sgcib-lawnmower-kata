package org.example.mouvement;

import java.util.HashMap;
import java.util.Map;

public enum Orientation {
    NORD("N", new Vecteur(0, 1)),
    EST("E", new Vecteur(1, 0)),
    SUD("S", new Vecteur(0, -1)),
    OUEST("W", new Vecteur(-1, 0));

    private static final Map<String, Orientation> BY_LETTER = new HashMap<>();

    static {
        for (Orientation e : values()) {
            BY_LETTER.put(e.initiale, e);
        }
    }

    private final String initiale;
    private final Vecteur vecteur;

    Orientation(String initiale, Vecteur vecteur) {
        this.initiale = initiale;
        this.vecteur = vecteur;
    }

    public Vecteur getVecteur() {
        return vecteur;
    }

    public static Orientation getOrientation(String name) {
        return BY_LETTER.get(name);
    }
}
