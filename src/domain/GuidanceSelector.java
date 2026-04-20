package domain;

import java.util.List;

public class GuidanceSelector {
    private List<RecyclingGuide> guides;

    public GuidanceSelector(List<RecyclingGuide> guides) {
        this.guides = guides;
    }

    public RecyclingGuide select(List<MaterialComposition> compositions) {
        for (RecyclingGuide guide : guides) {
            if (guide.supports(compositions)) {
                return guide;
            }
        }
        throw new IllegalStateException("No recycling guidance found for product composition.");
    }
}