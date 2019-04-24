package pointOfSale.InputDevice;

public class InvalidBarcodeException extends Exception {
    public InvalidBarcodeException(String message) {
        super(message);
    }
}
