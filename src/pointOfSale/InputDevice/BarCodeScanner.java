package pointOfSale.InputDevice;

public class BarCodeScanner {
    private String barCode;

    public int scan(String scannedBarCode){
        barCode=scannedBarCode;
        return barCodeToId();
    }

    private int barCodeToId(){
        return Integer.parseInt(barCode);
    }
}
