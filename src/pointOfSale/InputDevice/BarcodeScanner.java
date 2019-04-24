package pointOfSale.InputDevice;

public class BarcodeScanner {
    private String barcode;

    public int scan(String scannedBarCode) throws InvalidBarcodeException {
        if (!(scannedBarCode.isEmpty())) {
            barcode = scannedBarCode;
            return barCodeToId();
        } else
            throw new InvalidBarcodeException("Invalid bar-code");
    }

    private int barCodeToId() {
        return Integer.parseInt(barcode);
    }
}
