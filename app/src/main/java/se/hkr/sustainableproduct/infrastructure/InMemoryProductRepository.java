package se.hkr.sustainableproduct.infrastructure;

import se.hkr.sustainableproduct.domain.Product;
import se.hkr.sustainableproduct.domain.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the ProductRepository interface.
 * Stores products in an ArrayList for simple, non-persistent storage.
 */
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    public InMemoryProductRepository() {
        this.products = new ArrayList<>();
    }

    /**
     * Saves a product to the in-memory store.
     *
     * @param product the product to save
     */
    @Override
    public void save(Product product) {
        products.add(product);
    }

    /**
     * Returns all stored products.
     *
     * @return a copy of the list of all products
     */
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    /**
     * Finds a product by name, using a case-insensitive search.
     *
     * @param name the name to search for
     * @return the matching Product, or null if not found
     */
    @Override
    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}