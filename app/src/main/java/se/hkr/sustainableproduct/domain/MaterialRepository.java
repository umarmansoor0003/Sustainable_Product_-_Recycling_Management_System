package se.hkr.sustainableproduct.domain;

import java.util.List;

/**
 * Defines the contract for persisting and retrieving Material entities.
 * Implementations are provided in the infrastructure layer, following
 * the Dependency Inversion Principle.
 */
public interface MaterialRepository {

    /**
     * Persists a material.
     *
     * @param material the material to save
     */
    void save(Material material);

    /**
     * Retrieves all stored materials.
     *
     * @return a list of all materials
     */
    List<Material> findAll();

    /**
     * Finds a material by its name.
     *
     * @param name the name to search for
     * @return the matching Material, or null if not found
     */
    Material findByName(String name);
}
