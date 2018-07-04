package ogr.user12043.kanbanBoard.utils;

import java.io.File;

/**
 * Created by ME99735 on 04.07.2018 - 19:19
 * Part of project: kanbanboard
 */
public class Utils {
    public static boolean isLangFileExists(String lang) {
        File file = new File(Constants.languageDirectory);
        if (!file.exists() || !file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String fileName : list) {
                    if (fileName.equals(Constants.languageFileTemplate.replace("%lng%", fileName))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
