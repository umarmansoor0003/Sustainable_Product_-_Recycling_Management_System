package se.hkr.sustainableproduct.domain;

/**
 * Represents the recycling classification of a material.
 * Used to determine the appropriate recycling guidance strategy.
 */
public enum RecyclingCategory {
    RECYCLABLE,
    COMPOSTABLE,
    HAZARDOUS,
    LANDFILL
}
