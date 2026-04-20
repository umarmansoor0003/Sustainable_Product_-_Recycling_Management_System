package domain;

import java.util.List;

public class HazardousGuidance implements RecyclingGuide {
    @Override
    public boolean supports(List<MaterialComposition> compositions) {
        if (compositions.isEmpty()) {
            return false;
        }

        for (MaterialComposition composition : compositions) {
            if (composition.getCategory() != RecyclingCategory.HAZARDOUS) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getGuidance(List<MaterialComposition> compositions) {
        return "Take this product to a hazardous waste facility.";
    }
}