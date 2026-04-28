package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * This strategy applies if any material in the product is hazardous.
 */
public class HazardousGuidance implements RecyclingGuide {
    
    /**
     * Checks if any material in the list is hazardous.
     * @param materials the list of materials to check
     * @return true if at least one material is hazardous, false otherwise
     */
    @Override
    public boolean supports(List<Material> materials) {
        for (Material material : materials) {
            if (material.getRecyclingCategory() == RecyclingCategory.HAZARDOUS) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Provides safety warning and disposal guidance for hazardous products.
     * @param materials the list of materials
     * @return a String with hazardous waste disposal instructions
     */
    @Override
    public String getGuidance(List<Material> materials) {
        return "This product contains hazardous materials. Take to a designated hazardous waste facility.";
    }
    
}