package infrastructure;

import domain.Material;
import domain.MaterialRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMaterialRepository implements MaterialRepository {
    private List<Material> materials = new ArrayList<>();

    @Override
    public void save(Material material) {
        materials.add(material);
    }

    @Override
    public List<Material> findAll() {
        return new ArrayList<>(materials);
    }

    @Override
    public Material findByName(String name) {
        for (Material material : materials) {
            if (material.getName().equalsIgnoreCase(name)) {
                return material;
            }
        }
        return null;
    }
}