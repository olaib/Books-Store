package hac.services;

import hac.Beans.CartBean;
import hac.repo.Book;
import hac.repo.Payment;
import hac.repo.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    /**
     * payment repository
     */
    private PaymentRepository repository;
    /**
     * book service
     */
    private BookService bookService;

    /**
     * @param repository  payment repository
     * @param bookService book service
     */
    @Autowired
    public PaymentService(PaymentRepository repository, BookService bookService) {
        this.repository = repository;
        this.bookService = bookService;
    }
    /**
     * total amount of payment items
     *
     * @return total amount of payment items
     */
    public int totalItems() {
        int totalAmount = repository.findAll()
                .stream()
                .mapToInt(Payment::getItemsAmount)
                .sum();
        return totalAmount;
    }

    /**
     * save new payment
     *
     * @param newRecord new payment
     */
    public void recordNewPayment(Payment newRecord){
        repository.save(newRecord);
    }

    /**
     * get all payments
     *
     * @return all payments
     */
    public List<Payment> getPayments() {
        return repository.findAll();
    }

    /**
     * pay for cart checkouts
     *
     * @param cart cart
     */
    @Transactional
    public void checkout(CartBean cart) {
        cart.getCart().forEach(book -> {
            Book b = bookService.getBook(book.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + book.getId()));
            // decrease quantity - in stock
            b.setQuantity(b.getQuantity() - book.getQuantity());
            if (b.getQuantity() < 0)
                throw new IllegalArgumentException("Not enough books in stock for book with id:" + b.getId());
                // remove book if quantity is 0
            else if (b.getQuantity() == 0)
                bookService.deleteBook(b);
        });
        recordNewPayment(new Payment(cart.booksInCart(),cart.totalPrice()));
    }

    public Optional<Payment> getPayment(Long id){
        return repository.findById(id);
    }

    public void deletePay(Payment payment) {
        repository.delete(payment);
    }
}
