package com.Lisa.monsters;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.Lisa.monsters.Color.*;
import static com.Lisa.monsters.Color.ANSI_RESET;

public class Game {
    private ArrayList<GameCharacter> _enemies;
    private GameCharacter _hero;

    private boolean _game_over;

    public void init(String language) {

        //init locale
        if (language.equals("DE")) {
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

        }

        _game_over = false;

        //init units
        _enemies = new ArrayList<>();
        _enemies.add(GameCharacter.createBigTroll("Nifnif"));
        _enemies.add(GameCharacter.createRegularTroll("Nafnaf"));
        _enemies.add(GameCharacter.createSmallTroll("Nufnuf"));
        _enemies.add(GameCharacter.createWerewolf("Bobik"));
        _hero = GameCharacter.createHero("Bob");
    }

    public void input(String user_input) {
        Observer obs = Observer.getInstance();
        //obs.input(Observer.RecordType.INFO,'','',0, _hero.getName()+" journey is beginning" );
        //obs.input(Observer.RecordType.INFO,'','',0, _hero.getName()+" is ambushed by trolls" );
        //obs.input(Observer.RecordType.INFO,'','',0," Battle begins... "  );

        obs.input(Observer.RecordType.INFO, '', '', 0, "Hero's turn");
        obs.input(Observer.RecordType.INFO, '', '', 0, _hero.getName() + ", what is your action?");
        _hero.resetBlock();
        //String input = sc.next();
        if (user_input.indexOf("attack") == 0) {
            //obs.input( Observer.RecordType.INFO,'','',0,"Which one?");
            //showEnemies(_enemies);
            //input = sc.next();
            int index = Integer.parseInt(user_input.substring(6));
            GameCharacter monster = _enemies.get(index);
            _hero.attack(monster);
            if (monster.isDead()) {
                obs.input(Observer.RecordType.INFO, '', '', 0, _hero.getName() + " defeated a " + monster.getName());
                // System.out.println(_hero.getName() + " defeated a " + monster.getName());
                //TODO add hero win gameover
            }
        }

        if (user_input.indexOf("block") == 0) {
            _hero.blockAction();
        }

        //System.out.println("Enemy's turn");
        obs.input(Observer.RecordType.INFO, '', '', 0,"Enemy's turn" );
        for (GameCharacter actual_monster : _enemies) {
            actual_monster.resetBlock();
            if (Math.random() < 0.5) {
                actual_monster.attack(_hero);
                if (_hero.isDead()) {
                   // System.out.println(actual_monster.getName() + " defeated a " + _hero.getName());
                    obs.input(Observer.RecordType.INFO, '', '', 0,actual_monster.getName() + " defeated a " + _hero.getName() );
                    _game_over = true;
                    break;
                }
            } else {
                actual_monster.blockAction();
            }
        }

    }

    public void output() {

    }

}
