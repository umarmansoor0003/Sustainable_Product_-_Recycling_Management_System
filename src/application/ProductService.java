package application;

import domain.GuidanceSelector;
import domain.ImpactCalculationStrategy;
import domain.MaterialComposition;
import domain.Product;
import domain.ProductRepository;

import java.util.List;

public class ProductService {
    private ImpactCalculationStrategy strategy;
    private ProductRepository repository;
    private GuidanceSelector selector;

    public ProductService(ImpactCalculationStrategy strategy,
                          ProductRepository repository,
                          GuidanceSelector selector) {
        this.strategy = strategy;
        this.repository = repository;
        this.selector = selector;
    }

    public double calculateImpact(Product product) {
        return strategy.calculateImpact(product);
    }

    public void createProduct(Product product) {
        repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public String getRecyclingGuidance(Product product) {
        List<MaterialComposition> compositions = product.getCompositions();
        return selector.select(compositions).getGuidance(compositions);
    }
}