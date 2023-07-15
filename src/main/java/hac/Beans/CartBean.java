package hac.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import hac.repo.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Cart Bean for the shopping cart
 */
@Getter
@Setter
@Component
public class CartBean implements Serializable {
    /**
     * cart of books
     */
    private ArrayList<Book> cart;

    /**
     * default constructor
     */
    public CartBean() {
        this.cart = new ArrayList<>();
    }

    /**
     * to add the book to the cart
     * if the book already exists in the cart, update its quantity
     * else add the book to the cart
     * @param bookToAdd the book to be added
     */
    public void add(Book bookToAdd) {
        Optional<Book> existingBook = cart.stream()
                .filter(book -> book.equals(bookToAdd))
                .findFirst();

        if (existingBook.isPresent()) {
            // Book already exists in the cart, update its quantity
            existingBook.get().setQuantity(existingBook.get().getQuantity() + 1);
        } else {
            // Book does not exist in the cart, add it to the cart
            cart.add(bookToAdd);
        }
    }

    /**
     * to empty the cart
     */
    public void emptyCart() {
        cart.clear();
    }

    /**
     * to delete the book from the cart
     *
     * @param bookToDelete the book to be deleted
     */
    public void delete(Book bookToDelete) {
        cart.remove(bookToDelete);
    }

    /**
     * to get the total number of books in the cart
     *
     * @return the total number of books in the cart
     */
    public int booksInCart() {
        int booksInCart = cart.stream()
                .mapToInt(Book::getQuantity)
                .sum();
        System.out.println("booksInCart: " + booksInCart);
        return booksInCart;
    }

    /**
     * to get the total price of the books in the cart
     * include the discount if applicable
     * @return the total price of the books in the cart
     */
    public double totalPrice() {
        double totalPrice = cart.stream()
                .mapToDouble(cartItem -> cartItem.getQuantity() * (cartItem.getPrice() - (cartItem.getPrice() * (cartItem.getDiscount() / 100))))
                .sum();
        return Math.round(totalPrice * 100.0) / 100.0;
    }
}
