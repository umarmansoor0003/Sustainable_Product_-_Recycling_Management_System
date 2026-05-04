package se.hkr.sustainableproduct.application;

import se.hkr.sustainableproduct.domain.Material;
import se.hkr.sustainableproduct.domain.MaterialRepository;
import se.hkr.sustainableproduct.domain.RecyclingCategory;

import java.util.List;

/**
 * Application service that manages the material lifecycle.
 * Coordinates material creation, retrieval, and lookup operations
 * by delegating to the MaterialRepository.
 */
public class MaterialService {
    private MaterialRepository repository;

    /**
     * Constructs a MaterialService with the given repository.
     *
     * @param repository the repository used to persist and retrieve materials
     */
    public MaterialService(MaterialRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new material and persists it via the repository.
     *
     * @param name         the name of the material
     * @param impactValue  the environmental impact value
     * @param category     the recycling category
     */
    public void createMaterial(String name, double impactValue, RecyclingCategory category) {
        Material material = new Material(name, impactValue, category);
        repository.save(material);
    }

    /**
     * Retrieves all stored materials.
     *
     * @return a list of all materials
     */
    public List<Material> getAllMaterials() {
        return repository.findAll();
    }

    /**
     * Finds a material by its name. Used during product creation
     * to look up and reuse existing material definitions.
     *
     * @param name the name of the material to find
     * @return the matching Material, or null if not found
     */
    public Material findMaterialByName(String name) {
        return repository.findByName(name);
    }
}
