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
        StringBuilder result = new StringBuilder();
        result.append("MIXED MATERIAL PRODUCT DETECTED\n");
        result.append("This product contains different material types.\n\n");
        result.append("Materials and their disposal instructions:\n");

        for (Material material : materials) {
            result.append("  - ").append(material.getName()).append(": ");

            if (material.getRecyclingCategory() == RecyclingCategory.RECYCLABLE) {
                result.append("Recycle - Place in recycling bin");
            } else if (material.getRecyclingCategory() == RecyclingCategory.COMPOSTABLE) {
                result.append("Compost - Place in compost bin");
            } else if (material.getRecyclingCategory() == RecyclingCategory.HAZARDOUS) {
                result.append("HAZARDOUS - Special handling required");
            } else {
                result.append("Landfill - Dispose in regular bin");
            }
            result.append("\n");
        }
        result.append("\nPlease separate materials if possible before recycling.");
        return result.toString();
    
    }
}