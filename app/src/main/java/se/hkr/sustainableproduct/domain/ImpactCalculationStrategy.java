package se.hkr.sustainableproduct.domain;

/**
 * Defines the contract for calculating the environmental impact of a product.
 * Any class that implements this interface must provide its own calculation logic.
 * This allows strategies to be swapped without modifying the classes that depend on them.
 */
public interface ImpactCalculationStrategy {
/**
 * Calculates the environmental impact of a given product
 * based on its material compositions.
 * @param product the product whose impact is to be calculated
 * @return the calculated environmental impact as a double
 */
    double calculateImpact(Product product);
}
