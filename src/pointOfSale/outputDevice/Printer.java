package pointOfSale.outputDevice;

public class Printer {
    private String text;

    public Printer() {
        text="";
    }

    public void  print(String textToPrint){
        text=textToPrint;
    }
}
