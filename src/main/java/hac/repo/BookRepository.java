package hac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * repository of the books with all the list.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    /**
     * @return all books in the database
     */
    List<Book> findAll();

    /**
     * main function to search for a book
     *
     * @param name to search for in the books list
     * @return books list from the database that start with given title
     */
    List<Book> findByTitleContains(String name);

    /**
     * get 5 top books
     *
     * @return top 5 books by distance from database
     */
    List<Book> findTop5ByOrderByDiscountDesc();
}
