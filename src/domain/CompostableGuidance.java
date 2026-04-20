package domain;

import java.util.List;

public class CompostableGuidance implements RecyclingGuide {
    @Override
    public boolean supports(List<MaterialComposition> compositions) {
        if (compositions.isEmpty()) {
            return false;
        }

        for (MaterialComposition composition : compositions) {
            if (composition.getCategory() != RecyclingCategory.COMPOSTABLE) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getGuidance(List<MaterialComposition> compositions) {
        return "Dispose in compostable waste if allowed in your area.";
    }
}