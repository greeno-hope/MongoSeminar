package uk.ac.hope.csc.segh.mongoseminar;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Product product);

    List< Product > getAllProduct();

    Product getProductById(long productId);

    Product getProductByName(String name);

    void deleteProduct(long id);

}
