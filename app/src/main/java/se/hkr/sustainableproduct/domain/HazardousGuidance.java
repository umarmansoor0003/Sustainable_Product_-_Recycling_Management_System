package se.hkr.sustainableproduct.domain;

import java.util.List;

public class HazardousGuidance implements RecyclingGuide {
    
    @Override
    public boolean supports(List<Material> materials) {
        return true;
    }
    
    @Override
    public String getGuidance(List<Material> materials) {
        return "Do not dispose in regular trash.";
    }
}