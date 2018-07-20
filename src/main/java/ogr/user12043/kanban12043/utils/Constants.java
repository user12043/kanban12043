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
    public static final String logFileName = "logs/kanban12043.log";
    public static final String languageDirectory = "lang";
    public static final String resourceDirectory = "resources";
    public static final String defaultName = "unnamed";
    public static final String[] themes = new String[]{
            "javax.swing.plaf.nimbus.NimbusLookAndFeel",
            "javax.swing.plaf.metal.MetalLookAndFeel",
            "com.bulenkov.darcula.DarculaLaf",
            "com.seaglasslookandfeel.SeaGlassLookAndFeel",
            "com.alee.laf.WebLookAndFeel"
    };
    public static final String[] languages = new String[]{
            "en-US",
            "tr-TR"
    };
    //<editor-fold desc="Argument names" defaultstate="collapsed">
    public static final String args_languageArgumentName = "lang";
    public static final String args_themeArgumentName = "theme";
    public static final String args_fontSizeArgumentName = "fontSize";
    //</editor-fold>

    //<editor-fold desc="General fields of application" defaultstate="collapsed">
    public static final int POMODORO_INTERVAL = 25;
    public static final int SHORT_BREAK_INTERVAL = 5;
    public static final int LONG_BREAK_INTERVAL = 15;
    public static ClassPathXmlApplicationContext context;
    public static Locale locale;
    public static ResourceBundle langResourceBundle;
    public static final String[] priorities = new String[]{
            Utils.getTag("entity.task.priority.low"),
            Utils.getTag("entity.task.priority.normal"),
            Utils.getTag("entity.task.priority.high")
    };
    public static final String[] statuses = new String[]{
            Utils.getTag("entity.task.status.none"),
            Utils.getTag("entity.task.status.cancelled"),
            Utils.getTag("entity.task.status.completed")
    };
    //</editor-fold>
}
