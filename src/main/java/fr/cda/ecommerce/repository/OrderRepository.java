package fr.cda.ecommerce.repository;

import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
