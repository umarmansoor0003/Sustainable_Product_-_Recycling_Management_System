package domain;

import java.util.List;

public interface RecyclingGuide {
    boolean supports(List<MaterialComposition> compositions);
    String getGuidance(List<MaterialComposition> compositions);
}