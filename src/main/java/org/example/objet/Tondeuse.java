package org.example.objet;

import org.example.mouvement.Mouvement;
import org.example.mouvement.Orientation;

import java.util.List;
import java.util.Objects;

public class Tondeuse {

    private int x;
    private int y;
    private Orientation orientation;
    private final List<Mouvement> mouvements;

    public Tondeuse(int x, int y, Orientation orientation, List<Mouvement> mouvements) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.mouvements = List.copyOf(mouvements);
    }

    @Override
    public String toString() {
        return x + " " + y + " " +orientation.getInitiale();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tondeuse tondeuse = (Tondeuse) o;
        return x == tondeuse.x
                && y == tondeuse.y
                && orientation == tondeuse.orientation
                && Objects.equals(mouvements, tondeuse.mouvements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientation, mouvements);
    }
}