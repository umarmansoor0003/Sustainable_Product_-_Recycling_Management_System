package se.hkr.sustainableproduct.domain;

/**
 * Represents the usage of a Material within a Product, including its quantity.
 * This class enables the reuse of a single Material definition across multiple
 * products — each product specifies its own quantity for the shared material.
 */
public class MaterialComposition {
    private double quantity;
    private Material material;

    /**
     * Constructs a new MaterialComposition.
     *
     * @param quantity the amount/quantity of this material used in the product
     * @param material the material being used
     */
    public MaterialComposition(double quantity, Material material) {
        this.quantity = quantity;
        this.material = material;
    }

    /**
     * @return the quantity of this material in the composition
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @return the material used in this composition
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Convenience method that delegates to the material's recycling category.
     *
     * @return the recycling category of the underlying material
     */
    public RecyclingCategory getCategory() {
        return material.getRecyclingCategory();
    }
}
