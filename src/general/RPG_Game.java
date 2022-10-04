package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(2500, 50, "Boss molokososs");
        Warrior warrior = new Warrior(270, 10, "Aragorn");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Magic magic = new Magic(260, 15, "Hendelf");
        Berserk berserk = new Berserk(280, 20, "Drax");
        Medic assistant = new Medic(180, 0, 5, "Strange");
        Thor thor = new Thor(200, 10, "Odion");
        Golem golem = new Golem(1000, 5, "Tiny");
        Witcher withcer = new Witcher(350, 0, "Baba-Yaga");
        Avrora avrora = new Avrora(220, 10, "Mirana");
        Hacker hacker = new Hacker(240, 10, "Alexey");
        TrickyBastard trickyBastard = new TrickyBastard(250, 15, "Tricky");
        Antman antman = new Antman(200, 15, "Ant");
        Deku deku = new Deku(250,10, "Deku");

        Hero[] heroes = {warrior, doc, magic, berserk, assistant, thor, golem, withcer, avrora, hacker, trickyBastard,
                antman, deku};


        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].hit(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " +
                (roundNumber == 0 ? "BEFORE FIGHT " : roundNumber)
                + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static int getRoundNumber() {
        return roundNumber;
    }
}