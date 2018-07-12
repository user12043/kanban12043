package ogr.user12043.kanban12043.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user12043 on 04.07.2018 - 18:46
 * Part of project: kanban12043
 */
public class Constants {
    public static final String settingsFileName = "config.json";
    public static final String languageDirectory = "lang";
    public static final String defaultName = "unnamed";
    //<editor-fold desc="Argument names">
    public static final String args_languageArgumentName = "lang";
    public static ClassPathXmlApplicationContext context;
    //</editor-fold>

    public static Locale locale;

    public static ResourceBundle langResourceBundle;
}
