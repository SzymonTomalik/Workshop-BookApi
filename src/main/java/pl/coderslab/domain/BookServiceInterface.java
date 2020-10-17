package pl.coderslab.domain;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {

    List<Book> getBooks();
    void add(Book book);
    Optional <Book> get(Long id);
    void delete(Long id);
    void update(Book book);



}
