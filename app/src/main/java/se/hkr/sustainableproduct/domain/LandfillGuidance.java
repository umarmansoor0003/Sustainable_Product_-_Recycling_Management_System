package se.hkr.sustainableproduct.domain;

import java.util.List;

public class LandfillGuidance implements RecyclingGuide {
    
    @Override
    public boolean supports(List<Material> materials) {
        return true;
    }
    
    @Override
    public String getGuidance(List<Material> materials) {
        return "This product is not recyclable.";
    }
}