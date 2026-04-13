## Sustainable Product and Recycling Management System

----------------------------------------------------------

## Team Members & Roles
* Umar Mansoor -
* Mustafa Sadir -
-----------------------------------------------------------

## Project Overview
This project is a console-based application designed to manage products, their material composition, and environmental impact. It also provides recycling guidance based on material properties.

-----------------------------------------------------------

## System Purpose OR Objective
The purpose of this system is to demonstrate software architecture principles, domain modeling, and design patterns rather than focusing solely on feature implementation, well - maintained architecture, and testability.

-----------------------------------------------------------

## Core Features
* Product creation and management
* Material definition and reuse
* Environmental impact calculation using Strategy Patterns
* Recycling guidance based on product composition

-----------------------------------------------------------

## Functional Requirements
* Product Creation
* Assignment of Materials to the Products
* Reusability of the Materials
* Product Listing and Viewing
* Environmental Impact Calculation
* Provision of Recycling Guidance 

## Non-Functional Requirements
* Testability
* Maintainability
* Extensibility
* Layered Architecture
* Professional Workflow

-----------------------------------------------------------

## Domain Concepts
* Product
* Material
* Category
* ImpactStrategy
* RecyclingService

-----------------------------------------------------------

## Architecture Overview
The system follows a layered architecture:
* Presentation Layer: Console-based user interaction
* Application Layer: Coordinates system operations
* Domain Layer: Contains core business logic

-----------------------------------------------------------

## Layered Architecture Design
The project follows a structured layered architecture consisting of Presentation, Application, Domain, and Infrastructure layers. Each layer has a clear responsibility, and dependencies flow strictly inward.

## Layer Responsibilities
### Domain Layer
* Contains core business entities such as Product and Material
* Defines abstractions like ImpactCalculationStrategy and ProductRepository
* Independent of UI, frameworks, and I/O
* No external dependencies

### Application Layer
* Contains ProductService
* Coordinates use cases (e.g., product creation, impact calculation)
* Depends only on domain abstractions
* No UI or storage logic
  
### Presentation Layer
* Contains ConsoleUI
* Handles user input and output
* Delegates all processing to the application layer

### Infrastructure Layer
* Contains InMemoryProductRepository
* Implements domain interfaces
* Can be replaced without affecting core logic

## Package Structure
src/
- domain/
  - Product.java
  - Material.java
  - MaterialComposition.java
  - Category.java
  - Lifespan.java
  - RecyclingCategory.java
  - ImpactCalculationStrategy.java
  - ProductRepository.java

- application/
  - ProductService.java

- presentation/
  - ConsoleUI.java

- infrastructure/
  - InMemoryProductRepository.java

- Main.java

## Dependency Direction
The system follows the dependency rule:
Presentation → Application → Domain
The domain layer does not depend on any other layer.
The application layer depends only on domain abstractions.
The presentation layer depends only on the application layer.
The infrastructure layer depends on domain interfaces but is not dependent on the inner layers.

## Architectural Decisions
The strategy pattern is used for impact calculation to allow easy extension of new calculation methods.
Interfaces such as ImpactCalculationStrategy and ProductRepository are placed in the domain layer to follow the Dependency Inversion Principle.
Constructor injection is used in the application layer to provide dependencies.
The architecture ensures separation of concerns, testability, and flexibility for future changes.

-----------------------------------------------------------

## Git Workflow
* "Main" Branch is protected
* Feature branches for development
* Pull requests for integration & Merging
* Code reviews before merging

### Branch Naming:
* deployment
* docs/requirements
* docs/uml-diagram
* feature/impact-strategy-design
* feature/material-model
* feature/product-management

-----------------------------------------------------------

## Development Plan
* Week 1–3: Analysis, design, and architecture (no business logic)
* Week 4+: Implementation and testing

-----------------------------------------------------------

## Documentation
* UML Class Diagram
* Sequence Diagram
* Strategy Patterns explanation

-----------------------------------------------------------
