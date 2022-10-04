package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BASH);
    }
    int debuff = 0;                     // оглушение реализовано при помощи уменьшения урона босса
    // до 0, после оглушения урон восстанавливается
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {                   // проверка в игре ли тор
            if (this == heroes[i] && heroes[i].getHealth() > 0) {
                boss.setDamage(boss.getBasicDamage());              // восстановление урона босса

                int chance = RPG_Game.random.nextInt(9) + 1;  // шанс оглушения
                if (chance > 8) {
                    boss.setDamage(debuff);
                    System.out.println("BOSS IS BASHED");
                }
            }
        }
    }
}