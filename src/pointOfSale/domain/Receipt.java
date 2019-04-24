package pointOfSale.domain;

import java.util.LinkedList;
import java.util.List;

public class Receipt {
    private List<Product> productList=new LinkedList<Product>();

    public void add(Product product){
        productList.add(product);
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for (Product product: productList
             ) {
            builder.append(product.toString());
        }
        return builder.toString();
    }
}
