#Section 9 : Reduce Boilerplate code : Introducing Lombok

# What is Lombok

**Lombok** is a Java library that helps reduce boilerplate (lengthy repetitive) code using annotations.

Instead of manually writing getters, setters, constructors, `toString()`, `equals()`, etc., Lombok generates them automatically at compile time.

---

## Why Lombok?

- Reduces boilerplate code
- Improves readability
- Speeds up development
- Keeps classes clean and concise

---

## Commonly Used Lombok Annotations

- `@Getter` – generates getter methods  
- `@Setter` – generates setter methods  
- `@ToString` – generates `toString()`  
- `@EqualsAndHashCode` – generates `equals()` and `hashCode()`  
- `@NoArgsConstructor` – creates no-args constructor  
- `@AllArgsConstructor` – creates constructor with all fields  
- `@RequiredArgsConstructor` – constructor for final fields  
- `@Data` – combination of Getter + Setter + ToString + Equals + RequiredArgsConstructor
- `@Value` - immutable version of @Data
- `@NonNull` - Ensures a field, parameter, or method return value is not `null`
- `@Cleanup` - Automatic resource management: Call your close() methods safely with no hassle
- `@Builder` – implements Builder pattern


---
