package presentation;

import application.MaterialService;
import application.ProductService;
import domain.Category;
import domain.Lifespan;
import domain.Material;
import domain.MaterialComposition;
import domain.Product;
import domain.RecyclingCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final ProductService productService;
    private final MaterialService materialService;
    private final Scanner scanner;

    public ConsoleUI(ProductService productService, MaterialService materialService) {
        this.productService = productService;
        this.materialService = materialService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> handleAddProduct();
                case "2" -> handleListProducts();
                case "3" -> handleAddMaterial();
                case "4" -> handleListMaterials();
                case "0" -> {
                    running = false;
                    System.out.println("Exiting program...");
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Sustainable Product and Recycling Management System ===");
        System.out.println("1. Add Product");
        System.out.println("2. List Products");
        System.out.println("3. Add Material");
        System.out.println("4. List Materials");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void handleAddProduct() {
        try {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter category (ELECTRONICS, HOUSEHOLD, PACKAGING): ");
            Category category = Category.valueOf(scanner.nextLine().trim().toUpperCase());

            System.out.print("Enter lifespan in years: ");
            int years = Integer.parseInt(scanner.nextLine());
            
            List<MaterialComposition> compositions = new ArrayList<>();
            while (true) {
                System.out.print("Enter material name to add (or 'done' to finish): ");
                String matName = scanner.nextLine();
                if (matName.equalsIgnoreCase("done")) break;

                Material mat = materialService.findMaterialByName(matName);
                if (mat != null) {
                    System.out.print("Enter weight in grams: ");
                    double weight = Double.parseDouble(scanner.nextLine());
                    // Matching constructor: weight then material
                    compositions.add(new MaterialComposition(weight, mat));
                } else {
                    System.out.println("Material not found. Create it first using option 3.");
                }
            }

            // Fix: Create the Product object locally and pass it to the service
            Product newProduct = new Product(name, category, new Lifespan(years), compositions);
            productService.createProduct(newProduct);
            
            System.out.println("Product created successfully!");
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    private void handleListProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        for (Product p : products) {
            System.out.println("\nProduct: " + p.getName());
            System.out.println("Category: " + p.getCategory());
            System.out.println("Impact Score: " + productService.calculateImpact(p));
            System.out.println("Recycling Info: " + productService.getRecyclingGuidance(p));
        }
    }

    private void handleAddMaterial() {
        try {
            System.out.print("Enter material name: ");
            String name = scanner.nextLine();
            System.out.print("Enter recycling category (RECYCLABLE, COMPOSTABLE, HAZARDOUS, LANDFILL): ");
            RecyclingCategory cat = RecyclingCategory.valueOf(scanner.nextLine().trim().toUpperCase());
            System.out.print("Enter base impact score (e.g., 5.0): ");
            double impact = Double.parseDouble(scanner.nextLine());

            materialService.createMaterial(new Material(name, impact, cat));
            System.out.println("Material added!");
        } catch (Exception e) {
            System.out.println("Error adding material: " + e.getMessage());
        }
    }

    private void handleListMaterials() {
        List<Material> materials = materialService.getAllMaterials();
        if (materials.isEmpty()) {
            System.out.println("No materials registered.");
            return;
        }
        System.out.println("\n--- Registered Materials ---");
        for (Material m : materials) {
            // Using getRecyclingCategory() to match your Material class's getter
            System.out.println("- " + m.getName() + " (" + m.getRecyclingCategory() + ")");
        }
    }
}