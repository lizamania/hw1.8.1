package kg.geektech.game.players;

public class Golem extends Hero {
    private int blockedDamage;
    public Golem(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.GOLEM_BLOCK);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {           // проверка на в игре ли голем и союзники
            if (this == heroes[i] && heroes[i].getHealth() > 0) {

                for (int j = 0; j < heroes.length; j++) {   // цикл для блока урона, восстановления здоровья(за счет блока)
                    if (SuperAbility.GOLEM_BLOCK == heroes[j].getAbility()) {       // и для исключения голема
                        continue;

                    } else {
                        if (heroes[j].getHealth() > 0) {
                            setBlockedDamage(boss.getDamage() / 5);                       // подсчет блокируемого урона
                            heroes[j].setHealth(heroes[j].getHealth() + getBlockedDamage()); // восстановление здоровья
                        }
                        this.setHealth(this.getHealth() - getBlockedDamage());
                    }
                }
            }
        }
    }

    public int getBlockedDamage() {
        return blockedDamage;
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}