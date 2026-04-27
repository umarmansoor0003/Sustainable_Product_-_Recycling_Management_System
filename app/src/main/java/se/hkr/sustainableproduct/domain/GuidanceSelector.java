package se.hkr.sustainableproduct.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Selects the appropriate recycling guidance strategy at runtime.
 * Holds a list of RecyclingGuide implementations and selects the first one
 * whose supports() method returns true for the given materials.
 */
public class GuidanceSelector {
    private List<RecyclingGuide> implementables;
    
    /**
     * Constructor injection - follows Dependency Inversion Principle (DIP).
     * This allows testing with mock strategies and easy extension.
     * @param implementables the list of recycling strategies to use
     */
    public GuidanceSelector(List<RecyclingGuide> implementables) {
        this.implementables = implementables;
    }

    /**
     * Selects the appropriate recycling strategy for the given materials.
     * Iterates through strategies in order and returns the first one that supports the materials.
     * @param materials the list of materials to get guidance for
     * @return the first RecyclingGuide that supports these materials, or null if none found
     */
    public RecyclingGuide select(List<Material> materials) {
        for (RecyclingGuide guide : implementables) {
            if (guide.supports(materials)) {
                return guide;
            }
        }
        return null;
    }
}