package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * Defines the contract for persisting and retrieving Product entities.
 * Implementations are provided in the infrastructure layer, following
 * the Dependency Inversion Principle.
 */
public interface ProductRepository {

    /**
     * Persists a product.
     *
     * @param product the product to save
     */
    void save(Product product);

    /**
     * Retrieves all stored products.
     *
     * @return a list of all products
     */
    List<Product> findAll();

    /**
     * Finds a product by its name.
     *
     * @param name the name to search for
     * @return the matching Product, or null if not found
     */
    Product findByName(String name);
}