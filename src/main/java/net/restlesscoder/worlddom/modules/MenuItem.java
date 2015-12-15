package net.restlesscoder.worlddom.modules;

import net.restlesscoder.worlddom.server.Module;

public class MenuItem {
  public Module module;
  public String label;
  public char shortcut;

  public MenuItem(Module module, String label, char shortcut) {
    this.module = module;
    this.label = label;
    this.shortcut = shortcut;
  }
}
