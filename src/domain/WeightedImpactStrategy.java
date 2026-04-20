package domain;

public class WeightedImpactStrategy implements ImpactCalculationStrategy {
    @Override
    public double calculateImpact(Product product) {
        double total = 0.0;
        int years = product.getLifespan().getYears();

        for (MaterialComposition composition : product.getCompositions()) {
            total += composition.getMaterial().getBaseImpact() * composition.getQuantity() * years;
        }

        return total;
    }
}