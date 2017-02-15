package ru.tsibrovskii.examples.socket;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для работы с каталогами.
 */
public class Catalogue {

    private final String LN = System.getProperty("line.separator");
    private String parentCatalogue;

    /**
     * Метод, возвращающий список корневого каталога.
     * @return список корневого каталога.
     */
    public String returnMainCatalogue() {
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        String str = null;
        Path ph = Paths.get(settings.getValue("home.path"));
        parentCatalogue = ph.toString();
        int length = parentCatalogue.length();
        File file = new File(parentCatalogue);
        for (File sub : file.listFiles()) {
            String subStr = sub.toString().substring(length + 1);
            if (str == null) {
                str = subStr;
            } else {
                str = String.format("%s%s%s", str, LN, subStr);
            }
        }
        return str;
    }

    /**
     * Метод, возвращающий список папок и файлов каталога.
     * @param catalogue каталог.
     * @return список каталога.
     */
    public String returnCatalogue(String catalogue) {
        this.parentCatalogue = String.format("%s\\%s", this.parentCatalogue, catalogue);
        int length = parentCatalogue.length();
        File file = new File(parentCatalogue);
        String str = null;
        for (File sub : file.listFiles()) {
            String subStr = sub.toString().substring(length + 1);
            if (str == null) {
                str = subStr;
            } else {
                str = String.format("%s%s%s", str, LN, subStr);
            }
        }
        return str;
    }
}
