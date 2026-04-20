package domain;

import java.util.List;

public interface MaterialRepository {
    void save(Material material);
    List<Material> findAll();
    Material findByName(String name);
}