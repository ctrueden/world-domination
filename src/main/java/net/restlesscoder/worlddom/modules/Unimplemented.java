package net.restlesscoder.worlddom.modules;

import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

/** Placeholder module for managing features that are not yet written. */
public class Unimplemented extends Module {

  // -- Constructor --

  public Unimplemented(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    output("This feature is not yet implemented.\n");
    server.setModule(clientId, parent);
  }

  public void processInput(String input) { }

}
