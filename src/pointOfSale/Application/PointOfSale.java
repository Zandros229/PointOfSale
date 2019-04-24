package pointOfSale.Application;

import pointOfSale.InputDevice.BarcodeScanner;
import pointOfSale.InputDevice.InvalidBarcodeException;
import pointOfSale.domain.InvalidIdException;
import pointOfSale.domain.Product;
import pointOfSale.domain.ProductDataBase;
import pointOfSale.domain.Receipt;
import pointOfSale.outputDevice.LCDDisplay;
import pointOfSale.outputDevice.Printer;

import java.util.LinkedList;

public class PointOfSale {
    private BarcodeScanner barcodeScanner;
    private LCDDisplay lcdDisplay;
    private Printer printer;
    private ProductDataBase productDataBase;
    private Receipt receipt;

    public PointOfSale(BarcodeScanner barcodeScanner, LCDDisplay lcdDisplay, Printer printer, ProductDataBase productDataBase) {
        this.barcodeScanner = barcodeScanner;
        this.lcdDisplay = lcdDisplay;
        this.printer = printer;
        this.productDataBase = productDataBase;
        receipt = new Receipt(new LinkedList<Product>());
    }

    public void scan(String code) {
        try {
            if (!(code.equals("exit"))) {
                checkProduct(barcodeScanner.scan(code));
            } else
                printreceipt();
        } catch (InvalidBarcodeException e) {
            lcdDisplay.display(e.getMessage());
        }
    }

    public void checkProduct(int code) {
        try {
            if (productDataBase.contains(code)) {
                receipt.add(productDataBase.getProduct(code));
                lcdDisplay.display(productDataBase.getProduct(code).toString());
            } else
                lcdDisplay.display("Product not found");
        } catch (InvalidIdException e) {
            lcdDisplay.display(e.getMessage());//Should never happened
        }
    }

    private void printreceipt() {
        lcdDisplay.display(receipt.getTotalSum().getAmount() + " " + receipt.getTotalSum().getCourency());
        printer.print(receipt.toString());
    }

}
