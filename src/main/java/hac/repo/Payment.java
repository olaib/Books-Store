package hac.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Class of payment
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Payment {
    /**
     * id of the payment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * amount of the payment
     */
    @Positive
    @NotNull
    private int itemsAmount = 1;
    /**
     * total price of the payment - mandatory
     */
    @DecimalMin(value = "0.0", inclusive = false, message = "Please introduce a correct price")
    @NotNull
    private double totalPrice = 0;

    /**
     * date_time of the payment
     */
    @CreationTimestamp
    private LocalDateTime created_at;

    /**
     * Constructor of the payment
     *
     * @param itemsAmount to save the amount
     */
    public Payment(int itemsAmount,double totalPrice) {
        this.itemsAmount = itemsAmount;
        this.totalPrice = totalPrice;
    }
}
