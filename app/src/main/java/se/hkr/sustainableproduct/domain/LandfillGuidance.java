package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * This strategy applies only when all materials in the product are non recyclable and non compostable.
 */
public class LandfillGuidance implements RecyclingGuide {
    
    /**
     * Checks if all materials in the list are landfill.
     * @param materials the list of materials to check
     * @return true if every material is landfill, false otherwise
     */
    @Override
    public boolean supports(List<Material> materials) {
        for (Material material : materials) {
            if (material.getRecyclingCategory() != RecyclingCategory.LANDFILL) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Provides landfill disposal guidance.
     * @param materials the list of materials
     * @return a String with landfill disposal instructions
     */
    @Override
    public String getGuidance(List<Material> materials) {
        return "All materials in this product are non-recyclable. Place in general waste.";
    }

}