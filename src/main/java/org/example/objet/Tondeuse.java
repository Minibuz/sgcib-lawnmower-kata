package org.example.objet;

import org.example.mouvement.Mouvement;
import org.example.mouvement.Orientation;
import org.example.mouvement.Vecteur;

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

    public List<Mouvement> getMouvements() {
        return mouvements;
    }

    public void rotateLeft() {
        int newOrientation =
                (orientation.ordinal() - 1 + Orientation.values().length) % Orientation.values().length;
        this.orientation = Orientation.values()[newOrientation];
    }

    public void rotateRight() {
        int newOrientation =
                (orientation.ordinal() + 1 + Orientation.values().length) % Orientation.values().length;
        this.orientation = Orientation.values()[newOrientation];
    }

    public void advance() {
        Vecteur vecteur = this.orientation.getVecteur();
        this.x += vecteur.x();
        this.y += vecteur.y();
    }

    public boolean isInside(int sizeX, int sizeY) {
        Vecteur vecteur = this.orientation.getVecteur();
        int potentialX = this.x + vecteur.x();
        int potentialY = this.y + vecteur.y();
        return (potentialX <= sizeX && potentialX >= 0) && (potentialY <= sizeY && potentialY >= 0);
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