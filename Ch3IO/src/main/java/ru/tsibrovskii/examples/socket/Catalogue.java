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
    private String catalogue;

    /**
     * Конструктор класса по умолчанию.
     */
    public Catalogue() {
        initCatalogue();
    }

    /**
     * Метод инициализации пути корневого каталога.
     */
    public void initCatalogue() {
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        Path ph = Paths.get(settings.getValue("home.path"));
        this.parentCatalogue = ph.toString();
        this.catalogue = this.parentCatalogue;
    }

    /**
     * Метод, возвращающий список корневого каталога.
     * @return список корневого каталога.
     */
    public String returnMainCatalogue() {
        this.catalogue = this.parentCatalogue;
        return listOfCatalogue();
    }

    /**
     * Метод, возвращающий список папок и файлов каталога.
     * @param catalogue каталог.
     * @return список каталога.
     */
    public String returnCatalogue(String catalogue) {
        this.catalogue = String.format("%s\\%s", this.catalogue, catalogue);
        return listOfCatalogue();
    }

    /**
     * Метод, возвращающий список родительского каталога.
     * @return список родительского каталога.
     */
    public String returnParentCatalogue() {
        if (!this.catalogue.equals(this.parentCatalogue)) {
            this.catalogue = this.catalogue.substring(0, this.catalogue.lastIndexOf("\\"));
        }
        return listOfCatalogue();
    }

    /**
     * Метод, возвращающий список каталога.
     * @return список каталога.
     */
    public String listOfCatalogue() {
        int length = this.catalogue.length();
        File file = new File(this.catalogue);
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

    /**
     * Метод, возвращающий текущий каталог.
     * @return текущий каталог.
     */
    public String getCurrentCatalogue() {
        return this.catalogue;
    }
}