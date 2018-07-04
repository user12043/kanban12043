package ogr.user12043.kanbanBoard;

import ogr.user12043.kanbanBoard.utils.Constants;
import ogr.user12043.kanbanBoard.utils.Properties;
import ogr.user12043.kanbanBoard.utils.Utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by ME99735 on 04.07.2018 - 16:50
 * Part of project: kanbanboard
 */
public class Main {
    private static Locale locale;
    private static ResourceBundle langResourceBundle;

    private static void setLocale() {
        if (Utils.isLangFileExists(Properties.lang)) {
            locale = new Locale(Properties.lang);
        } else {
            locale = new Locale("en");
        }

        //TODO create the langResourceBundle
    }

    public static void main(String args[]) {
        // Get properties from file
        Properties.getProperties();

        //Process program arguments
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                if (arg.equals("-" + Constants.args_languageArgumentName.equals(arg))) {
                    i++;
                    Properties.lang = args[i];
                } else {
                    System.err.println("Invalid argument: " + arg);
                    System.exit(1);
                }
            }
        }

        // Set locale
        setLocale();

        // Display GUI
        new MainPane();
    }
}
