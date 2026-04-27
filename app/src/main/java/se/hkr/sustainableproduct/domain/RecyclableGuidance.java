package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * Implementation of RecyclingGuide for recyclable materials.
 * This strategy applies only when ALL materials in the product are recyclable.
 */
public class RecyclableGuidance implements RecyclingGuide {
    
    /**
     * Checks if all materials in the list are recyclable.
     * @param materials the list of materials to check
     * @return true if every material is recyclable, false otherwise
     */
    @Override
    public boolean supports(List<Material> materials) {
        for (Material material : materials) {
            if (material.getRecyclingCategory() != RecyclingCategory.RECYCLABLE) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Provides recycling guidance for fully recyclable products.
     * @param materials the list of materials
     * @return a String with recycling instructions
     */
    @Override
    public String getGuidance(List<Material> materials) {
        StringBuilder result = new StringBuilder();
        result.append("This product is recyclable.\n");
        result.append("Recyclable materials in this product:\n");

        for (Material material : materials) {
            result.append("  - ").append(material.getName()).append("\n");
        }
        result.append("\nPlease recycling bin.");
        return result.toString();
    }
}