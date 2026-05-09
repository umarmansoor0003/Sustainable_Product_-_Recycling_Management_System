package se.hkr.sustainableproduct;

import java.util.ArrayList;
import java.util.List;

import se.hkr.sustainableproduct.domain.*;
import se.hkr.sustainableproduct.infrastructure.*;
import se.hkr.sustainableproduct.application.*;
import se.hkr.sustainableproduct.presentation.ConsoleUI;

/**
 * Entry point for the Sustainable Product and Recycling Management System.
 * Wires together all layers of the application and launches the console UI.
 */
public class Main {

    /**
     * Initializes all dependencies and starts the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        //´Infrastructure
        MaterialRepository materialRepo = new InMemoryMaterialRepository();
        ProductRepository productRepo = new InMemoryProductRepository();

        // Impact Calculation Strategies
        List<ImpactCalculationStrategy> impactStrategies = new ArrayList<>();
        impactStrategies.add(new WeightedImpactStrategy());
        impactStrategies.add(new SimpleImpactStrategy());

        // Recycling Guidance Strategies
        List<RecyclingGuide> recyclingGuides = new ArrayList<>();
        recyclingGuides.add(new HazardousGuidance());
        recyclingGuides.add(new RecyclableGuidance());
        recyclingGuides.add(new CompostableGuidance());
        recyclingGuides.add(new LandfillGuidance());
        recyclingGuides.add(new MixedMaterialGuidance());
        final GuidanceSelector selector = new GuidanceSelector(recyclingGuides);

        // Application Services
        MaterialService materialService = new MaterialService(materialRepo);
        ProductService productService = new ProductService(impactStrategies, productRepo, selector, materialService);

        // Presentation 
        ConsoleUI ui = new ConsoleUI(productService, materialService);
        ui.start();
    }
}