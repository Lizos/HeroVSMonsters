package com.Lisa.monsters;

public class Environment {
    private static Environment instance;
    private boolean _night=false;

    private Environment() {

    }


    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    public void setNight(boolean night) {
        _night = night;
    }

    public boolean getNight() {
        return _night;
    }

}
