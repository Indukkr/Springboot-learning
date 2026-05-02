# Section 8: Getting Started with JPA

## What is JPA
- Java Persistence API (Jakarta Persistence API)
- A way to map Java classes to database tables
- JPA automatically converts Java objects into database records

## Advantage of JPA
- Easy and simple to use
- Makes querying easier
- Allows saving and updating objects
- Easy integration with Spring Boot

## Data Layer
- Data layer contains repository classes
- Repositories are responsible for interacting with the database
- Repository layer handles CRUD operations
- CRUD means:
  - C → Create
  - R → Read
  - U → Update
  - D → Delete
 
## H2 Database
- H2 is an open-source Java SQL database
- It is mainly used for learning and testing purposes
- Not recommended for production projects
- It can work as an embedded or server-based database
- Official website: https://www.h2database.com

## ID Generation Strategy - IDENTITY
- Used to auto-generate primary key values
- Database automatically increments the ID
- Commonly used with MySQL and H2

## Defining JPA Repositories
- Created repository interface for entity
- Extended JpaRepository
- Used generics: <Entity, PrimaryKeyType>
- @Repository marks it as Spring component
- Repository layer provides CRUD operations automatically

## Making Category Persistent
- Used CategoryRepository inside service layer
- Replaced in-memory List<> with database repository
- Now category data is stored in database instead of memory
- Service layer interacts with repository for CRUD operations

## Using Optional in Services
- Optimized service layer code
- Used .orElseThrow() to handle missing data
- Improves error handling and code readability



