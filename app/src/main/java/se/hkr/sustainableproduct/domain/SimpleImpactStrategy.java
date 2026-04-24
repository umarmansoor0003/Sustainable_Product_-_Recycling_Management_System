package se.hkr.sustainableproduct.domain;

/**
 * A simple implementation of ImpactCalculationStrategy.
 * Calculates environmental impact by summing the base impact values
 * of all materials in the product's composition.
 */
public class SimpleImpactStrategy {
/**
 * Calculates impact by summing each material's base impact value
 * multiplied by its quantity in the product composition.
 * @param product the product whose impact is to be calculated
 * @return the total calculated impact as a double
 */
    @Override
    double calculateImpact(Product product) {

    }
}
