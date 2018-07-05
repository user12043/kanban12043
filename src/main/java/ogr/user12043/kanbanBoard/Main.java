package ogr.user12043.kanbanBoard;

import ogr.user12043.kanbanBoard.utils.Constants;
import ogr.user12043.kanbanBoard.utils.Properties;

/**
 * Created by user12043 on 04.07.2018 - 16:50
 * Part of project: kanbanboard
 */
public class Main {
    public static void main(String args[]) {
        // Get properties from file
        Properties.initializeProperties();

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

        // Display GUI
//        new MainPane().setVisible(true);
    }
}
