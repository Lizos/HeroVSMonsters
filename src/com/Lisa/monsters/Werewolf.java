package com.Lisa.monsters;

public class Werewolf extends GameCharacter {
    //private boolean _isWolf = false;

    public Werewolf(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.block = false;
    }

    @Override
    public void attack(GameCharacter target) {
        boolean target_blocked = target.isBlocked();

        //Damage calculation

        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.7) {
                System.out.println(target.getName() + " blocked the attack");
                damage=damage/2;
            }
        }

       if (Environment.getInstance().getNight()) {
           damage *= 2;
       }


        //Hit
        target.takeHit(damage);

        System.out.println(name + " damaged " + target.getName() + ". Damage:" + damage);
    }

    @Override
    public void blockAction() {
        hp++;
        block = true;
        System.out.println(name + " is trying to block next attack. Get +1 hp  ");
    }
}
