package ru.tsibrovskii.examples.socket;

import java.io.InputStream;
import java.util.Properties;

/**
 * Класс настроек.
 */
public class Settings {

    private final Properties prs = new Properties();

    /**
     * Метод загрузки входного потока в экземпляр класса <b>Properties</b>.
     * @param io входной поток.
     */
    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Класс, возвращающий свойство.
     * @param key ключ.
     * @return свойство.
     */
    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}
