package Enums;

public enum GroupMenuName {
    INPUTFORMS ("input forms"),
    DATEPICKERS ("Date pickers"),
    TABLE ("Table"),
    PROGRESSBAR("Progress Bars & Sliders"),
    ALERT ("Alerts & Modals"),
    LISTBOX ("List Box"),
    OTHER ("Others");

    private String content;
    GroupMenuName(String content){
        this.content=content;
    }

    public String getContent(){
        return this.content;
    }
}
