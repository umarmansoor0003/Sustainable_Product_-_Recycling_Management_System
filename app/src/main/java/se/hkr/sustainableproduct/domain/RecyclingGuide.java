package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * Defines the contract for providing recycling guidance for a product.
 * Any class that implements this interface must provide logic to determine
 * if it supports the given materials and generate appropriate guidance.
 * This allows recycling strategies to be swapped without modifying the classes that depend on them.
 */
public interface RecyclingGuide {
    
    /**
     * Determines whether this guidance strategy applies to the given materials.
     * @param materials the list of materials to check
     * @return true if this strategy can provide guidance for these materials, false otherwise
     */
    boolean supports(List<Material> materials);
    
    /**
     * Generates recycling guidance text based on the given materials.
     * @param materials the list of materials to generate guidance for
     * @return a String containing recycling instructions
     */
    String getGuidance(List<Material> materials);
}