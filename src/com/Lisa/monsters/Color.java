package com.Lisa.monsters;

public class Color {
    public static final String ANSI_RESET;
    public static final String ANSI_BLACK;
    public static final String ANSI_RED;
    public static final String ANSI_GREEN;
    public static final String ANSI_YELLOW;
    public static final String ANSI_BLUE;
    public static final String ANSI_PURPLE;
    public static final String ANSI_CYAN;
    public static final String ANSI_WHITE;

    static {
        ANSI_RESET = "[0m";
        ANSI_BLACK = "[30m";
        ANSI_RED = "[31m";
        ANSI_GREEN = "[32m";
        ANSI_YELLOW = "[33m";
        ANSI_BLUE = "[34m";
        ANSI_PURPLE = "[35m";
        ANSI_CYAN = "[36m";
        ANSI_WHITE = "[37m";
    }

}
