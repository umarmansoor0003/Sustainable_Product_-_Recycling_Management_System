package application;

import domain.Material;
import domain.MaterialRepository;

import java.util.List;

public class MaterialService {
    private MaterialRepository repository;

    public MaterialService(MaterialRepository repository) {
        this.repository = repository;
    }

    public void createMaterial(Material material) {
        repository.save(material);
    }

    public List<Material> getAllMaterials() {
        return repository.findAll();
    }

    public Material findMaterialByName(String name) {
        return repository.findByName(name);
    }
}