package hac.services;

import hac.repo.Book;
import hac.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Book Service for the book service
 */
@Service
public class BookService {
    /**
     * Book Repository
     */
    private BookRepository repository;

    @Autowired
    BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    /**
     * to get the book repository
     *
     * @return the book repository
     */
    public List<Book> getBooks() {
        return repository.findAll();
    }

    /**
     * to save the book
     *
     * @param book the book to be saved
     */
    public void saveBook(Book book) {
        repository.save(book);
    }

    /**
     * to delete the book
     *
     * @param book the book to be deleted
     */
    public void deleteBook(Book book) {
        repository.delete(book);
    }

    /**
     * to get the book by id
     *
     * @param id the id of the book
     * @return the book by id
     */
    public Optional<Book> getBook(long id) {
        return repository.findById(id);
    }


    /**
     * Get book by title
     *
     * @param title
     * @return book with containing title
     */
    public List<Book> getBookByTitle(String title) {
        return repository.findByTitleContains(title);
    }

    /**
     * to get the top 5 book with the discount
     *
     * @return the top 5 book with the discount
     */
    public List<Book> get5mostDiscountedBooks() {
        return repository.findTop5ByOrderByDiscountDesc();
    }

    public void saveBooks(List<Book> books) {
        repository.saveAll(books);
    }
}
