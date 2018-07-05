package ogr.user12043.kanbanBoard.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by ME99735 on 04.07.2018 - 19:19
 * Part of project: kanban-board
 */
public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public static String readFile(String fileName) throws IOException {
        StringBuilder builder;
        try (FileReader reader = new FileReader(fileName)) {
            builder = new StringBuilder();
            while (reader.ready()) {
                builder.append((char) reader.read());
            }
        }
        return builder.toString();
    }

    public static Locale getLocale() {
        if (Constants.locale == null) {
            Constants.locale = Locale.forLanguageTag(Properties.lang);
        }
        return Constants.locale;
    }

    public static ResourceBundle getLangResource() {
        if (Constants.langResourceBundle == null) {
            Constants.langResourceBundle = ResourceBundle.getBundle((Constants.languageDirectory + File.separator + Constants.args_languageArgumentName), getLocale());
        }

        return Constants.langResourceBundle;
    }

    public static String getTag(String key) {
        String tag;
        try {
            tag = getLangResource().getString(key);
        } catch (Exception e) {
            logger.error("Can not get tag from lang resource for key: " + key, e);
            tag = "unnamed";
        }
        return tag;
    }
}
