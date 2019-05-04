package spring.boot.data.repository;

import org.springframework.data.repository.CrudRepository;
import spring.boot.data.model.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

}
