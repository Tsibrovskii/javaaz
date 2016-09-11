package ru.tsibrovskii.templates;

public abstract class TemplateAction {

    String name;

    public TemplateAction(String name) {
        this.name = name;
    }

    abstract void start();
    abstract void finish();

    public void work() {
        this.start();
        this.finish();
    }

    public static void main(String[] args) {
        new TemplateAction("String") {

            public void start() {

            }
            public void finish() {

            }
        };
    }
}
