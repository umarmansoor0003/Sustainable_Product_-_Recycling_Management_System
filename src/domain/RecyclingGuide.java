package domain;

import java.util.List;

public interface RecyclingGuide {
    boolean supports(List<MaterialComposition> compositions);
    String generateGuidance(List<MaterialComposition> compositions);
}