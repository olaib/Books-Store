package hac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * We need to create a repository in order to make all the service
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    /**
     * @return list of all payments from the DB
     */
    List<Payment> findAll();
}
