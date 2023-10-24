package org.example.objet;

import org.example.CommandRegister;
import org.example.mouvement.Mouvement;
import org.example.mouvement.Orientation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BiConsumer;

public class Jardin {

    private final CommandRegister commandRegister;
    private int sizeX;
    private int sizeY;
    private List<Tondeuse> tondeuses = new ArrayList<>();

    public Jardin(CommandRegister commandRegister) {
        this.commandRegister = commandRegister;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Jardin from(String pathStr) throws IOException, URISyntaxException {
        Path path =
                Path.of(Objects.requireNonNull(Jardin.class.getClassLoader().getResource(pathStr)).toURI());

        List<String> lignes = Files.readAllLines(path);
        List<Integer> dimension =
                Arrays.stream(lignes.remove(0).split(" ")).map(Integer::parseInt).toList();
        this.sizeX = dimension.get(0);
        this.sizeY = dimension.get(1);

        for (int i = 0; i < lignes.size(); i += 2) {
            String[] initialPosition = lignes.get(i).split(" ");
            String moves = lignes.get(i + 1);
            int x = Integer.parseInt(initialPosition[0]);
            int y = Integer.parseInt(initialPosition[1]);
            Orientation orientation = Orientation.getOrientation(initialPosition[2]);
            List<Mouvement> mouvements = Mouvement.ofAsList(moves);
            this.tondeuses.add(new Tondeuse(x, y, orientation, mouvements));
        }

        return this;
    }

    public Jardin process() {
        for (Tondeuse tondeuse : tondeuses) {
            List<Mouvement> mouvements = tondeuse.getMouvements();
            for (Mouvement mouvement : mouvements) {
                BiConsumer<Jardin, Tondeuse> command = commandRegister.command(mouvement);
                if (command == null) {
                    throw new UnsupportedOperationException();
                }
                command.accept(this, tondeuse);
            }
        }

        return this;
    }
}
