package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Antman extends Hero {
    public Antman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.ANTS_SUPER_ABILITY);
    }

    private int BuffHealth = 50;  // значение на сколько будет увеличено / уменьшено здороввье и урон
    private int BuffDamage = 5;
    private int basicDamage; // перемнные для урона и жизни
    private int basicHealth;
    private int usedAbility = 0; // 0 - не использована способность, 1 - урон, жизни уменьшены


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int chance = RPG_Game.random.nextInt(9);

        if (getUsedAbility() > 0) {
            this.setDamage(getBasicDamage());  // сброс прибавленного / убавленного
            this.setHealth(getBasicHealth());  // урона и жизней
            setUsedAbility(0);
            System.out.println(this.getName() + " restored health and damage");
        }

        if (chance < 2 && getUsedAbility() == 0) {
            setBasicDamage(this.getDamage());  // сохранение жизней и урона
            setBasicHealth(this.getHealth());  // до уменьшения жизней и урона

            this.setDamage(this.getDamage() - getBuffDamage());   // уменьшение урона
            this.setHealth(this.getHealth() - getBuffHealth());   // и жизней
            setUsedAbility(1);
            System.out.println(this.getName() + " decreased damage and health ");
        }

        if (chance > 7) {
            setBasicDamage(this.getDamage());
            setBasicHealth(this.getHealth());

            this.setDamage(this.getDamage() + getBuffDamage());
            this.setHealth(this.getHealth() + getBuffHealth());
            setUsedAbility(2);
            System.out.println(this.getName() + " increased damage and health ");

        }
    }

    public int getBuffHealth() {
        return BuffHealth;
    }

    public int getBuffDamage() {
        return BuffDamage;
    }

    public int getBasicDamage() {
        return basicDamage;
    }

    public void setBasicDamage(int basicDamage) {
        this.basicDamage = basicDamage;
    }

    public int getBasicHealth() {
        return basicHealth;
    }

    public void setBasicHealth(int basicHealth) {
        this.basicHealth = basicHealth;
    }

    public int getUsedAbility() {
        return usedAbility;
    }

    public void setUsedAbility(int usedAbility) {
        this.usedAbility = usedAbility;
    }
}