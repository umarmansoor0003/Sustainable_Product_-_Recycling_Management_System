package domain;

public class Material {
    private String name;
    private double baseImpactValue;
    private RecyclingCategory recyclingCategory;

    public Material(String name, double baseImpactValue, RecyclingCategory recyclingCategory) {
        this.name = name;
        this.baseImpactValue = baseImpactValue;
        this.recyclingCategory = recyclingCategory;
    }

    public String getName() {
        return name;
    }

    public double getBaseImpact() {
        return baseImpactValue;
    }

    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}