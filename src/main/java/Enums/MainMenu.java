package Enums;

public enum MainMenu {
    CHEATSHEETS("cheatsheets"),
    TESTERS("testers"),
    CONTACT("contact"),
    HOME("https://www.globalsqa.com/");

    private String content;
    MainMenu(String content){
        this.content=content;

    }

    public String value(){
        return this.content;
    }

}

