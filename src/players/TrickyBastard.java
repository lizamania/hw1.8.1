
package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class TrickyBastard extends Hero{
    public TrickyBastard(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.OSCAR);
    }
    private int pickRound = RPG_Game.random.nextInt(9) + 2;
    int[] save = new int[2]; // список для сохранения значений жизней и урона
    private boolean usedAbility = false;

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber() == pickRound && getUsedAbility() == false){
            save[0] = this.getHealth();         // сохранение прежнего урона и здоровья
            save[1] = this.getDamage();         // до использования способности
            //  heroes[this.setHealth(0);              трики восстанавливает себе здоровье когда оживает
            this.setDamage(0);                  // если поставить здоровье на 0, то witcher иногда возраждает его
            System.out.println(this.getName() + " is dead, so sad");    // из-за этого здоровье снижается от входящего
            setUsedAbility(true);
        }                                                               // босса урона, но потом восстанавливается
        if (RPG_Game.getRoundNumber() == pickRound + 1){
            this.setHealth(save[0]);
            this.setDamage(save[1]);
            System.out.println(this.getName() + " is not dead!!!");
        }
    }

    public boolean getUsedAbility() {
        return usedAbility;
    }

    public void setUsedAbility(boolean usedAbility) {
        this.usedAbility = usedAbility;
    }
}
