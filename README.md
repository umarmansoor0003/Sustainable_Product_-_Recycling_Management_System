# Sustainable Product and Recycling Management System

---

## Team Members & Roles
* Umar Mansoor -
* Mustafa Sadir -
* Bruno Ihezie -
* Joseph Eka -

---

## Project Overview
This project is a console-based application designed to manage products, their material composition, and environmental impact. It also provides recycling guidance based on material properties and recycling categories.

---

## System Purpose & Objective
The purpose of this system is to demonstrate software architecture principles, domain modelling, and design patterns rather than focusing solely on feature implementation. The system prioritises well-maintained architecture, separation of concerns, and testability.

---

## Core Features
* Product creation and management
* Material definition and reuse across products
* Environmental impact calculation using the Strategy Pattern
* Recycling guidance based on product material composition and recycling categories

---

## Functional Requirements
* Product creation with name, category, lifespan and material compositions
* Assignment and reuse of materials across products
* Product listing and detailed product viewing
* Environmental impact calculation using interchangeable strategies
* Provision of recycling guidance based on material composition

## Non-Functional Requirements
* Testability
* Maintainability
* Extensibility
* Layered Architecture
* Professional Workflow

---

## Domain Concepts
* Product
* Material
* MaterialComposition
* Category
* Lifespan
* RecyclingCategory
* ImpactCalculationStrategy
* RecyclingGuide
* GuidanceSelector

---

## Technical Setup

### Prerequisites
* Java 22
* Gradle (Groovy)

### Build & Run
```bash
./gradlew build
./gradlew run
```

### Base Package
```
se.hkr.sustainableproduct
```

---

## Architecture Overview
The system follows a four-layer architecture:
* Presentation Layer: Console-based user interaction
* Application Layer: Coordinates system operations
* Domain Layer: Contains core business logic and abstractions
* Infrastructure Layer: Implements domain interfaces for storage

---

## Layered Architecture Design
The project follows a structured layered architecture consisting of Presentation, Application, Domain, and Infrastructure layers. Each layer has a clear responsibility, and dependencies flow strictly inward.

## Layer Responsibilities

### Domain Layer
* Contains core business entities: Product, Material, MaterialComposition
* Contains value objects: Category, Lifespan, RecyclingCategory
* Defines strategy abstractions: ImpactCalculationStrategy, RecyclingGuide
* Contains GuidanceSelector for runtime strategy resolution based on material categories
* Defines repository interfaces: ProductRepository, MaterialRepository
* Independent of UI, frameworks, and I/O
* No external dependencies

### Application Layer
* Contains ProductService and MaterialService
* ProductService coordinates product creation, impact calculation and recycling guidance
* ProductService depends on MaterialService internally to validate and fetch materials during product creation
* MaterialService manages material lifecycle operations independently
* Depends only on domain abstractions
* No UI or storage logic

### Presentation Layer
* Contains ConsoleUI
* Handles user input and output
* Delegates product operations to ProductService
* Delegates material definition and listing to MaterialService directly

### Infrastructure Layer
* Contains InMemoryProductRepository and InMemoryMaterialRepository
* Implements domain repository interfaces
* Can be replaced without affecting core logic

## Package Structure
```
src/
└── main/
    └── java/
        └── se/
            └── hkr/
                └── sustainableproduct/
                    ├── domain/
                    │   ├── Product.java
                    │   ├── Material.java
                    │   ├── MaterialComposition.java
                    │   ├── Category.java
                    │   ├── Lifespan.java
                    │   ├── RecyclingCategory.java
                    │   ├── ImpactCalculationStrategy.java
                    │   ├── SimpleImpactStrategy.java
                    │   ├── WeightedImpactStrategy.java
                    │   ├── RecyclingGuide.java
                    │   ├── RecyclableGuidance.java
                    │   ├── CompostableGuidance.java
                    │   ├── HazardousGuidance.java
                    │   ├── LandfillableGuidance.java
                    │   ├── MixedMaterialGuidance.java
                    │   ├── GuidanceSelector.java
                    │   ├── ProductRepository.java
                    │   └── MaterialRepository.java
                    │
                    ├── application/
                    │   ├── ProductService.java
                    │   └── MaterialService.java
                    │
                    ├── presentation/
                    │   └── ConsoleUI.java
                    │
                    └── infrastructure/
                        ├── InMemoryProductRepository.java
                        └── InMemoryMaterialRepository.java
```

> **Note:** `Main.java` sits at the root of the `sustainableproduct` package as the application entry point.

## Dependency Direction
The system follows the dependency rule:

Presentation → Application → Domain ← Infrastructure

* The domain layer does not depend on any other layer
* The application layer depends only on domain abstractions
* The presentation layer depends on both ProductService and MaterialService in the application layer
* ProductService depends on MaterialService internally for material validation during product creation
* The infrastructure layer implements domain interfaces but does not affect core logic

---

## Architectural Decisions

**Strategy Pattern — Impact Calculation**
ImpactCalculationStrategy is defined as an interface in the domain layer with two implementations: SimpleImpactStrategy and WeightedImpactStrategy. Both take List<MaterialComposition> as a parameter since impact calculation requires both the material's impact value and its quantity. Adding a new calculation method requires only a new class — no existing code is modified. This satisfies OCP.

**Strategy Pattern — Recycling Guidance**
RecyclingGuide is defined as an interface with five implementations: RecyclableGuidance, CompostableGuidance, HazardousGuidance, LandfillableGuidance, and MixedMaterialGuidance. Each implementation takes List<Material> as a parameter since recycling guidance only needs to inspect each material's recycling category, quantity is irrelevant to guidance. Adding a new category rule requires only a new class, no existing code is modified. This satisfies OCP.

**GuidanceSelector — Runtime Strategy Resolution**
GuidanceSelector holds a list of RecyclingGuide implementations and selects the appropriate one at runtime by inspecting each material's recycling category via each strategy's supports() method. This eliminates if/else branching in the service layer and satisfies OCP throughout.

**Dependency Inversion**
Interfaces such as ImpactCalculationStrategy, RecyclingGuide, ProductRepository and MaterialRepository are placed in the domain layer. The application layer depends on these abstractions, never on concrete implementations. Concrete classes are wired together only in Main, which serves as the composition root.

**Constructor Injection**
All dependencies are injected via constructors throughout the application and domain layers. No class instantiates its own dependencies internally, ensuring testability and flexibility.

**Single Responsibility**
Each class has one clearly defined reason to change. Product holds domain data only. ProductService orchestrates product-related use cases only. MaterialService manages material lifecycle only. ConsoleUI handles presentation only. Infrastructure classes handle storage only.

---

## Git Workflow
* Main branch is protected
* Feature branches for development
* Pull requests for integration and merging
* Code reviews before merging

### Branch Naming:
* deployment
* docs/requirements
* docs/uml-diagram
* feature/impact-strategy-design
* feature/material-model
* feature/product-management
* feature/recycling-guidance
* feature/presentation

---

## Development Plan
* Week 1–3: Analysis, design, and architecture (no business logic)
* Week 4+: Implementation and testing

---

## Documentation
* UML Class Diagram
* Sequence Diagram
* Strategy Pattern explanation
