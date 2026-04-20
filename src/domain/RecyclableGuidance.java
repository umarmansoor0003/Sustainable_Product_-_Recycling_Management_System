package domain;

import java.util.List;

public class RecyclableGuidance implements RecyclingGuide {
    @Override
    public boolean supports(List<MaterialComposition> compositions) {
        if (compositions.isEmpty()) {
            return false;
        }

        for (MaterialComposition composition : compositions) {
            if (composition.getCategory() != RecyclingCategory.RECYCLABLE) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getGuidance(List<MaterialComposition> compositions) {
        return "Recycle using the normal recycling process.";
    }
}