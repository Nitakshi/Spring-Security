# Basic Spring Boot Security Application

This Spring Boot project demonstrates **role-based authentication and authorization** using **Spring Security**, with users stored in an **H2 in-memory database**. It features stateless session management and includes `@PreAuthorize` security annotations for method-level access control.

---
### 📋 Prerequisites
- Java 17+
- Maven
- IDE (IntelliJ / Eclipse)

## 📌 Features

- Stateless Session Management
- In-Memory Authentication and JDBC Authentication
- Role-Based Access Control (`USER`, `ADMIN`)
- Method-Level Security with `@PreAuthorize`
- Secure access to endpoints
- Embedded H2 Database for testing
- BCrypt password encoding

---
## ⚙️ Technologies & Dependencies
- Spring Boot

- Spring Security

- Spring Data JPA

- JDBC Authentication

- H2 Database

## Annotations Used
- @RestController – Combines @Controller and @ResponseBody

- @GetMapping – Maps HTTP GET requests to handler methods

- @Configuration – Defines a Spring configuration class

- @EnableWebSecurity – Enables Spring Security for the web app

- @EnableMethodSecurity – Enables method-level security with @PreAuthorize, etc.

- @PreAuthorize – Pre-execution access control

- @PostAuthorize – Post-execution access control

- @Autowired – Automatically injects dependencies

## 📁 Endpoints

| Endpoint     | Access Role |
|--------------|-------------|
| `/greet`     | Open to all |
| `/user`      | `USER` only |
| `/admin`     | `ADMIN` only |

---

## 🔐 Security Setup Steps

### ✅ Default Authorization Setup

1. `@Configuration` – Marks the class as a source of bean definitions.
2. `@EnableWebSecurity` – Enables Spring Security’s web security support.
3. Session Policy:
   ```java
   http.sessionManagement(session -> 
       session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   
 Makes the app stateless (no cookies/session).

4. UserDetailsService – Interface used to retrieve user-related data.

5. InMemoryUserDetailsManager – Used to store users in memory.

Passwords can be stored using *{noop}* (no encryption) or encoded using BCryptPasswordEncoder.

## 🛡️ Role-Based Authentication
1. @EnableMethodSecurity – Enables method-level security.

2. @PreAuthorize – Checks authorization before method execution.

3. @PostAuthorize – Checks authorization after method execution.

## 💾 H2 Database Setup
H2 is an in-memory RDBMS ideal for dev/testing.

🔧 Setup Steps:
1. Add H2 dependency

2. Enable H2 Console

3. Allow access to /h2-console/** using:
   ``` java
   requestMatchers("/h2-console/**").permitAll()
4. Disable CSRF and allow frame from the same origin:
   ```java
   http.csrf(AbstractHttpConfigurer::disable);
   http.headers(headers -> headers.frameOptions().sameOrigin());

## 🚀 Getting Started
- Clone the repository:
   ```bash
   https://github.com/Nitakshi/Spring-Security.git
   cd springboot-security-app
   
- Build the project:

  ``` bash
  mvn clean install
  
- Run the application:

  ``` bash
  mvn spring-boot:run
  
- Visit: http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:testdb

  User Name: sa

  Password: (leave blank)
   



