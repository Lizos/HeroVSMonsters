package com.Lisa.monsters;

import java.util.Scanner;
import java.util.ArrayList;

/*interface GameUnit {
    public void takeHit(int damage);
    public void attack(GameUnit target);
    public void blockAction();
    public boolean isDead();
    public void resetBlock();
}*/

public class MonstersApp {


    private static Scanner sc = new Scanner(System.in);


    private static void showEnemies(ArrayList<GameCharacter> enemies) {
        for (GameCharacter actual_monster : enemies) {
            System.out.println(actual_monster.getName() + " hp:" + actual_monster.hp + (actual_monster.isDead() ? "Defeated" : "Active"));
        }
    }

    public static void main(String[] args) {

        Game core = new Game();
        core.init("EN");

        System.out.println(core.toJson());


        //Init locale
        //System.out.println("Choose language: EN or DE");
        //String inlang = sc.next();
        /*if (inlang.equals("DE")) {
            Resources.setLanguageBundle(ResourceBundle.getBundle("i18n", Locale.GERMAN));
        } else {
            Resources.setLanguageBundle(ResourceBundle.getBundle("i18n"));
        }

        //Init day/night
        if (Math.random() < 0.6) {
            Environment.getInstance().setNight(true);
            System.out.println(ANSI_BLACK + " Night" + ANSI_RESET);
        } else {
            Environment.getInstance().setNight(false);
            System.out.println(ANSI_YELLOW + " Day" + ANSI_RESET);

        }*/

        //init units
        /*ArrayList<GameCharacter> enemies = new ArrayList<>();
        enemies.add(GameCharacter.createBigTroll("Nifnif"));
        enemies.add(GameCharacter.createRegularTroll("Nafnaf"));
        enemies.add(GameCharacter.createSmallTroll("Nufnuf"));
        enemies.add(GameCharacter.createWerewolf("Bobik"));
        GameCharacter hero = GameCharacter.createHero("Bob");*/

        //start
        /*System.out.println(hero.getName() + " Journey is beginning");
        System.out.println(hero.getName() + " is ambushed by trolls");

        System.out.println(" Battle begins... ");*/

        /*
        Boolean game_over = false;
        while (!game_over) {
            System.out.println("Hero's turn");
            System.out.println(hero.name + ", what is your action?");
            hero.resetBlock();
            String input = sc.next();
            if (input.equals("/hit")) {
                System.out.println("Which one?");
                showEnemies(enemies);
                input = sc.next();
                int index = Integer.parseInt(input);
                GameCharacter monster = enemies.get(index);
                hero.attack(monster);
                if (monster.isDead()) {
                    System.out.println(hero.getName() + " defeated a " + monster.getName());
                    break;
                }
            }

            if (input.equals("/block")) {
                hero.blockAction();
            }

            System.out.println("Enemy's turn");
            for (GameCharacter actual_monster : enemies) {
                actual_monster.resetBlock();
                if (Math.random() < 0.5) {
                    actual_monster.attack(hero);
                    if (hero.isDead()) {
                        System.out.println(actual_monster.getName() + " defeated a " + hero.getName());
                        game_over = true;
                        break;
                    }
                } else {
                    actual_monster.blockAction();
                }
            }
            System.out.println("=========================");
            System.out.println("Total");
            System.out.println("Hero: " + hero.getHp());
            System.out.println("Enemies: ");
            showEnemies(enemies);
            System.out.println("=========================");
        }

        System.out.println("End");
        Log.getInstance().showRecords();

        System.out.println("End"); */
    }

}