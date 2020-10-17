package pl.coderslab.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.domain.Book;
import pl.coderslab.domain.BookServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    private BookServiceInterface bookServiceInterface;

    public BookController(BookServiceInterface bookServiceInterface) {
        this.bookServiceInterface = bookServiceInterface;
    }

    @GetMapping("")
    public @ResponseBody
    List<Book> getList() {
        return bookServiceInterface.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookServiceInterface.add(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return this.bookServiceInterface.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unfortunately a book of this Id was not found in database");
        });
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookServiceInterface.delete(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookServiceInterface.update(book);
    }
}



