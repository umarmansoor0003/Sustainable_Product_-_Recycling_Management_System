import application.MaterialService;
import application.ProductService;
import domain.CompostableGuidance;
import domain.GuidanceSelector;
import domain.HazardousGuidance;
import domain.ImpactCalculationStrategy;
import domain.LandfillableGuidance;
import domain.MaterialRepository;
import domain.MixedMaterialGuidance;
import domain.ProductRepository;
import domain.RecyclableGuidance;
import domain.SimpleImpactStrategy;
import domain.RecyclingGuide;
import infrastructure.InMemoryMaterialRepository;
import infrastructure.InMemoryProductRepository;
import presentation.ConsoleUI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new InMemoryProductRepository();
        MaterialRepository materialRepository = new InMemoryMaterialRepository();

        ImpactCalculationStrategy strategy = new SimpleImpactStrategy();

        List<RecyclingGuide> guides = List.<RecyclingGuide>of(
                new MixedMaterialGuidance(),
                new RecyclableGuidance(),
                new CompostableGuidance(),
                new HazardousGuidance(),
                new LandfillableGuidance()
        );

        GuidanceSelector selector = new GuidanceSelector(guides);

        ProductService productService = new ProductService(strategy, productRepository, selector);
        MaterialService materialService = new MaterialService(materialRepository);

        ConsoleUI consoleUI = new ConsoleUI(productService, materialService);
        consoleUI.start();
    }
}