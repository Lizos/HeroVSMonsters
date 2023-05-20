package com.Lisa.monsters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.Lisa.monsters.Color.*;
import static com.Lisa.monsters.Color.ANSI_RESET;

public class Game {

    private enum GameState {
        INITIALIZATION,// SET LANGUAGE AND INIT SCENE
        IN_BATTLE,// BATTLE LOOP
        GAME_OVER // GAME OVER WAITING FOR RESET
    }
    private GameState _state = GameState.INITIALIZATION;
    private ArrayList<GameCharacter> _enemies;
    private GameCharacter _hero;


    public String inOut(String user_input) {

        String result = "";

        Log obs = Log.getInstance();
        //obs.input(Log.RecordType.INFO,'','',0, _hero.getName()+" journey is beginning" );
        //obs.input(Log.RecordType.INFO,'','',0, _hero.getName()+" is ambushed by trolls" );
        //obs.input(Log.RecordType.INFO,'','',0," Battle begins... "  );

        //TODO VALIDATION

        //Dispatching according to state

        switch (_state) {

            case INITIALIZATION:
                _performInit(user_input);
                result = toJson();
                break;

            case IN_BATTLE:
                _performInBattle(user_input);
                result = toJson();
                break;

            case GAME_OVER:
                _performGameOver(user_input);
                result = "Game over";
                break;

        }
        return result;
    }

    private void _performGameOver(String userInput) {
        //TODO gameover logic

    }


    private void _performInBattle(String userInput) {
        Log obs = Log.getInstance();
        obs.input(Log.RecordType.INFO, "", "", 0, "Hero's turn");
        obs.input(Log.RecordType.INFO, "", "", 0, _hero.getName() + ", what is your action?");
        _hero.resetBlock();

        //String input = sc.next();
        if (userInput.indexOf("attack") == 0) {
            //obs.input( Log.RecordType.INFO,'','',0,"Which one?");
            //showEnemies(_enemies);
            //input = sc.next();
            int index = Integer.parseInt(userInput.substring(6));
            GameCharacter monster = _enemies.get(index);
            _hero.attack(monster);
            if (monster.isDead()) {
                obs.input(Log.RecordType.INFO, "", "", 0, _hero.getName() + " defeated a " + monster.getName());
                // System.out.println(_hero.getName() + " defeated a " + monster.getName());
                //TODO add hero win gameover
            }
        }

        if (userInput.indexOf("block") == 0) {
            _hero.blockAction();
        }

        //System.out.println("Enemy's turn");
        obs.input(Log.RecordType.INFO, "", "", 0, "Enemy's turn");
        for (GameCharacter actual_monster : _enemies) {
            actual_monster.resetBlock();
            if (Math.random() < 0.5) {
                actual_monster.attack(_hero);
                if (_hero.isDead()) {
                    obs.input(Log.RecordType.INFO, "", "", 0, actual_monster.getName() + " defeated a " + _hero.getName());
                    _state = GameState.GAME_OVER;
                    break;
                }
            } else {
                actual_monster.blockAction();
            }
        }

    }


    private void _performInit(String userInput) {
        //init locale
        if (userInput.equals("DE")) {
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


        //init units
        _enemies = new ArrayList<>();
        _enemies.add(GameCharacter.createBigTroll("Nifnif"));
        _enemies.add(GameCharacter.createRegularTroll("Nafnaf"));
        _enemies.add(GameCharacter.createSmallTroll("Nufnuf"));
        _enemies.add(GameCharacter.createWerewolf("Bobik"));
        _hero = GameCharacter.createHero("Bob");

        _state=GameState.IN_BATTLE;
    }



    public ArrayList<Log.Record> output(int index) {
        return Log.getInstance().output(index);
    }


    public String toJson() {
        //JSON begin
        String result = "{ ";

        //Environment: begin
        result += "\"IsNight\" : " + Environment.getInstance().getNight() + ", ";
        //Environment: end

        //Hero: begin
        result += "\"Hero\" : " + _hero.toJson() + ", ";
        //Hero: end

        //Enemies: begin
        result += "\"Enemies\" : [ ";

        Iterator<GameCharacter> iter = _enemies.iterator();
        while (iter.hasNext()) {
            result += iter.next().toJson();

            if (iter.hasNext()) {
                result += ", ";
            }
        }

        result += " ]";
        //Enemies: end

        result += " }";
        //JSON end

        return result;
    }
}

