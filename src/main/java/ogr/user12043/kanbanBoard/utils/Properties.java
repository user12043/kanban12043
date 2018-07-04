package ogr.user12043.kanbanBoard.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ME99735 on 04.07.2018 - 18:55
 * Part of project: kanbanboard
 */
public class Properties {
    public static void getProperties() {
        try {
            JSONObject jsonObject = new JSONObject(Constants.settingsFileName);
            Properties.lang = jsonObject.getString("lang");
        } catch (JSONException e) {
            System.out.println("Configuration file (\"" + Constants.settingsFileName + "\") not found! Using default settings");
        }
    }

    public static String lang = "en";
}
