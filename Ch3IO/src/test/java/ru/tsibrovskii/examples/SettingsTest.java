package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;

public class SettingsTest {

    @Test
    public void whenLoadThenGetFile() throws Exception {
        Settings settings = new Settings();
        File file = new File("C:\\projects\\javaaz\\app.properties");
        try (FileInputStream io = new FileInputStream(file)){
            settings.load(io);
        }
        String value = settings.getValue("home.path.local");
        Assert.assertThat(value, is("c:\\projects\\javaaz"));
    }

    @Test
    public void whenIndeptPath() throws Exception {
        Settings settings = new Settings();
        File file = new File("./src/main/resources/app.properties");
        try (FileInputStream io = new FileInputStream(file)){
            settings.load(io);
        }
        String value = settings.getValue("home.path.local");
        Assert.assertThat(value, is("c:\\projects\\javaaz"));
    }

    @Test
    public void whenClassLoader() throws Exception {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")){
            settings.load(io);
        }
        String value = settings.getValue("home.path.local");
        Assert.assertThat(value, is("c:\\projects\\javaaz"));
    }

    @Test
    public void whenClassLoader2() throws Exception {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("ru/tsibrovskii/app.properties")){
            settings.load(io);
        }
        String value = settings.getValue("home.path");
        Assert.assertThat(value, is("c:\\tmp\\"));
    }

}