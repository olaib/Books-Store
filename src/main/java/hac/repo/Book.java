package hac.repo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class that represents book
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
//@Table(name = "books")
public class Book implements Serializable {
    private final static String DEFAULT_IMAGE = "http://pngimg.com/uploads/book/book_PNG2116.png";
    /**
     * for the id - primary key for the book
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * Title of the book - mandatory
     */
    @NotEmpty(message = "Title is mandatory")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;
    /**
     *
     */
    @NotEmpty(message = "Author is mandatory")
    @Size(max = 255, message = "Author must not exceed 255 characters")
    private String author;
    /**
     * Image of the book - mandatory
     */
    @NotEmpty
    @Size(max = 255, message = "Image must not exceed 255 characters")
    private String image = DEFAULT_IMAGE;
    /**
     * Quantity of the book - mandatory
     */
    @With
    @NotNull
    @PositiveOrZero()
    private int quantity = 0;

    /**
     * Price of the book - mandatory
     */
    @DecimalMin(value = "0.0", inclusive = false, message = "Please introduce a correct size")
    @NotNull
    private double price = 0;
    /**
     * Discount of the book - mandatory
     */
    @Min(value = 0, message = "Please introduce a correct discount")
    @NotNull
    private double discount = 0;
    /**
     * Constructor for the book
     * @param title - title of the book
     * @param author - author of the book
     * @param image - image of the book
     * @param quantity - quantity of the book
     * @param price - price of the book
     * @param discount - discount of the book
     */
    public Book(String title, String author, String image, int quantity, double price, double discount) {
        this.title = title;
        this.author = author;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }


    /**
     * @return hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @param obj object to check if is equal
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj) return true;
        if(!(obj instanceof Book book)) return false;
        return Objects.equals(this.id, book.id);
    }

}


