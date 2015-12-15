package net.restlesscoder.worlddom.modules;

import net.restlesscoder.worlddom.game.Person;
import net.restlesscoder.worlddom.server.GameServer;
import net.restlesscoder.worlddom.server.Module;

public class ShowStats extends Info {

  // -- Constructor --

  public ShowStats(GameServer server, int clientId, Module parent) {
    super(server, clientId, parent);
  }

  // -- Module API methods --

  public void activate() {
    StringBuffer sb = new StringBuffer();

    Person pc = server.getCharacter(clientId);
    sb.append("Strength: " + pc.strength + "\n");
    sb.append("Vitality: " + pc.vitality + "\n");
    sb.append("Speed: " + pc.speed + "\n");
    sb.append("Stealth: " + pc.stealth + "\n");
    sb.append("Skill: " + pc.skill + "\n");
    sb.append("Magic: " + pc.magic + "\n");
    sb.append("Faith: " + pc.faith + "\n");
    sb.append("Luck: " + pc.luck + "\n");
    sb.append("Charm: " + pc.charm + "\n");
    sb.append("HP: " + pc.curHP + "/" + pc.maxHP + "\n");
    sb.append("Press any key to continue.");

    output(sb.toString());
  }

}
