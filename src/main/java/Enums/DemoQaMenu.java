package Enums;

public enum DemoQaMenu {

    ELEMENTS("elements"),
    FORMS("forms"),
    ARLERTS("alerts, frame & windows"),
    WIDGETS("widgets"),
    BOOKSTOREAPPLICATION("book store application"),
    INTERACTIONS("interactions");

    private String content;

    DemoQaMenu(String content) {
        this.content = content;
    }

    public String value() {
        return this.content;
    }
}
