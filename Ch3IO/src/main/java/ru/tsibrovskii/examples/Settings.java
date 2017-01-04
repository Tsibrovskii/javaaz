package ru.tsibrovskii.examples;

import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private final Properties prs = new Properties();

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}
