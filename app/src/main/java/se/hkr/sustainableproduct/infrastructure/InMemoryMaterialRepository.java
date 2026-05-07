package se.hkr.sustainableproduct.infrastructure;

import se.hkr.sustainableproduct.domain.Material;
import se.hkr.sustainableproduct.domain.MaterialRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the MaterialRepository interface.
 * Stores materials in an ArrayList for simple, non-persistent storage.
 * Can be replaced with a database-backed implementation without
 * affecting the domain or application layers.
 */
public class InMemoryMaterialRepository implements MaterialRepository {
    private List<Material> materials;

    public InMemoryMaterialRepository() {
        this.materials = new ArrayList<>();
    }

    /**
     * Saves a material to the in-memory store.
     *
     * @param material the material to save
     */
    @Override
    public void save(Material material) {
        materials.add(material);
    }

    /**
     * Returns all stored materials.
     *
     * @return a list of all materials
     */
    @Override
    public List<Material> findAll() {
        return materials;
    }

    /**
     * Finds a material by name, performing a case-sensitive search.
     *
     * @param name the name to search for
     * @return the matching Material, or null if not found
     */
    @Override
    public Material findByName(String name) {
        for (Material material : materials) {
            if (material.getName().equals(name)) {
                return material;
            }
        }
        return null;
    }
}
