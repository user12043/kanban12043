package ogr.user12043.kanbanBoard.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ME99735 on 04.07.2018 - 18:55
 * Part of project: kanbanboard
 */
public class Properties {
    private static final Logger logger = LogManager.getLogger(Properties.class);

    // Read properties from file
    public static void initializeProperties() {
        try {
            JSONObject jsonObject = new JSONObject(Constants.settingsFileName);
            Properties.lang = jsonObject.getString("lang");
        } catch (JSONException e) {
            logger.warn("Failed to read configuration file (\"" + Constants.settingsFileName + "\")! Using default settings");
        }
    }

    public static String lang = "en";
}
