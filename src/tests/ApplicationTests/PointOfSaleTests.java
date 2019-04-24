package tests.ApplicationTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pointOfSale.Application.PointOfSale;
import pointOfSale.InputDevice.BarcodeScanner;
import pointOfSale.domain.*;
import pointOfSale.outputDevice.LCDDisplay;
import pointOfSale.outputDevice.Printer;

import java.io.OutputStream;

public class PointOfSaleTests {
    private PointOfSale pointOfSale;
    private ProductDataBase productDataBase;
    private Printer printer;
    private LCDDisplay lcdDisplay;
    private BarcodeScanner barcodeScanner;

    @BeforeEach
    public void setup() {
        try {
            lcdDisplay=new LCDDisplay();
            barcodeScanner=new BarcodeScanner();
            printer = new Printer();
            productDataBase = new ProductDataBase();
            productDataBase.add(1, new Product("Breed", new Money(2.30, Currency.PLN)));
            productDataBase.add(2, new Product("Butter", new Money(5.40, Currency.PLN)));
            productDataBase.add(3, new Product("Water", new Money(1.30, Currency.PLN)));
            pointOfSale = new PointOfSale(barcodeScanner, lcdDisplay, printer, productDataBase);
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void BarcodeFindInDataBaseTest(){
        pointOfSale.scan("1");
        Assertions.assertEquals("Breed price=2.3 PLN", lcdDisplay.getText());
    }

    @Test
    public void BarcodeNotFindInDataBaseTest(){
        pointOfSale.scan("4");
        Assertions.assertEquals("Product not found", lcdDisplay.getText());
    }

    @Test
    public void BarcodeEmptyTest(){
        pointOfSale.scan("");
        Assertions.assertEquals("Invalid bar-code", lcdDisplay.getText());
    }

    @Test
    public void ExitEnterAfterFewProductsTest(){
        pointOfSale.scan("1");
        pointOfSale.scan("2");
        pointOfSale.scan("3");
        pointOfSale.scan("exit");
        Assertions.assertEquals("9.0 PLN", lcdDisplay.getText());
    }

    @Test
    public void ExitEnterBeforeAnyProductsTest(){
        pointOfSale.scan("exit");
        Assertions.assertEquals("0.0 PLN", lcdDisplay.getText());
    }

    @Test
    public void PrinterWithFewProductsTests(){
        pointOfSale.scan("1");
        pointOfSale.scan("2");
        pointOfSale.scan("3");
        pointOfSale.scan("exit");
        Assertions.assertEquals("Breed price=2.3 PLN\n" +
                "Butter price=5.4 PLN\n" +
                "Water price=1.3 PLN\n" +
                "9.0 PLN", printer.getText());
    }

    @Test
    public void PrinterWithNoProductsInTests(){
        pointOfSale.scan("exit");
        Assertions.assertEquals("0.0 PLN", printer.getText());
    }

}
