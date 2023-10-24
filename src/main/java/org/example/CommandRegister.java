package org.example;

import org.example.mouvement.Mouvement;
import org.example.objet.Jardin;
import org.example.objet.Tondeuse;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class CommandRegister {

    private final HashMap<Mouvement, BiConsumer<Jardin, Tondeuse>> map = new HashMap<>();

    public void registerOption(Mouvement mouvement, BiConsumer<Jardin, Tondeuse> action) {
        map.put(mouvement, action);
    }

    public BiConsumer<Jardin, Tondeuse> command(Mouvement mouvement) {
        return map.get(mouvement);
    }
}