# Bookstore REST API

A simple Spring Boot REST API to manage a list of books — built as an example project.

---

## Features

* **Get all books**
* **Get a book by ID**
* **Filter books by title**
* **Create a new book**
* **Update an existing book**
* **Delete a book**

---

## Endpoints

**Base URL:** `/api/books`

### Get all books

```
GET /api/books
```

**Optional query param:**

* `title` — Filter by book title (case-insensitive)

**Example:**

```
GET /api/books?title=Harry Potter
```

---

### Get book by ID

```
GET /api/books/{id}
```

* Returns `404 Not Found` if the book doesn’t exist.

---

### Create a book

```
POST /api/books
```

**Request body (JSON):**

```json
{
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "genre": "Fantasy",
  "rating": 5
}
```

* Returns `201 Created`.

---

### Update a book by ID

```
PUT /api/books/{id}
```

**Request body (JSON):**

```json
{
  "title": "The Hobbit: An Unexpected Journey",
  "author": "J.R.R. Tolkien",
  "genre": "Fantasy",
  "rating": 5
}
```

* Returns `204 No Content`.

---

### Delete a book by ID

```
DELETE /api/books/{id}
```

* Returns `204 No Content`.

---

## Tech stack

* **Spring Boot**
* **Spring Web**
* **Jakarta Validation**
* **OpenAPI/Swagger annotations**

---

## Notes

* This example uses an **in-memory list** — no database. Data resets on restart.

---

## Getting started

```bash
# Clone the repo
git clone git@github.com:your-username/your-repo.git

# Open in IntelliJ IDEA

# Run the application
./mvnw spring-boot:run
```

* Access the API at `http://localhost:8080/api/books`.

---

## API Documentation

This project uses Swagger annotations — integrate **springdoc-openapi** to generate interactive API docs at `/swagger-ui.html` if you wish.

---

## License

This project is open source and free to use.

---