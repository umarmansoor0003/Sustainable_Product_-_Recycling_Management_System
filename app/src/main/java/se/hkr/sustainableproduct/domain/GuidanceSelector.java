package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * Selects the appropriate recycling guidance strategy at runtime.
 */
public class GuidanceSelector {
    private List<RecyclingGuide> guides;

    public GuidanceSelector(List<RecyclingGuide> guides) {
        this.guides = guides;
    }

    /**
     * Selects the first guidance strategy that supports the given materials.
     *
     * @param materials the list of materials
     * @return the matching recycling guide
     * @throws IllegalArgumentException if no guide supports the materials
     */
    public RecyclingGuide select(List<Material> materials) {
        for (RecyclingGuide guide : guides) {
            if (guide.supports(materials)) {
                return guide;
            }
        }

        throw new IllegalArgumentException("No suitable recycling strategy found for these materials");
    }
}