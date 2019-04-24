package pointOfSale;

import pointOfSale.Application.PointOfSale;
import pointOfSale.InputDevice.BarcodeScanner;
import pointOfSale.domain.*;
import pointOfSale.outputDevice.LCDDisplay;
import pointOfSale.outputDevice.Printer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidIdException {
        ProductDataBase productDataBase=new ProductDataBase();
        productDataBase.add(1,new Product("Breed",new Money(2.30, Currency.PLN)));
        productDataBase.add(2,new Product("Butter",new Money(5.40, Currency.PLN)));
        productDataBase.add(3,new Product("Water",new Money(1.30, Currency.PLN)));
        PointOfSale pointOfSale=new PointOfSale(new BarcodeScanner(),new LCDDisplay(),new Printer(),productDataBase);
        Scanner scan = new Scanner(System.in);
        while(true) {
            pointOfSale.scan(scan.nextLine());
        }

    }
}
