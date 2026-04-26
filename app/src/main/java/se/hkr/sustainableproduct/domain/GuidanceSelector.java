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
     * Constructs a GuidanceSelector with ordered strategies by priority.
     * Order: Hazardous (safety) - Recyclable - Compostable - Landfill → Mixed.
     */
    public GuidanceSelector() {
        implementables = new ArrayList<>();
        implementables.add(new HazardousGuidance());
        implementables.add(new RecyclableGuidance());
        implementables.add(new CompostableGuidance());
        implementables.add(new LandfillGuidance());
        implementables.add(new MixedMaterialGuidance());
    }
    
    /**
     * Selects the appropriate recycling strategy for the given materials.
     * @param materials the list of materials
     * @return the first RecyclingGuide that supports these materials
     */
    public RecyclingGuide select(List<Material> materials) {
        for (RecyclingGuide guide : implementables) {
            if (guide.supports(materials)) {
                return guide;
            }
        }
        return new MixedMaterialGuidance();
    }
}