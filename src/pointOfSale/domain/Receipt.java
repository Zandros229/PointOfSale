package pointOfSale.domain;

import java.util.LinkedList;
import java.util.List;

public class Receipt {
    private List<Product> productList=new LinkedList<Product>();
    private Money totalSum;

    public Receipt(List<Product> productList) {
        this.productList = productList;
        this.totalSum=new Money(0.0,Currency.PLN);
    }

    public void add(Product product){
        productList.add(product);
        if(product.getPrice().getCourency()==totalSum.getCourency())
            totalSum.setAmount(totalSum.getAmount()+product.getPrice().getAmount());
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for (Product product: productList
             ) {
            builder.append(product.toString());
            builder.append("\n");
        }
        builder.append(totalSum.getAmount());
        builder.append(" ");
        builder.append(totalSum.getCourency());
        return builder.toString();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Money getTotalSum() {
        return totalSum;
    }
}
