package com.example.bookstore.controller;

import com.example.bookstore.DTO.request.BookRequest;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.BookNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Book API Rest Endpoints", description = "Operations related to books")
@RestController
@RequestMapping("api/books")
public class BookController {

    List<Book> books;

    public BookController() {
        books = new ArrayList<Book>();
        books.add(new Book((long) 1, "SOIF", "George RR Martin", "Fantasy", (short) 5));
        books.add(new Book((long) 2, "Harry Potter", "J.K. Rowling", "Fantasy", (short) 5));
        books.add(new Book((long) 3, "The Hobbit", "J.R.R. Tolkien", "Fantasy", (short) 4));
    }

    @Operation(summary = "Get book by id", description = "Retrieve a book by its id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Book getBook(@Parameter(description = "Id of the book to retrieve") @PathVariable @Min(value=1) long id) {

        return books.stream().filter(book -> book.getId() == id).findFirst().orElseThrow(() -> new BookNotFoundException("Book Not Found with id:" + id));

    }

    @Operation(summary = "Get book by title", description = "Retrieve a list of books based on title")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Book> getBookByTitle(@Parameter(description = "Optional. Title of the book to retrieve") @RequestParam(required = false) String title) {

        if (!Strings.isNullOrEmpty(title)) {
           return books;
        }

        List<Book> booksList = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                booksList.add(book);
            }
        }

        return booksList;
    }

    @Operation(summary = "Create book", description = "Create new book based on request body")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createBook(@Valid @RequestBody BookRequest bookRequest) {

        long id = !books.isEmpty() ? books.get(books.size()-1).getId()+1 : 1;

        books.add(convertToBook(id, bookRequest));

    }

    @Operation(summary = "Update book", description = "Update the book identified by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Book updateBook(@Parameter(description = "Id of the book to update") @PathVariable @Min(value=1) short id, @Valid @RequestBody BookRequest bookRequest) {
        for (int i=0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                Book newBook = convertToBook(id, bookRequest);
                books.set(i, newBook);
                return newBook;
            }
        }

        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @Operation(summary = "Delete book", description = "Delete book identified by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBook(@Parameter(description = "Id of the book to delete") @PathVariable @Min(value=1) short id) {

        boolean removed = books.removeIf(book -> book.getId() == id);
        if (!removed) throw new BookNotFoundException("Book not found with id: " + id);
    }

    private Book convertToBook(long id, BookRequest bookRequest) {
        return new Book(id, bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getGenre(), bookRequest.getRating());
    }
}
