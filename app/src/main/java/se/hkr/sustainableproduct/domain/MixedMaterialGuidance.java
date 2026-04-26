package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * Implementation of RecyclingGuide for products with mixed material types.
 * This strategy applies when materials have different recycling categories.
 */
public class MixedMaterialGuidance implements RecyclingGuide {
    
    /**
     * Checks if materials have different recycling categories.
     * Compares each material's category with the first material's category.
     * 
     * @param materials the list of materials to check
     * @return true if materials have different categories, false if all are the same or list is empty
     */
    @Override
    public boolean supports(List<Material> materials) {
        if (materials == null || materials.isEmpty()) {
            return false;
        }
        
        for (int i = 1; i < materials.size(); i++) {
            if (materials.get(i).getRecyclingCategory() != materials.get(0).getRecyclingCategory()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Provides guidance for products with mixed material types.
     * 
     * @param materials the list of materials
     * @return a String with mixed material disposal instructions
     */
    @Override
    public String getGuidance(List<Material> materials) {
        return "This product has mixed materials.";
    }
}