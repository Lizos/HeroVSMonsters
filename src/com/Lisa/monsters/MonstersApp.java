package com.Lisa.monsters;

import java.util.Scanner;
import java.util.ArrayList;

interface GameUnit {
    public void takeHit(int damage);
    public void attack(GameUnit target);
    public void blockAction();
    public boolean isDead();
    public void resetBlock();
}

public class MonstersApp {

    private static Scanner sc = new Scanner(System.in);

    private static void showEnemies(ArrayList<GameUnit> enemies) {
        for (GameUnit actual_monster : enemies) {
            System.out.println(((GameCharacter)actual_monster).getName() + " hp:" + ((GameCharacter)actual_monster).getHp() + (actual_monster.isDead() ? "Defeated" : "Active"));
        }
    }

    public static void main(String[] args) {

        ArrayList<GameUnit> enemies = new ArrayList<>();
        enemies.add(UnitFactory.createTroll("nifnif"));
        enemies.add(UnitFactory.createTroll("nafnaf"));
        enemies.add(UnitFactory.createTroll("nufnuf"));
        GameUnit hero = UnitFactory.createHero("Bob");

        System.out.println(((GameCharacter)hero).getName() + " Journey is beginning");
        System.out.println(((GameCharacter)hero).getName() + " is ambushed by trolls");

        System.out.println(" Battle begins... ");
        while (true) {
            System.out.println("Hero's turn");
            System.out.println( ((GameCharacter)hero).getName() + ", what is your action?");
            hero.resetBlock();
            String input = sc.next();
            if (input.equals("/hit")) {
                System.out.println("Which one?");
                showEnemies(enemies);
                input = sc.next();
                int index = Integer.parseInt(input);
                GameUnit monster = enemies.get(index);
                hero.attack(monster);
                if (monster.isDead() ) {
                    System.out.println(((GameCharacter) hero).name + " defeated a " + ((GameCharacter)monster).getName());
                    break;
                }
            }

            if (input.equals("/block")) {
                hero.blockAction();
            }

            System.out.println("Enemy's turn");
            for (GameUnit actual_monster : enemies) {
                actual_monster.resetBlock();
                if (Math.random() < 0.5) {
                    actual_monster.attack(hero);
                    if (hero.isDead()) {
                        System.out.println(((GameCharacter) actual_monster).getName() + " defeated a " + ((GameCharacter)hero).getName());
                        break;
                    }
                } else {
                    actual_monster.blockAction();
                }
            }
            System.out.println("=========================");
            System.out.println("Total");
            System.out.println("Hero: " + ((GameCharacter) hero).hp);
            System.out.println("Enemies: ");
            showEnemies(enemies);
            System.out.println("=========================");
        }


        System.out.println("End");
    }

}