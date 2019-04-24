package tests.domainTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pointOfSale.domain.*;

public class ProductDataBaseTests {
    private ProductDataBase productDataBase;
    @BeforeEach
    public void setup(){
        productDataBase=new ProductDataBase();
        try {
            productDataBase.add(1, new Product("Breed", new Money(2.30, Currency.PLN)));
            productDataBase.add(2, new Product("Butter", new Money(5.40, Currency.PLN)));
            productDataBase.add(3, new Product("Water", new Money(1.30, Currency.PLN)));
        }catch(InvalidIdException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void wrongIdGetProductTest(){
        Assertions.assertThrows(InvalidIdException.class,()->productDataBase.getProduct(4));
    }
    @Test
    public void wrongIdAddTest(){
        Assertions.assertThrows(InvalidIdException.class,()->productDataBase.add(2,new Product("Orange",new Money(1.20,Currency.PLN))));
    }
    @Test
    public void goodIdGetProductTest(){
        Product product=new Product("Breed", new Money(2.30, Currency.PLN));
        try {
            Assertions.assertTrue(product.equals(productDataBase.getProduct(1)));
        }catch(InvalidIdException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void goodIdAddTest(){
        Product product=new Product("Orange", new Money(4.30, Currency.PLN));
        try {
            productDataBase.add(4,product);
            Assertions.assertTrue(product.equals(productDataBase.getProduct(4)));
        }catch(InvalidIdException e){
            System.out.println(e.getMessage());
        }
    }


}
