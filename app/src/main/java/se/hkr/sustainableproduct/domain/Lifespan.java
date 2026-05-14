package se.hkr.sustainableproduct.domain;

public class Lifespan {
    private int years;

    public Lifespan(int years) {
        if (years <= 0) {
            throw new IllegalArgumentException("Lifespan must be greater than 0");
        }
        this.years = years;
    }

    public int getYears() {
        return years;
    }
}