package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;


public class Witcher extends Hero{
    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.REVIVAL);
    }
    private boolean usedAbility = false;


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int chance = RPG_Game.random.nextInt(9) + 1;
        if (getUsedAbility() == false) {            // проверка воскресил ли withcer кого-то
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() == 0 && chance < 7) {          // воскрешение
                    heroes[i].setHealth(200);
                    System.out.println(heroes[i].getName() + " is revivaled");
                    this.setHealth(0);
                    setUsedAbility(true);
                    break;
                }
            }
        }
    }

    public boolean getUsedAbility() {
        return usedAbility;
    }

    public void setUsedAbility(boolean usedAbility) {
        this.usedAbility = usedAbility;
    }
}