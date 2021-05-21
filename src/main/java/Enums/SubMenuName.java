package Enums;

public enum SubMenuName {
    SIMPLEFORM("Simple Form Demo"),
    CHECKBOX("Checkbox Demo"),
    RADIOBTN("Radio Buttons Demo"),
    SECLECTDROPDOWNLIST("Select Dropdown List"),
    INPUTFORM("Input Form Submit"),
    AJAXFORM("Ajax Form Submit"),
    JQUREYSELECTDROPDOWN("JQuery Select dropdown");

    private String content;

    SubMenuName(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

