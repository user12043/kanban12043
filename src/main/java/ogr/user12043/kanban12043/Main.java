package ogr.user12043.kanban12043;

import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Properties;
import ogr.user12043.kanban12043.utils.Utils;
import ogr.user12043.kanban12043.view.MainPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by user12043 on 04.07.2018 - 16:50
 * Part of project: kanban12043
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static MainPane mainPane;

    public static void main(String args[]) {
        try {
            // Read properties
            Properties.initializeProperties();

            // Process program arguments
            processArguments(args);

            // Initialize context
            Utils.buildContext();

            // Create GUI
            mainPane = new MainPane();

            // Set theme
            Utils.setTheme(Properties.theme);

            // Close context on window close
            mainPane.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Constants.context.close();
                    super.windowClosed(e);
                }
            });

            mainPane.setVisible(true);
        } catch (Exception e) {
            logger.error("Unexpected error: ", e);
        }
    }

    private static void processArguments(String args[]) {
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
    }
}
