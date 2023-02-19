package com.Lisa.monsters;
import java.util.ResourceBundle;
public class Resources {
private static ResourceBundle _languageBundle;

public static ResourceBundle getLanguageBundle() {
    return _languageBundle;
}

    public static void setLanguageBundle(ResourceBundle languageBundle) {
         _languageBundle = languageBundle;
    }

}
