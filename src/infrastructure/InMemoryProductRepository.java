package infrastructure;

import domain.Product;
import domain.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }
}