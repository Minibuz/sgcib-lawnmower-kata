package org.example.objet;

import org.example.CommandRegister;
import org.example.mouvement.Mouvement;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

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
}
