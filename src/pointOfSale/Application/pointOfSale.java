package pointOfSale.Application;

import pointOfSale.InputDevice.BarcodeScanner;
import pointOfSale.InputDevice.InvalidBarcodeException;
import pointOfSale.domain.InvalidIdException;
import pointOfSale.domain.Product;
import pointOfSale.domain.ProductDataBase;
import pointOfSale.domain.Receipt;
import pointOfSale.outputDevice.LCDDisplay;
import pointOfSale.outputDevice.Printer;

public class pointOfSale {
    private BarcodeScanner barcodeScanner;
    private LCDDisplay lcdDisplay;
    private Printer printer;
    private ProductDataBase productDataBase;
    private Receipt receipt;

    public pointOfSale(BarcodeScanner barcodeScanner, LCDDisplay lcdDisplay, Printer printer, ProductDataBase productDataBase) {
        this.barcodeScanner = barcodeScanner;
        this.lcdDisplay = lcdDisplay;
        this.printer = printer;
        this.productDataBase = productDataBase;
    }

    public void scan(String code) {
        try {
            if(!(code.equals("exit")))
                barcodeScanner.scan(code);
            else
                printreceipt();
        } catch (InvalidBarcodeException e) {
            lcdDisplay.display(e.getMessage());
        }
    }

    public void checkProduct(int code){
        try {
            if (productDataBase.contains(code))
                receipt.add(productDataBase.getProduct(code));
            else
                lcdDisplay.display("Product not found");
        }catch (InvalidIdException e){
            lcdDisplay.display(e.getMessage());//Should never happened
        }
    }
    private void printreceipt(){
        lcdDisplay.display(receipt.getTotalSum().getAmount()+" "+receipt.getTotalSum().getCourency());
    }

}
