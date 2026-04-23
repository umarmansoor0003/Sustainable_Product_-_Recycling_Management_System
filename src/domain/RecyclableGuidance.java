package domain;

import java.util.List;
public class RecyclableGuidance implements RecyclingGuide {
    
    @Override
    public boolean supports(List<Material> materials) {
        for (Material material : materials) {
            if (!material.getRecyclingCategory().isRecyclable()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String generateGuidance(List<Material> materials) {
        String result = "This product is recyclable.\n";
        result = result + "Instructions:\n";
        
        for (Material material : materials) {
            result = result + "  - " + material.getName() + ": " + material.getRecyclingCategory().getInstruction() + "\n";
        }
        return result;
    }
}