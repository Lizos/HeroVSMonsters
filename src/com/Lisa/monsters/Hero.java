package com.Lisa.monsters;


public class Hero extends GameCharacter {

    public Hero(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.block = false;
    }

    @Override
    public void attack(GameCharacter target) {
        Observer.getInstance().input(Observer.RecordType.SPEECH,name,"", 0,name + ": " + Resources.getLanguageBundle().getString("SpeechHeroAttack"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechHeroAttack"));
        boolean target_blocked = target.isBlocked();

        //Damage calculation

        int damage = attackPower;
        if (target_blocked) {
            if (Math.random() < 0.7) {
                Observer.getInstance().input(Observer.RecordType.INFO, target.getName(),"", 0," blocked the attack");
                //System.out.println(target.getName() + " blocked the attack");
                damage = damage / 2;
            }
        }

        if (Environment.getInstance().getNight()) {
            damage *= 2;
        }


        //Hit
        target.takeHit(damage);

        Observer.getInstance().input(Observer.RecordType.ATTACK, name, target.getName(), damage, "");
        //System.out.println(name + " damaged " + target.getName() + ". Damage:" + damage);
    }

    @Override
    public void blockAction() {
        Observer.getInstance().input(Observer.RecordType.BLOCK,name,"", 0,Resources.getLanguageBundle().getString("SpeechHeroBlockaction"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechHeroBlockaction"));
        hp++;
        block = true;
        Observer.getInstance().input(Observer.RecordType.INFO,name,"", 0," is trying to block next attack. Get +1 hp  ");
        //System.out.println(name + " is trying to block next attack. Get +1 hp  ");
    }

    @Override
    public boolean isDead() {
        return hp <= 0;
    }

    @Override
    public void resetBlock() {
        block = false;
    }

    @Override
    public void takeHit(int damage) {
        Observer.getInstance().input(Observer.RecordType.SPEECH,name,"", 0,Resources.getLanguageBundle().getString("SpeechHeroTakeHit"));
        //System.out.println(name + ": " + Resources.getLanguageBundle().getString("SpeechHeroTakeHit"));
        hp -= damage;
    }

}
