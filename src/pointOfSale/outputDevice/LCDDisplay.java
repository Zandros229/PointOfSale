package pointOfSale.outputDevice;

public class LCDDisplay {
    private String text;

    public LCDDisplay() {
        text = "";
    }

    public void display(String textToDisplay) {
        text = textToDisplay;
        System.out.println(textToDisplay);
    }

    public String getText() {
        return text;
    }
}
