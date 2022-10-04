package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero{
    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.HACK);
    }
    private int passRound = 0;
    private int takeHealth = 41;
    private int pickIndex;

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        passRound ++;       // забирает у босса здоровье только на четных раундах
        if (getPassRound() % 2 != 0){
            for (int i = 0; i < heroes.length; i++) {       // цикл в игре ли герой
                pickIndex = RPG_Game.random.nextInt(heroes.length);
                if (heroes[pickIndex].getHealth() > 0){
                    boss.setHealth(boss.getHealth() - getTakeHealth());     // хакер забирает здорове и передает рандом-
                    heroes[pickIndex].setHealth(heroes[pickIndex].getHealth() + getTakeHealth());  //  ному герою
                    System.out.println("The hacker took health from the Boss and transferred the " +
                            heroes[pickIndex].getName());
                    break;
                }
            }


        }

    }

    public int getPassRound() {
        return passRound;
    }

    public int getTakeHealth() {
        return takeHealth;
    }
}