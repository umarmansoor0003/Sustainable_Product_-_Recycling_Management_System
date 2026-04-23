package domain;

import java.util.List;

public interface RecyclingGuide {
    boolean supports(List<Material> materials);
    String getGuidance(List<Material> materials);
}