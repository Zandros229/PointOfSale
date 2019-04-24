package tests.inputDeviceTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pointOfSale.InputDevice.BarcodeScanner;
import pointOfSale.InputDevice.InvalidBarcodeException;

public class BarcodeScannerTests {
    private BarcodeScanner barcodeScanner;
    @BeforeEach
    public void setup(){
        barcodeScanner=new BarcodeScanner();
    }

    @Test
    public void EmptyCodeTest(){
        Assertions.assertThrows(InvalidBarcodeException.class,()->barcodeScanner.scan(""));
    }
    @Test
    public void GoodNumberTest(){
        try {
            Assertions.assertEquals(12,barcodeScanner.scan("12"));
        }catch(InvalidBarcodeException e){
            System.out.println(e.getMessage());// Should never happened
        }
    }
    @Test
    public void WrongCodeTest(){
        Assertions.assertThrows(NumberFormatException.class,()->barcodeScanner.scan("785agd"));
    }
}
