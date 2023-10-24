package org.example;

import org.example.mouvement.Mouvement;
import org.example.objet.Jardin;
import org.example.objet.Tondeuse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {

  public static void main(String[] args) throws IOException, URISyntaxException {
    CommandRegister commandRegister = new CommandRegister();
    commandRegister.registerOption(Mouvement.GAUCHE, (__, tondeuse) -> tondeuse.rotateLeft());
    commandRegister.registerOption(Mouvement.DROITE, (__, tondeuse) -> tondeuse.rotateRight());
    commandRegister.registerOption(Mouvement.AVANCER, (jardin, tondeuse) -> {
      if (tondeuse.isInside(jardin.getSizeX(), jardin.getSizeY())) {
        tondeuse.advance();
      }
    });

    new Jardin(commandRegister)
            .from("entry")
            .process();
  }
}
