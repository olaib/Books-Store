package hac.controllers;

import hac.Beans.CartBean;
import hac.repo.Book;
import hac.services.BookService;
import hac.services.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Cart controller for session shopping cart.
 */
@Controller
public class CartController {
    @Resource(name = "sessionBeanCart")
    private CartBean cart;

    @Autowired
    CartController(BookService bookService, PaymentService paymentService) {
        this.bookService = bookService;
        this.paymentService = paymentService;
    }

    private BookService bookService;
    private PaymentService paymentService;

    /**
     * Adds a book to the shopping cart.
     *
     * @param id    The ID of the book to add.
     * @param model The model for the view.
     * @return The redirect URL after adding the book to the cart.
     */
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable long id, Model model) {
        System.out.println("id: " + id);
        Book book = bookService.getBook(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        cart.add(book);
        return "redirect:/store-page";
    }

    /**
     * Displays the shopping cart.
     *
     * @param model The model for the view.
     * @return The cart view.
     */
    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("ItemsInCart", cart.booksInCart());
        model.addAttribute("totalPrice", cart.totalPrice());
        return "cart";
    }

    /**
     * Removes a book from the shopping cart.
     *
     * @param id    The ID of the book to remove.
     * @param model The model for the view.
     * @return The redirect URL after removing the book from the cart.
     */
    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable long id, Model model) {
        Book book = bookService.getBook(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        cart.delete(book);
        return "redirect:/cart";
    }

    /**
     * Increases the quantity of a book in the shopping cart.
     *
     * @param id    The ID of the book to increase the quantity.
     * @param model The model for the view.
     * @return The redirect URL after increasing the quantity.
     */
    @GetMapping("/increase-quantity/{id}")
    public String increaseQuantity(@PathVariable long id, Model model) {
        Book book = bookService.getBook(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        book.setQuantity(book.getQuantity() + 1);
        cart.add(book);
        return "redirect:/cart";
    }

    /**
     * Decreases the quantity of a book in the shopping cart.
     *
     * @param id    The ID of the book to decrease the quantity.
     * @param model The model for the view.
     * @return The redirect URL after decreasing the quantity.
     */
    @GetMapping("/decrease-quantity/{id}")
    public String decreaseQuantity(@PathVariable long id, Model model) {
        Book book = bookService.getBook(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" +id));
        if (book.getQuantity() > 1) {
            book.setQuantity(book.getQuantity() - 1);
            cart.add(book);
        } else {
            cart.delete(book);
        }
        return "redirect:/cart";
    }

    /**
     * Clears the shopping cart.
     *
     * @param model The model for the view.
     * @return The redirect URL after clearing the cart.
     */
    @GetMapping("/clear-cart")
    public String clearCart(Model model) {
        cart.emptyCart();
        return "redirect:/cart";
    }

    /**
     * Exception handler for handling exceptions in the controller.
     *
     * @param ex    The exception that occurred.
     * @param model The model for the view.
     * @return The error view.
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex, Model model) {

        //logger.error("Exception during execution of SpringSecurity application", ex);
        String errorMessage = (ex != null ? ex.getMessage() : "Unknown error");

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}
