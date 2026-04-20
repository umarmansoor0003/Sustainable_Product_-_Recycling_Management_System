package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MixedMaterialGuidance implements RecyclingGuide {
    @Override
    public boolean supports(List<MaterialComposition> compositions) {
        Set<RecyclingCategory> categories = new HashSet<>();
        for (MaterialComposition composition : compositions) {
            categories.add(composition.getCategory());
        }
        return categories.size() > 1;
    }

    @Override
    public String getGuidance(List<MaterialComposition> compositions) {
        return "This product contains mixed materials. Take it to a special recycling station.";
    }
}