package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * Implementation of RecyclingGuide for compostable materials.
 * This strategy applies only when ALL materials in the product are compostable.
 */
public class CompostableGuidance implements RecyclingGuide {
    
    /**
     * Checks if all materials in the list are compostable.
     * @param materials the list of materials to check
     * @return true if every material is compostable, false otherwise
     */
    @Override
    public boolean supports(List<Material> materials) {
        for (Material material : materials) {
            if (material.getRecyclingCategory() != RecyclingCategory.COMPOSTABLE) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Provides composting guidance for fully compostable products.
     * Uses StringBuilder for string concatenation.
     * @param materials the list of materials
     * @return a String with composting instructions
     */
    @Override
    public String getGuidance(List<Material> materials) {
        StringBuilder result = new StringBuilder();
        result.append("This product is compostable.\n");
        result.append("Compostable materials in this product:\n");

        for (Material material : materials) {
            result.append("  - ").append(material.getName()).append("\n");
        }
        result.append("\nPlease place in compost bin.");
        return result.toString();
    }
    
}