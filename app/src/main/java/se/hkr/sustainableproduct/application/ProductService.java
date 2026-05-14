package se.hkr.sustainableproduct.application;

import se.hkr.sustainableproduct.domain.GuidanceSelector;
import se.hkr.sustainableproduct.domain.ImpactCalculationStrategy;
import se.hkr.sustainableproduct.domain.Material;
import se.hkr.sustainableproduct.domain.MaterialComposition;
import se.hkr.sustainableproduct.domain.Product;
import se.hkr.sustainableproduct.domain.ProductRepository;
import se.hkr.sustainableproduct.domain.RecyclingGuide;

import java.util.ArrayList;
import java.util.List;

/**
 * Application service that manages product use cases.
 * Coordinates product creation, retrieval, impact calculation,
 * and recycling guidance without containing UI logic.
 */
public class ProductService {
    private ImpactCalculationStrategy strategy;
    private ProductRepository repository;
    private GuidanceSelector selector;

    /**
     * Constructs a ProductService with the required dependencies.
     *
     * @param strategy   the impact calculation strategy
     * @param repository the repository used to persist and retrieve products
     * @param selector   the selector used to choose recycling guidance
     */
    public ProductService(ImpactCalculationStrategy strategy,
                          ProductRepository repository,
                          GuidanceSelector selector) {
        this.strategy = strategy;
        this.repository = repository;
        this.selector = selector;
    }

    /**
     * Calculates environmental impact for a product found by name.
     *
     * @param productName the name of the product
     * @return the calculated environmental impact
     * @throws IllegalArgumentException if no product with the given name exists
     */
    public double calculateImpact(String productName) {
        Product product = repository.findByName(productName);

        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }

        return strategy.calculateImpact(product);
    }

    /**
     * Saves a product.
     *
     * @param product the product to save
     */
    public void createProduct(Product product) {
        repository.save(product);
    }

    /**
     * Retrieves all stored products.
     *
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    /**
     * Finds a product by name.
     *
     * @param name the product name
     * @return the matching product, or null if not found
     */
    public Product findProductByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Gets recycling guidance for a product found by name.
     *
     * @param productName the name of the product
     * @return recycling guidance text
     * @throws IllegalArgumentException if no product with the given name exists
     */
    public String getRecyclingGuidance(String productName) {
        Product product = repository.findByName(productName);

        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }

        List<Material> materials = extractMaterials(product);
        RecyclingGuide guide = selector.select(materials);

        return guide.getGuidance(materials);
    }

    /**
     * Extracts materials from the product's material compositions.
     *
     * @param product the product
     * @return a list of materials used in the product
     */
    private List<Material> extractMaterials(Product product) {
        List<Material> materials = new ArrayList<>();

        for (MaterialComposition composition : product.getCompositions()) {
            materials.add(composition.getMaterial());
        }

        return materials;
    }
}