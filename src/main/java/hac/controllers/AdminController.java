package hac.controllers;

import hac.repo.Book;
import hac.repo.Payment;
import hac.services.BookService;
import hac.services.PaymentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * admin controller just admin allowed
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
    /**
     * c-tor
     * @param bookService bookService autowired
     * @param paymentService  payment autowired
     */
    @Autowired
    AdminController(BookService bookService, PaymentService paymentService) {
        this.bookService = bookService;
        this.paymentService = paymentService;
    }

    private BookService bookService;
    private PaymentService paymentService;


    private static Logger logger = LoggerFactory.getLogger(AdminController.class);


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("payments", paymentService.getPayments());
        return "admin/index";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/edit-book")
    public String updateBook(@RequestParam("id") long id, Model model) {
        Book book = bookService.getBook(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("/update-book/{id}")
    public String updateBook(@PathVariable long id, @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }
        bookService.saveBook(book);
        return "redirect:/admin/";
    }

    @PostMapping("/edit-payment")
    public String updatePay(@RequestParam("id") long id, Model model) {
        Payment payment = paymentService.getPayment(id).orElseThrow(() -> new IllegalArgumentException("Invalid payment Id:" + id));
        model.addAttribute("payment", payment);
        return "update-payment";
    }

    @PostMapping("/update-payment/{id}")
    public String updatePay(@PathVariable long id, @Valid Payment payment, BindingResult result) {
        if (result.hasErrors()) {
            payment.setId(id);
            return "update-payment";
        }
        paymentService.recordNewPayment(payment);
        return "redirect:/admin/";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id, Model model) {
        Book book = bookService.getBook(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookService.deleteBook(book);
        return "redirect:/admin/";
    }

    @PostMapping("/delete-payment/{id}")
    public String deletePay(@PathVariable long id, Model model) {
        Payment payment = paymentService.getPayment(id).orElseThrow(() -> new IllegalArgumentException("Invalid payment Id:" + id));
        paymentService.deletePay(payment);
        return "redirect:/admin/";
    }


    @PostMapping("/add-book")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.saveBook(book);
        return "redirect:/admin/";
    }

    @GetMapping("add-book")
    public String showBookForm(Book book, Model model) {
        return "add-book";
    }

    @PostMapping("/add-payment")
    public String addPay(@Valid Payment payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-payment";
        }
        paymentService.recordNewPayment(payment);
        return "redirect:/admin/";
    }

    @GetMapping("add-payment")
    public String showPayForm(Payment payment, Model model) {
        return "add-payment";
    }


    /**
     * Error page that displays all exceptions.
     */
    @RequestMapping("/errorpage")
    public String error(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    /**
     * simple Error page.
     */
    @RequestMapping("/403")
    public String forbidden() {
        return "403";
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