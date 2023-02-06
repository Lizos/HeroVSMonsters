package com.Lisa.monsters;

public class Troll extends GameCharacter implements GameUnit {
    public Troll(String name, int hp, int attackPower) {
        this.block = false;
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
    public void attack(GameUnit target) {
        //Cast GameUnit to GameCharacter to take name
        String target_name = ((GameCharacter) target).getName();
        boolean target_blocked = ((GameCharacter) target).isBlocked();

        //Damage calculation
        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.8) {
                System.out.println(target_name + " blocked the attack");
                return;
            } else {
                damage *= 2;
            }
        }
        //Hit
        target.takeHit(damage);

        System.out.println(name + " damaged " + target_name + ". Damage:" + damage);
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
