package hac.controllers;

import hac.Beans.CartBean;
import hac.repo.Book;
import hac.repo.Payment;
import hac.services.BookService;
import hac.services.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@Controller
public class StoreController {
    private final String PAYMENT_FAILED = "Something happened with your payment, please try again later";
    /**
     * Cart session bean
     */
    @Resource(name = "sessionBeanCart")
    private CartBean cart;
    /**
     * Book service of the book controller
     */
    private final PaymentService paymentService;

    private final BookService bookService;

    @Autowired
    StoreController(BookService bookService, PaymentService paymentService) {
        this.bookService = bookService;
        this.paymentService = paymentService;
    }

    /**
     * Renders the main page.
     *
     * @return The name of the view template to render.
     */
    @GetMapping("/")
    public String main() {
        return "home";
    }

    /**
     * Renders the store page.
     *
     * @param model The model for the view.
     * @return The name of the view template to render.
     */
    @GetMapping("/store-page")
    public String storePage(Model model) {
        model.addAttribute("discounted_books", bookService.get5mostDiscountedBooks());
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("ItemsInCart", cart.booksInCart());
        return "store-page";
    }

    /**
     * Handles the search request for books.
     *
     * @param search The search term.
     * @param model  The model for the view.
     * @return The name of the view template to render.
     */
    @GetMapping("/search-books")
    public String searchBooks(@RequestParam("search")String search,Model model) {
        System.out.println("search: " + search);
        model.addAttribute("books", bookService.getBookByTitle(search));
        model.addAttribute("ItemsInCart", cart.booksInCart());
        return "result-page";
    }

    /**
     * renders the search page
     *
     * @return The name of the view template to render.
     */

    @GetMapping("/checkout")
    public String successPayment(Model model) {
        model.addAttribute("ItemsInCart", cart.booksInCart());
        try {
            paymentService.recordNewPayment(new Payment(cart.booksInCart(), cart.totalPrice()));
            cart.emptyCart();
        } catch (Exception e) {
            model.addAttribute("cart", cart.getCart());
            model.addAttribute("totalPrice", cart.totalPrice());
            model.addAttribute("message", PAYMENT_FAILED + e.getMessage());
            return "cart";
        }
        return "success-payment";
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex, Model model) {

        //logger.error("Exception during execution of SpringSecurity application", ex);
        String errorMessage = (ex != null ? ex.getMessage() : "Unknown error");

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

}
