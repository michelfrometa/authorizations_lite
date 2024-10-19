#  Architectural Patterns Selection

The architectural options considered for the project were:

- Layered Architecture (N-tier)
- Hexagonal Architecture (Ports and Adapters)
- Clean Architecture


After evaluating each option:

**Layered Architecture** offers simplicity but lacks the flexibility and scalability needed for future growth.

**Hexagonal Architecture** provides excellent decoupling of the core logic from external systems, making it easier to handle dependencies and evolving requirements.

The best choice for this system, considering extensibility, testability, and separation of concerns, was **Hexagonal Architecture**. It aligns well with the principles needed for long-term maintainability and fits naturally with the domain-centric nature of the mini-authorizer system.

For the sake of the exercise:
Given that I am comfortable with handling Clean Architecture's complexity and its principles of decoupling, flexibility, and high testability, **I will apply Clean Architecture in this project**. This decision also enables a deeper exploration of clean coding practices, ensuring that the core business logic remains completely independent of the frameworks and technologies used for persistence, user interface, or external integrations.

By choosing Clean Architecture, I accept the additional complexity it introduces but will leverage it to build a robust, scalable, and maintainable mini-authorizer system.


# Database selection

Given that I am building a financial transaction system (even though it's a mini-project), SQL would likely be the better option due to its strong support for consistency, transactions, and concurrency control, which are crucial for handling money and balances. I am going to use MySQL as the database for this project.