package se.hkr.sustainableproduct.domain;

/**
 * A weighted implementation of ImpactCalculationStrategy.
 * Calculates environmental impact by factoring in both the material's
 * base impact value and the product's lifespan as a weighting factor.
 * Longer lifespan reduces the overall impact score.
 */
public class WeightedImpactStrategy implements ImpactCalculationStrategy {
/**
 * Calculates impact by weighing each material's base impact value
 * against the product's lifespan duration.
 * @param product the product whose impact is to be calculated
 * @return the weighted environmental impact as a double
 */
    @Override
    public double calculateImpact(Product product) {
        double calc = 0.0;
        for (MaterialComposition mc : product.getCompositions()) {
            calc += (mc.getMaterial().getBaseImpact() * mc.getQuantity()) / product.getLifespan().getYears();
        }
        return calc;
    }
}
