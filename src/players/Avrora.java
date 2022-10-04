package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Avrora extends Hero {
    public Avrora(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.INVISIBILITY);
    }

    private int usedAbility = 0;    // 0 - не использован инвиз, 1 - инвиз использован, действует два раунда
    private int startUseInvisibility;       // переменная для фиксации старта использования инвиза
    private int invisibility;


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        //else if (RPG_Game.getRoundNumber() == startUseInvisibility + 1) {
        //
        //        }

        if (getUsedAbility() == 0) {
            int chance = RPG_Game.random.nextInt(9) + 1;   // способность невидемости реализована
            if (chance < 7) {                                    // при помощи сохранения здоровья до использования
                setInvisibility(this.getHealth());              // инвиза, и возращения того здоровья по окончанию инвиза
                setUsedAbility(1);
                setStartUseInvisibility(RPG_Game.getRoundNumber());
                System.out.println("Invisibility is start");
            }
        }

        if (RPG_Game.getRoundNumber() == startUseInvisibility + 2 && getUsedAbility() == 1) {   // выключение инвиза
            this.setHealth(getInvisibility());                                       // после 2 раундов использования
            setStartUseInvisibility(2);
            System.out.println("Invisibility is over");
        }
    }

    public int getUsedAbility() {
        return usedAbility;
    }

    public void setUsedAbility(int usedAbility) {
        this.usedAbility = usedAbility;
    }

    public void setStartUseInvisibility(int startUseInvisibility) {
        this.startUseInvisibility = startUseInvisibility;
    }

    public int getInvisibility() {
        return invisibility;
    }

    public void setInvisibility(int invisibility) {
        this.invisibility = invisibility;
    }
}