package domain;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    List<Product> findAll();
}