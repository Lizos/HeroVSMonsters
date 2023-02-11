package com.Lisa.monsters;

public class Troll extends GameCharacter {
    public Troll(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.block = false;
    }

    @Override
    public void takeHit(int damage) {
        hp -= damage;
    }

    @Override
    public void attack(GameCharacter target) {
        //Cast GameUnit to GameCharacter to take name
      //  String target_name = target.getName();
        boolean target_blocked = target.isBlocked();

        //Damage calculation
        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.8) {
                System.out.println(target.name + " blocked the attack");
                return;
            } else {
                damage *= 2;
            }
        }
        //Hit
        target.takeHit(damage);

        System.out.println(name + " damaged " + target.name + ". Damage:" + damage);
    }

    @Override
    public void blockAction() {
        hp++;
        block = true;
        System.out.println(name + " is trying to block next attack. Get +1 hp  ");
    }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }

    @Override
    public void resetBlock() {
        block = false;
    }


}