package domain;

public class MaterialComposition {
    private double quantity;
    private Material material;

    public MaterialComposition(double quantity, Material material) {
        this.quantity = quantity;
        this.material = material;
    }

    public double getQuantity() {
        return quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public RecyclingCategory getCategory() {
        return material.getRecyclingCategory();
    }
}