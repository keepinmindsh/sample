package designpattern.gof_abstractFactory.sample002;

public class ProductFactory {
    public static Product getProduct(ProductAbstractFactory product) {
        return product.createProduct();
    }
}
