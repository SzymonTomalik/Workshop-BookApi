package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.domain.Book;
import pl.coderslab.domain.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books/BookList";
    }

    @GetMapping(value = "/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping(value = "/add")
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";

    }
    @GetMapping(value = "/edit/{id}")
    public String editBookForm(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "books/edit";
    }
    @PostMapping(value = "/edit")
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/edit";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "books/delete";
    }
    @PostMapping("/delete/{id}")
    public String confirmDeleteBook(Model model,@PathVariable long id) {
        model.addAttribute("book", bookService.get(id));
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

}
