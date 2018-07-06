package ogr.user12043.kanban12043;

import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Properties;
import ogr.user12043.kanban12043.view.MainPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by user12043 on 04.07.2018 - 16:50
 * Part of project: kanban-board
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String args[]) {
        try {
            // Get properties from file
            Properties.initializeProperties();

            //Process program arguments
            if (args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    String arg = args[i];
                    if (arg.equals(("-" + Constants.args_languageArgumentName))) {
                        i++;
                        Properties.lang = args[i];
                    } else {
                        logger.error("Invalid argument: " + arg);
                        System.exit(1);
                    }
                }
            }

            // Display GUI
            MainPane mainPane = new MainPane();
            // TODO: init content
            mainPane.setVisible(true);
        } catch (Exception e) {
            logger.error("Unexpected error: ", e);
        }
    }
}
