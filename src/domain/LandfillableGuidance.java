package domain;

import java.util.List;

public class LandfillableGuidance implements RecyclingGuide {
    @Override
    public boolean supports(List<MaterialComposition> compositions) {
        if (compositions.isEmpty()) {
            return false;
        }

        for (MaterialComposition composition : compositions) {
            if (composition.getCategory() != RecyclingCategory.LANDFILL) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getGuidance(List<MaterialComposition> compositions) {
        return "Dispose in general landfill waste.";
    }
}