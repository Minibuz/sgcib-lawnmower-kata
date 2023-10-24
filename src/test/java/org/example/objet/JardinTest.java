package org.example.objet;

import org.example.CommandRegister;
import org.example.mouvement.Mouvement;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

class JardinTest {

  @Test
  void jardinProcessTest() {
    assertThrows(
        UnsupportedOperationException.class,
        () -> new Jardin(new CommandRegister()).from("test").process().writeOutputAsString());
  }

  @Test
  void jardinProcessTest2() throws IOException, URISyntaxException {
    CommandRegister commandRegister = new CommandRegister();
    commandRegister.registerOption(
        Mouvement.AVANCER,
        (jardin, tondeuse) -> {
          if (tondeuse.isInside(jardin.getSizeX(), jardin.getSizeY())) {
            tondeuse.advance();
          }
        });

    String expected = "1 5 N\n5 3 E\n";
    String actual = new Jardin(commandRegister).from("test").process().writeOutputAsString();

    assertEquals(expected, actual);
  }

  @Test
  void jardinProcessTest3() throws IOException, URISyntaxException {
    List<String> operation = new ArrayList<>();

    CommandRegister commandRegister = new CommandRegister();
    BiConsumer<Jardin, Tondeuse> biConsumer = (__, ___) -> operation.add("1");
    commandRegister.registerOption(Mouvement.GAUCHE, biConsumer);
    commandRegister.registerOption(Mouvement.DROITE, biConsumer);
    commandRegister.registerOption(Mouvement.AVANCER, biConsumer);

    String __ = new Jardin(commandRegister).from("test2").process().writeOutputAsString();

    assertEquals(19, operation.size());
  }
}
