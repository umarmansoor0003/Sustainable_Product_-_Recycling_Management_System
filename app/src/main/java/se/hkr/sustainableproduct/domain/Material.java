package se.hkr.sustainableproduct.domain;

/**
 * Represents a material that can be used in product compositions.
 * Materials are defined once and reused across multiple products
 * through MaterialComposition.
 */
public class Material {
    private String name;
    private double baseImpactValue;
    private RecyclingCategory recyclingCategory;

    /**
     * Constructs a new Material.
     *
     * @param name              the name of the material (e.g. "Aluminium",
     *                          "Cardboard")
     * @param baseImpactValue   the environmental impact value of this material
     * @param recyclingCategory the recycling classification of this material
     */
    public Material(String name, double baseImpactValue, RecyclingCategory recyclingCategory) {
        this.name = name;
        this.baseImpactValue = baseImpactValue;
        this.recyclingCategory = recyclingCategory;
    }

    /**
     * @return the name of this material
     */
    public String getName() {
        return name;
    }

    /**
     * @return the base environmental impact value
     */
    public double getBaseImpact() {
        return baseImpactValue;
    }

    /**
     * @return the recycling category of this material
     */
    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}
