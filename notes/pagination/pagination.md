# Section11: Implementing Pagination and Sorting in our Ecommerce Project

## Pagination in Backend Applications

### What is Pagination?
Pagination is a technique used to divide large datasets into smaller chunks (pages) so data can be fetched efficiently instead of loading everything at once.

Example: Instead of fetching 10,000 records, fetch 10–20 records per request.

---

### Why Pagination is Important
- Improves API performance  
- Reduces memory usage  
- Faster response time  
- Better user experience  
- Prevents database overload  

---

### How Pagination Works
Pagination mainly uses two parameters:

- Page number → which page to fetch  
- Page size → number of records per page  

Example API request:
GET /users?page=0&size=10

Meaning:
- Fetch first page
- Return 10 records

---

### Types of Pagination

1. Offset-Based Pagination
- Uses page number and size
- Common in SQL and Spring Boot
- Example: page=2, size=10

2. Cursor-Based Pagination
- Uses a reference ID or cursor
- Better for very large datasets
- More efficient than offset for big data

---

### Pagination in Spring Boot (Spring Data JPA)

Spring Data JPA provides built-in pagination support using Pageable.

Repository:
```java
Page<User> findAll(Pageable pageable);
