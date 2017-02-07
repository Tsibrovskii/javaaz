package ru.tsibrovskii.examples.socket;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для работы с каталогами.
 */
public class Catalogue {

    private final String LN = System.getProperty("line.separator");

    /**
     * Метод, возвращающий список корневого каталога.
     * @return список корневого каталога.
     */
    public String returnMainCatalogue() {
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        String str = null;
        Path ph = Paths.get(settings.getValue("home.path"));
        File file = new File(ph.toString());
        for (File sub : file.listFiles()) {
            if (str == null) {
                str = sub.toString();
            } else {
                str = String.format("%s%s%s", str, LN, sub);
            }
        }
        return str;
    }
}
