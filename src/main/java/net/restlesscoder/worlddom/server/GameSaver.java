package net.restlesscoder.worlddom.server;

import com.thoughtworks.xstream.XStream;
import java.io.*;
import net.restlesscoder.worlddom.game.*;
import net.restlesscoder.worlddom.modules.Login;

/** Game state serialization class. */
public class GameSaver {

  // -- Fields --

  /** Object/XML serializer for saving and restoring game state. */
  private XStream xs;

  // -- Constructor --

  public GameSaver() {
    xs = new XStream();
    xs.setMode(XStream.ID_REFERENCES);
    xs.alias("character", Person.class);
    xs.alias("class", Job.class);
    xs.alias("game", Game.class);
    xs.alias("gear", Gear.class);
    xs.alias("gender", Gender.class);
    xs.alias("item", Item.class);
    xs.alias("province", Province.class);
    xs.alias("race", Race.class);
    xs.alias("spell", Spell.class);
    xs.alias("spellbook", Spellbook.class);
  }

  // -- GameServer API methods --

  /** Saves game state to the given file. */
  public void saveState(Game game, String file) {
    String xml = xs.toXML(game);
    try {
      PrintWriter out = new PrintWriter(new FileWriter(file));
      out.println(xml);
      out.close();
    }
    catch (IOException exc) {
      exc.printStackTrace();
    }
  }

  /** Restores game state from the given file. */
  public Game restoreState(String file) {
    String xml = null;
    try {
      BufferedReader in = new BufferedReader(new FileReader(file));
      StringBuffer sb = new StringBuffer();
      while (true) {
        String line = in.readLine();
        if (line == null) break;
        sb.append(line);
      }
      in.close();
      xml = sb.toString();
    }
    catch (IOException exc) {
      exc.printStackTrace();
    }
    return (Game) xs.fromXML(xml);
  }

  // -- Main method --

  /** Helper method for building up a skeleton game state. */
  public static void main(String[] args) {
    GameSaver gs = new GameSaver();

    Game game;

    System.out.println("Creating game");

    game = new Game();

    Person me = new Person();

    me.player = "Curtis";

    Race human = new Race();
    human.name = "human";
    me.race = human;

    Gender male = new Gender();
    male.name = "male";
    me.gender = male;

    me.age = 28;

    Job job = new Job();
    job.name = "programmer";
    me.job = job;

    Gear gear = new Gear();
    Item item1 = new Item();
    item1.name = "laptop";
    gear.items.add(item1);
    Item item2 = new Item();
    item2.name = "windbreaker";
    gear.items.add(item2);
    me.gear = gear;

    Spellbook book = new Spellbook();
    Spell spell1 = new Spell();
    spell1.name = "vim";
    book.spells.add(spell1);
    Spell spell2 = new Spell();
    spell2.name = "ant";
    book.spells.add(spell2);
    Spell spell3 = new Spell();
    spell3.name = "xstream";
    book.spells.add(spell3);
    me.spells = book;

    //me.lord = null;
    //me.vassals.add(you);

    Province wi = new Province("Wisconsin");
    wi.description = "Wisconsin: America's dairyland. You see some cows.\n";
    Province il = new Province("Illinois");
    il.description = "Illinois: the land of Lincoln. You see a flat plain.\n";

    wi.neighbors.add(il);
    il.neighbors.add(wi);

    me.location = il;
    me.owned.add(wi);

    game.characters.add(me);

    World world = new World();
    world.provinces.add(wi);
    world.provinces.add(il);

    game.world = world;

    // oh man, here come the jobs...

    // tier 0

    Job commoner = new Job();
    commoner.name = "commoner";

    // tier 1

    Job knight = new Job(); // M
    knight.name = "knight";

    Job wizard = new Job(); // A
    wizard.name = "wizard";

    Job vicar = new Job(); // D
    vicar.name = "vicar";

    Job thief = new Job(); // S
    thief.name = "thief";

    // hook tier 1 to tier 0

    commoner.martial = knight;
    commoner.arcane = wizard;
    commoner.divine = vicar;
    commoner.shadow = thief;

    // tier 2

    Job samurai = new Job(); // M-A
    samurai.name = "samurai";

    Job barbarian = new Job(); // M-D
    barbarian.name = "barbarian";

    Job monk = new Job(); // M-S
    monk.name = "monk";

    Job warWizard = new Job(); // A-M
    warWizard.name = "war wizard";

    Job holySorcerer = new Job(); // A-D, D-A
    holySorcerer.name = "holy sorcerer";

    Job illusionist = new Job(); // A-S
    illusionist.name = "illusionist";

    Job paladin = new Job(); // D-M
    paladin.name = "paladin";

    Job seeker = new Job(); // D-S
    seeker.name = "seeker";

    Job assassin = new Job(); // S-M
    assassin.name = "assassin";

    Job enticer = new Job(); // S-A
    enticer.name = "enticer";
    enticer.femaleName = "seductress";

    Job gambler = new Job(); // S-D
    gambler.name = "gambler";

    // hook tier 2 to tier 1

    knight.arcane = samurai;
    knight.divine = barbarian;
    knight.shadow = monk;

    wizard.martial = warWizard;
    wizard.divine = holySorcerer;
    wizard.shadow = illusionist;

    vicar.martial = paladin;
    vicar.arcane = holySorcerer;
    vicar.shadow = seeker;

    thief.martial = assassin;
    thief.arcane = enticer;
    thief.divine = gambler;

    // tier 3

    Job bladesinger = new Job(); // M-A-D
    bladesinger.name = "bladesinger";

    Job ninja = new Job(); // M-A-S, S-M-A
    ninja.name = "ninja";

    Job shaman = new Job(); // M-D-A
    shaman.name = "shaman";

    Job berserker = new Job(); // M-D-S
    berserker.name = "berserker";

    Job psion = new Job(); // M-S-A, A-M-S
    psion.name = "psion";

    Job ironFist = new Job(); // M-S-D
    ironFist.name = "iron fist";

    Job channeler = new Job(); // A-M-D, D-M-A
    channeler.name = "channeler";

    Job templar = new Job(); // A-D-M, D-A-M
    templar.name = "templar";

    Job fatespinner = new Job(); // A-D-S, D-A-S
    fatespinner.name = "fatespinner";

    Job strider = new Job(); // A-S-M
    strider.name = "strider";

    Job necromancer = new Job(); // A-S-D
    necromancer.name = "necromancer";

    Job bountyHunter = new Job(); // D-M-S
    bountyHunter.name = "bounty hunter";

    Job ranger = new Job(); // D-S-M
    ranger.name = "ranger";

    Job zealot = new Job(); // D-S-A
    zealot.name = "zealot";

    Job blackguard = new Job(); // S-M-D
    blackguard.name = "blackguard";

    Job bard = new Job(); // S-A-M
    bard.name = "bard";

    Job incubus = new Job(); // S-A-D
    incubus.name = "incubus";
    incubus.femaleName = "succubus";

    Job pirate = new Job(); // S-D-M
    pirate.name = "pirate";

    Job timeWeaver = new Job(); // S-D-A
    timeWeaver.name = "time weaver";

    // hook tier 3 to tier 2

    samurai.divine = bladesinger;
    samurai.shadow = ninja;

    barbarian.arcane = shaman;
    barbarian.shadow = berserker;

    monk.arcane = psion;
    monk.divine = ironFist;

    warWizard.divine = channeler;
    warWizard.shadow = psion;

    holySorcerer.martial = templar;
    holySorcerer.shadow = fatespinner;

    illusionist.martial = strider;
    illusionist.divine = necromancer;

    paladin.arcane = channeler;
    paladin.shadow = bountyHunter;

    seeker.martial = ranger;
    seeker.arcane = zealot;

    assassin.arcane = ninja;
    assassin.divine = blackguard;

    enticer.martial = bard;
    enticer.divine = incubus;

    gambler.martial = pirate;
    gambler.arcane = timeWeaver;

    // tier 4

    Job jediKnight = new Job(); // M-A-D-S
    jediKnight.name = "Jedi knight";

    Job doomsayer = new Job(); // M-A-S-D, S-M-A-D
    doomsayer.name = "doomsayer";

    Job shadowmancer = new Job(); // M-D-A-S
    shadowmancer.name = "shadowmancer";

    Job pyrokineticist = new Job(); // M-D-S-A
    pyrokineticist.name = "pyrokineticist";

    Job mindFlayer = new Job(); // M-S-A-D, A-M-S-D
    mindFlayer.name = "mind flayer";

    Job willbreaker = new Job(); // M-S-D-A
    willbreaker.name = "will breaker";

    Job avatar = new Job(); // A-M-D-S, D-M-A-S
    avatar.name = "avatar";

    Job shapeshifter = new Job(); // A-D-M-S, D-A-M-S
    shapeshifter.name = "shapeshifter";

    Job stormbringer = new Job(); // A-D-S-M, D-A-S-M
    stormbringer.name = "stormbringer";

    Job darkTemplar = new Job(); // A-S-M-D
    darkTemplar.name = "dark templar";

    Job lich = new Job(); // A-S-D-M
    lich.name = "lich";

    Job deathKnight = new Job(); // D-M-S-A
    deathKnight.name = "death knight";

    Job druid = new Job(); // D-S-M-A
    druid.name = "druid";

    Job dragoon = new Job(); // D-S-A-M
    dragoon.name = "dragoon";

    Job souleater = new Job(); // S-M-D-A
    souleater.name = "soul-eater";

    Job blessedBard = new Job(); // S-A-M-D
    blessedBard.name = "blessed bard";

    Job demonWarrior = new Job(); // S-A-D-M
    demonWarrior.name = "demon warrior";

    Job reaper = new Job(); // S-D-M-A
    reaper.name = "reaper";

    Job chronosKnight = new Job(); // S-D-A-M
    chronosKnight.name = "Chronos knight";

    // hook tier 4 to tier 3

    bladesinger.shadow = jediKnight;

    ninja.divine = doomsayer;

    shaman.shadow = shadowmancer;

    berserker.martial = pyrokineticist;

    psion.divine = mindFlayer;

    ironFist.arcane = willbreaker;

    channeler.shadow = avatar;

    templar.shadow = shapeshifter;

    fatespinner.martial = stormbringer;

    strider.divine = darkTemplar;

    necromancer.martial = lich;

    bountyHunter.arcane = deathKnight;

    ranger.arcane = druid;

    zealot.martial = dragoon;

    blackguard.arcane = souleater;

    bard.divine = blessedBard;

    incubus.martial = demonWarrior;

    pirate.arcane = reaper;

    timeWeaver.martial = chronosKnight;

    // ultimate tier

    Job oldMan = new Job(); // U
    oldMan.name = "Old Man";

    Job blademaster = new Job(); // M-U
    blademaster.name = "Blademaster";

    Job archmage = new Job(); // A-U
    archmage.name = "Archmage";

    Job archbishop = new Job(); // D-U
    archbishop.name = "Archbishop";

    Job warlord = new Job(); // M-D-U
    warlord.name = "Warlord";

    Job grandmaster = new Job(); // M-S-U
    grandmaster.name = "Grandmaster of Flowers";

    Job handOfGod = new Job(); // D-M-U
    handOfGod.name = "Hand of God";

    Job slayer = new Job(); // S-M-U
    slayer.name = "Slayer";

    Job archon = new Job(); // A-D-M-U, D-A-M-U
    archon.name = "Archon";

    Job fanatic = new Job(); // D-S-A
    fanatic.name = "Fanatic";

    Job jediMaster = new Job(); // M-A-D-S-U
    jediMaster.name = "Jedi Master";

    Job doombringer = new Job(); // M-A-S-D-U, S-M-A-D-U
    doombringer.name = "Doombringer";

    Job incarnation = new Job(); // A-M-D-S-U, D-M-A-S-U
    incarnation.name = "Incarnation";

    Job darkArchon = new Job(); // A-S-M-D-U
    darkArchon.name = "Dark Archon";

    Job nemesis = new Job(); // A-S-D-M-U
    nemesis.name = "Nemesis";

    Job grandDruid = new Job(); // D-S-M-A-U
    grandDruid.name = "Grand Druid";

    Job soulDevourer = new Job(); // S-M-D-A-U
    soulDevourer.name = "Soul Devourer";

    Job hornedReaper = new Job(); // S-D-M-A-U
    hornedReaper.name = "Horned Reaper";

    // hook ultimate tier to various classes

    commoner.ultimate = oldMan;

    knight.ultimate = blademaster;
    wizard.ultimate = archmage;
    vicar.ultimate = archbishop;

    barbarian.ultimate = warlord;
    monk.ultimate = grandmaster;

    paladin.ultimate = handOfGod;
    assassin.ultimate = slayer;
    templar.ultimate = archon;
    zealot.ultimate = fanatic;

    jediKnight.ultimate = jediMaster;
    doomsayer.ultimate = doombringer;
    avatar.ultimate = incarnation;
    darkTemplar.ultimate = darkArchon;
    lich.ultimate = nemesis;
    druid.ultimate = grandDruid;
    souleater.ultimate = soulDevourer;
    reaper.ultimate = hornedReaper;

    // ...whew, done

    game.baseJob = commoner;

    // quick, save state to disk!

    System.out.println("Saving game to disk");
    gs.saveState(game, GameServer.GAME_FILE);
    System.out.println("Game saved");
  }

}
