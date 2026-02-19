# TinyCut 🔗

A simple **Spring Boot URL Shortener API** that converts long URLs into short, shareable links and redirects users to the original URL.

---

## How It Works

1. Client sends a `POST` request to:

   ```
   /shortURL
   ```

   with a JSON body:

   ```json
   {
     "longURL": "https://example.com"
   }
   ```

2. The controller:

   * Generates a random 6-character short code.
   * Stores the mapping (`shortCode → longURL`) using `AppService`.
   * Returns a shortened link:

   ```
   https://tinycut-pbtb.onrender.com/{shortCode}
   ```

3. When a user visits:

   ```
   /{code}
   ```

   * The app retrieves the original URL.
   * If found → returns **HTTP 302 (FOUND)** redirect.
   * If not found → returns **HTTP 404 (NOT FOUND)**.

4. Health check endpoint:

   ```
   /health
   ```

   Returns: `"Server is running!"`

---

## Tech Stack

* Spring Boot
* REST Controller (`@RestController`)
* ResponseEntity (HTTP status handling)
* Service layer architecture
* Deployed on Render

---

## Features

* Random 6-character short code generation
* RESTful API design
* HTTP redirect handling (302 status)
* Basic health check endpoint
* CORS enabled (`@CrossOrigin("*")`)

---

This project demonstrates REST API development, URL redirection using HTTP status codes, and layered Spring Boot architecture.
