package spring.boot.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spring.boot.data.model.Customer;

import java.util.List;
import java.util.stream.Stream;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query("select c from Customer c where c.firstName = :firstName")
    Stream<Customer> findByFirstNameReturnStream(@Param("firstName") String firstName);

}
