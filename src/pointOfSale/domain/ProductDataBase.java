package pointOfSale.domain;

import java.util.HashMap;
import java.util.Map;

public class ProductDataBase {
    private Map<Integer, Product> productMap=new HashMap<Integer, Product>();

    public void add(Integer id, Product product) throws InvalidIdException{
        if(productMap.containsKey(id)){
            throw new InvalidIdException("Wrong Id");
        }
        else
            productMap.put(id,product);
    }

    public boolean contains(Integer id){
        if(productMap.containsKey(id))
            return true;
        else
            return false;

    }

    public Product getProduct(Integer id) throws InvalidIdException{
        if(contains(id))
            return productMap.get(id);
        else
            throw new InvalidIdException("Product not found");
    }
}
