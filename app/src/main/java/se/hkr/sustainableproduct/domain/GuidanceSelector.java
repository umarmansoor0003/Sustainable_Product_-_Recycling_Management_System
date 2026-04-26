package se.hkr.sustainableproduct.domain;

import java.util.ArrayList;
import java.util.List;

public class GuidanceSelector {
    private List<RecyclingGuide> implementables;
    
    public GuidanceSelector(List<RecyclingGuide> implementables) {
        this.implementables = implementables;
    }
    
    public RecyclingGuide select(List<Material> materials) {
        for (RecyclingGuide guide : implementables) {
            if (guide.supports(materials)) {
                return guide;
            }
        }
        return new MixedMaterialGuidance();
    }
}