package se.hkr.sustainableproduct.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.hkr.sustainableproduct.application.*;
import se.hkr.sustainableproduct.domain.*;

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
        displayMenu();

        boolean running = true;
        while (running) {
            String choice = getChoice();
            switch (choice) {
                case "1" -> handleAddProduct();
                case "2" -> handleListProducts();
                case "3" -> handleAddMaterial();
                case "4" -> handleListMaterials();
                case "5" -> handleCalculateEnvironmentImpact();
                case "6" -> handleGetRecyclingGuidance();
                case "m" -> displayMenu();
                case "0" -> {
                    running = false;
                    printOutput("Exiting program...");
                }
                default -> printOutput("Invalid option. Try again.");
            }
        }
        close();
    }

    /**
     * Displays the menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n=== Sustainable Product and Recycling Management System ===");
        System.out.println("1. Add Product");
        System.out.println("2. List Products");
        System.out.println("3. Add Material");
        System.out.println("4. List Materials");
        System.out.println("5. Calculate environmental impact");
        System.out.println("6. Provide recycling guidance");
        System.out.println("m. Print menu");
        System.out.println("0. Exit");
    }

    /**
     * Menu choice 1: Creates a product.
     */
    private void handleAddProduct() {
        String name = readString("Enter product name: ");

        // CATEGORY SELECTION
        Category category = null;
        while (category == null) {
            String input = readString("Enter category (ELECTRONICS, HOUSEHOLD, PACKAGING): ");
            try {
                category = Category.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                printOutput("Invalid category, try again.");
            }
        }

        // VALIDATION FOR LIFESPAN (YEARS)
        int lifespan = -1;
        while (lifespan < 0) {
            lifespan = readInt("Enter lifespan in years (>= 0): ");
            if (lifespan < 0) printOutput("Lifespan cannot be negative.");
        }

        // MATERIALS + QUANTITIES (Composition)
        List<String> materialNames = new ArrayList<>();
        List<Double> quantities = new ArrayList<>();

        while (true) {
            String matName = readString("Enter material name to add (or 'done' to finish): ");
            if (matName.equalsIgnoreCase("done")) break;

            // Validate material immediately
            Material material = materialService.findMaterialByName(matName);
            if (material == null) {
                printOutput("Material not found, try again.");
                continue;
            }

            // Ask for quantity only after validation
            double qty = readDouble("Enter quantity for " + matName + ": ");

            materialNames.add(matName);
            quantities.add(qty);
        }

        // CREATE PRODUCT
        productService.createProduct(name, category, new Lifespan(lifespan), materialNames, quantities);

        printOutput("Product created successfully!");
    }

    /**
     * Menu choice 2: Lists all registered products.
     */
    private void handleListProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            printOutput("No products found.");
            return;
        }

        printOutput("\n--- Registered Products ---");
        for (Product p : products) {
            printOutput(p.toString());
        }
    }

    /**
     * Menu choice 3: Creates a material.
     */
    private void handleAddMaterial() {
        String name = readString("Enter material name: ");

        // RECYCLING CATEGORY SELECTION
        RecyclingCategory r_category = null;
        while (r_category == null) {
            String input = readString("Enter recycling category (RECYCLABLE, COMPOSTABLE, HAZARDOUS, LANDFILL): ");
            try {
                r_category = RecyclingCategory.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                printOutput("Invalid recycling category, try again.");
            }
        }

        // VALIDATION FOR NEGATIVE IMPACT SCORES
        double impact = -1;
        while (impact < 0) {
            impact = readDouble("Enter base impact score (must be >= 0): ");
            if (impact < 0) {
                printOutput("Impact score cannot be negative. Try again.");
            }
        }

        // CREATE MATERIAL
        materialService.createMaterial(name, impact, r_category);

        printOutput("Material added!");
    }

    /**
     * Menu choice 4: Lists all registered materials.
     */
    private void handleListMaterials() {
        List<Material> materials = materialService.getAllMaterials();
        if (materials.isEmpty()) {
            printOutput("No materials registered.");
            return;
        }

        printOutput("\n--- Registered Materials ---");
        for (Material m : materials) {
            printOutput(m.toString());
        }
    }

    /**
     * Menu choice 5: Calculates the environmental impact of a product.
     */
    private void handleCalculateEnvironmentImpact() {
        String productName = readString("Enter product name: ");
        
        printOutput("Select strategy:");
        printOutput("1. Simple Impact");
        printOutput("2. Weighted Impact");
        
        int choice = readInt("Choose (1-2): ");
        while (choice < 1 || choice > 2) {
            printOutput("Invalid choice, try again.");
            choice = readInt("Choose (1-2): ");
        }
        
        double result = productService.calculateImpact(productName, choice);
        printOutput("Environmental impact: " + result);
    }

    /**
     * Menu choice 6: Provides recycling guidance for a product.
     */
    private void handleGetRecyclingGuidance() {
        String productName = readString("Enter product name: ");
        printOutput(productService.getRecyclingGuidance(productName));
    }

    /**
     * Gets the user's menu choice.
     * 
     * @return the user's choice as a string
     */
    private String getChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine().trim();
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to display
     */
    private void printOutput(String message) {
        System.out.println(message);
    }

    /**
     * Gets a string input from the user with a prompt.
     *
     * @param prompt the prompt to display
     * @return the user's input
     */
    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Gets an integer input from the user with a prompt.
     * Handles invalid input gracefully.
     *
     * @param prompt the prompt to display
     * @return a valid integer entered by the user
     */
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
    }

    /**
     * Gets a double input from the user with a prompt.
     * Handles invalid input gracefully.
     *
     * @param prompt the prompt to display
     * @return a valid double entered by the user
     */
    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
    }

    /**
     * Closes the scanner.
     */
    private void close() {
        scanner.close();
    }
}
