package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
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
     * @param materials the list of materials
     * @return a String with composting instructions
     */
    @Override
    public String getGuidance(List<Material> materials) {
        return "All materials in this product are compostable. Place in the compost bin.";
    }
    
}