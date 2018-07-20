package ogr.user12043.kanban12043;

import ogr.user12043.kanban12043.utils.Constants;
import ogr.user12043.kanban12043.utils.Properties;
import ogr.user12043.kanban12043.utils.Utils;
import ogr.user12043.kanban12043.view.MainPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
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
            logger.info("Working dir: " + System.getProperty("user.dir"));

            // Read properties
            Properties.initializeProperties();

            // Process program arguments
            processArguments(args);

            // Initialize context
            Utils.buildContext();

            // Set font size
            java.util.Enumeration keys = UIManager.getDefaults().keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if (value instanceof javax.swing.plaf.FontUIResource) {
                    FontUIResource defaultFontUIResource = (FontUIResource) value;
                    FontUIResource newFontUIResource = new FontUIResource(defaultFontUIResource.getName(), defaultFontUIResource.getStyle(), Properties.fontSize);
                    UIManager.put(key, newFontUIResource);
                }
            }

            // Set theme
            Utils.setTheme(Properties.theme);

            // Create GUI
            mainPane = new MainPane();

            // Close context on window close
            mainPane.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Constants.context.close();
                    Properties.generatePropertiesFileIfDoesNotExists();
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
                } else if (arg.equals(("-" + Constants.args_themeArgumentName))) {
                    i++;
                    Properties.theme = Integer.parseInt(args[i]);
                } else {
                    logger.error("Invalid argument: " + arg);
                    System.exit(1);
                }
            }
        }
    }
}
