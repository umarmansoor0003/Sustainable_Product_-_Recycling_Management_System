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
            if (!material.getRecyclingCategory().isRecyclable()) {
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
        return "This product is recyclable.";
    }
}