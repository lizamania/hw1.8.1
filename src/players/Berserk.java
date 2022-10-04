package kg.geektech.game.players;

public class Berserk extends Hero {
    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0){
            boss.setHealth(boss.getHealth() - boss.getDamage() / 10);    // возвращение урона
            System.out.println(this.getName() + " returned " + (boss.getDamage() / 10) + " damage");
        }
    }
}
