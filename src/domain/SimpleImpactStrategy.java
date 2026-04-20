package domain;

public class SimpleImpactStrategy implements ImpactCalculationStrategy {
    @Override
    public double calculateImpact(Product product) {
        double total = 0.0;

        for (MaterialComposition composition : product.getCompositions()) {
            total += composition.getMaterial().getBaseImpact() * composition.getQuantity();
        }

        return total;
    }
}