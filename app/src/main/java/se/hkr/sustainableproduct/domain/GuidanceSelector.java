package se.hkr.sustainableproduct.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Selects the appropriate recycling guidance strategy at runtime.
 */
public class GuidanceSelector {
    private List<RecyclingGuide> implementables;
    
    public GuidanceSelector(List<RecyclingGuide> implementables) {
        this.implementables = implementables;
    }

    public RecyclingGuide select(List<Material> materials) {
        for (RecyclingGuide implementable : implementables) {
            if (implementable.supports(materials)) {
                return implementable;
            }
        }
        throw new IllegalArgumentException("No suitable recycling strategy found for these materials");
    }
}