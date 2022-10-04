package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Deku extends Hero {
    public Deku(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.DEKU_SUPER_ABILITY);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean chance = RPG_Game.random.nextBoolean();
        int buff = RPG_Game.random.nextInt(3);

        if (chance == true && this.getHealth() > 0) {
            if (buff == 0) {
                boss.setHealth(boss.getHealth() - this.getDamage() / 5);    // усиление силы удара
                this.setHealth(this.getHealth() - this.getDamage() / 10);   // снижение урона
                System.out.println(this.getName() + " deal extra damage increased by 20%! ");
            } else if (buff == 1) {
                boss.setHealth(boss.getHealth() - this.getDamage() / 2);
                this.setHealth(this.getHealth() - this.getDamage() / 5);
                System.out.println(this.getName() + " deal extra damage increased by 50%! ");
            } else if (buff == 2) {
                boss.setHealth(boss.getHealth() - this.getDamage() * 2);
                this.setHealth(this.getHealth() - this.getDamage() / 2);
                System.out.println(this.getName() + " deal extra damage increased by 100%! ");
            }
        }
    }
}