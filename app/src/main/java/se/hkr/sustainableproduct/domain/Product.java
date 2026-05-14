package se.hkr.sustainableproduct.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product {
    private String name;
    private Category category;
    private Lifespan lifespan;
    private List<MaterialComposition> compositions;

    public Product(String name, Category category, Lifespan lifespan, List<MaterialComposition> compositions) {
        this.name = name;
        this.category = category;
        this.lifespan = lifespan;
        this.compositions = new ArrayList<>(compositions);
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Lifespan getLifespan() {
        return lifespan;
    }

    public List<MaterialComposition> getCompositions() {
        return new ArrayList<>(compositions);
    }

    public boolean hasMixedMaterials() {
        Set<RecyclingCategory> categories = new HashSet<>();
        for (MaterialComposition composition : compositions) {
            categories.add(composition.getCategory());
        }
        return categories.size() > 1;
    }
}